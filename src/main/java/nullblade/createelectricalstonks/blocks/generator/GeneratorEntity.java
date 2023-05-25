package nullblade.createelectricalstonks.blocks.generator;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import nullblade.createelectricalstonks.Config;
import nullblade.createelectricalstonks.CreateElectricStonks;
import nullblade.createelectricalstonks.GenerationBlocksRegistry;

import java.util.List;

public class GeneratorEntity extends KineticBlockEntity {

    public int generated = 0;
    public float efficiency = 0;
    public boolean given = false;
    public int[][] cacheSides;

    public GeneratorEntity(BlockEntityType<?> arg, BlockPos arg2, BlockState arg3) {
        super(arg, arg2, arg3);
    }

    public int takeEnergy() {
        if (!given) {
            given = true;
            return generated;
        }
        return 0;
    }

    @Override
    public float calculateStressApplied() {
        this.lastStressApplied = Config.StressImpact * Config.generatorStrength * getGeneratorStrength();

        return this.lastStressApplied;
    }

    public float getGeneratorStrength() {
        return 1.0f;
    }

    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        tooltip.add(new TextComponent(spacing).append(String.valueOf(generated)).append(new TranslatableComponent(CreateElectricStonks.id + ".redstone_field_strength")));
        tooltip.add(new TextComponent(spacing).append(String.valueOf((int) (efficiency * 100))).append(new TranslatableComponent(CreateElectricStonks.id + ".efficiency")));
        tooltip.add(new TextComponent(""));
        super.addToGoggleTooltip(tooltip, isPlayerSneaking);
        return true;
    }

    @Override
    public void tick() {
        if (level == null) {
            super.tick();
            return;
        }
        float speed = Math.abs(getSpeed());
        float total = 0;

        if (cacheSides == null) { // create position cache if it's a null
            Direction dir = getBlockState().getValue(GeneratorBlock.FACING);

            cacheSides = new int[8][3];
            int i = 0;
            for (int x = -1; x < 2; x++) { // if there is a better method please contribute
                if (x != 0 && dir.getStepX() != 0) continue;
                for (int y = -1; y < 2; y++) {
                    if (y != 0 && dir.getStepY() != 0) continue;
                    for (int z = -1; z < 2; z++) {
                        if (z != 0 && dir.getStepZ() != 0 || x == 0 && y == 0 & z == 0) continue;
                        cacheSides[i] = new int[]{
                                x,
                                y,
                                z
                        };
                        i++;
                    }
                }
            }
        }

        for (int[] offset : cacheSides) {
            BlockState b = level.getBlockState(getBlockPos().offset(offset[0], offset[1], offset[2]));
            total += GenerationBlocksRegistry.getEfficiency(b);
        }

        efficiency = total / 8;

        generated = (int) (speed * Config.fEPerRotation * efficiency * Config.generatorStrength * getGeneratorStrength());
        given = false;

        super.tick();
    }

}
