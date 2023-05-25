package nullblade.createelectricalstonks.blocks.fieldconverter;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import nullblade.createelectricalstonks.CreateElectricStonks;
import nullblade.createelectricalstonks.blocks.generator.GeneratorBlock;
import nullblade.createelectricalstonks.blocks.generator.GeneratorEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConverterEntity extends KineticBlockEntity {

    public int generated = 0;
    private GeneratorEntity frontGenerator = null;
    private GeneratorEntity backGenerator = null;
    private List<IEnergyStorage> outputs = null;
    private int prevGenerated = 0;

    public ConverterEntity(BlockEntityType<?> arg, BlockPos arg2, BlockState arg3) {
        super(arg, arg2, arg3);
    }

    @Override
    protected void write(CompoundTag compound, boolean clientPacket) {
        compound.putInt("generated_force", generated);
        super.write(compound, clientPacket);
    }

    @Override
    protected void read(CompoundTag compound, boolean clientPacket) {
        generated = compound.getInt("generated_force");
        super.read(compound, clientPacket);
    }

    @Override
    public float calculateStressApplied() {
        this.lastStressApplied = 0;

        return 0;
    }

    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        tooltip.add(new TextComponent(spacing).append(String.valueOf(generated)).append(new TranslatableComponent(CreateElectricStonks.id + ".generatedfe")));
        super.addToGoggleTooltip(tooltip, isPlayerSneaking);
        return true;
    }

    public void reCache() {
        outputs = new ArrayList<>();

        if (level == null) {
            return;
        }

        Direction dir = getBlockState().getValue(GeneratorBlock.FACING);

        // cache generators in front and back
        BlockEntity front = level.getBlockEntity(getBlockPos().relative(dir));
        BlockEntity back = level.getBlockEntity(getBlockPos().relative(dir.getOpposite()));
        if (front instanceof GeneratorEntity en) {
            frontGenerator = en;
        }
        if (back instanceof GeneratorEntity en) {
            backGenerator = en;
        }

        for (Direction d : Direction.values()) {
            BlockEntity b = level.getBlockEntity(getBlockPos().relative(d));
            if (b != null) {
                Optional<IEnergyStorage> le = b.getCapability(CapabilityEnergy.ENERGY, d.getOpposite()).resolve();
                le.ifPresent(storage -> outputs.add(storage));
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (level.isClientSide())
            return;

        if (outputs == null) {
            reCache();
        }

        generated = 0;

        if (frontGenerator != null) {
            generated += frontGenerator.takeEnergy();
        }
        if (backGenerator != null) {
            generated += backGenerator.takeEnergy();
        }

        if (generated != prevGenerated) {
            sendData();

            prevGenerated = generated;
        }

        int left = generated;
        for (IEnergyStorage energyStorage : outputs) {
            left = left - energyStorage.receiveEnergy(left, false);
            if (left <= 0) {
                return;
            }
        }
    }
}
