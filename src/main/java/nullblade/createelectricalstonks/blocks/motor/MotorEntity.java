package nullblade.createelectricalstonks.blocks.motor;

import com.simibubi.create.content.contraptions.base.GeneratingKineticTileEntity;
import com.simibubi.create.foundation.tileEntity.TileEntityBehaviour;
import com.simibubi.create.foundation.tileEntity.behaviour.CenteredSideValueBoxTransform;
import com.simibubi.create.foundation.tileEntity.behaviour.scrollvalue.ScrollValueBehaviour;
import com.simibubi.create.foundation.utility.Lang;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import nullblade.createelectricalstonks.Config;
import nullblade.createelectricalstonks.CreateElectricStonks;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MotorEntity extends GeneratingKineticTileEntity {

    public boolean needsPower = false;
    public EnergyStorage energyStorage;
    public LazyOptional<EnergyStorage> es;
    public ScrollValueBehaviour speedBehavior;
    public boolean powered = false;
    private int actualSpeed = 0;
    private int prvEnergy = -100000;
    private int energySpam = 0;

    public MotorEntity(BlockEntityType<?> arg, BlockPos arg2, BlockState arg3) {
        super(arg, arg2, arg3);
        energyStorage = new EnergyStorage(capacity(), receive(), Integer.MAX_VALUE, 0);
        es = LazyOptional.of(() -> energyStorage);
    }

    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, Direction side) {
        if (capability == CapabilityEnergy.ENERGY) {
            return es.cast();
        }
        return super.getCapability(capability, side);
    }

    @Override
    public void addBehaviours(List<TileEntityBehaviour> behaviours) {

        CenteredSideValueBoxTransform slot =
                new CenteredSideValueBoxTransform((motor, side) -> motor.getValue(MotorBlock.FACING) == side.getOpposite());

        speedBehavior = new ScrollValueBehaviour(Lang.translateDirect("generic.speed"), this, slot);
        speedBehavior.between(-maxSpeed(), maxSpeed());
        speedBehavior.value = getDefaultSpeed();
        speedBehavior.withUnit(i -> Lang.translateDirect("generic.unit.rpm"));
        speedBehavior.withCallback(this::updateSpeed);
        speedBehavior.withStepFunction(this::stepUpdate);
        behaviours.add(speedBehavior);
    }

    public int stepUpdate(ScrollValueBehaviour.StepContext context) { // taken straight from com.simibubi.create.content.contraptions.components.motor.CreativeMotorTileEntity
        int current = context.currentValue;
        int step = 1;

        if (!context.shift) {
            int magnitude = Math.abs(current) - (context.forward == current > 0 ? 0 : 1);

            if (magnitude >= 4)
                step *= 4;
            if (magnitude >= 32)
                step *= 4;
            if (magnitude >= 128)
                step *= 4;
        }

        return (current + (context.forward ? step : -step) == 0 ? step + 1 : step);
    }

    private void updateSpeed(Integer integer) {
        updateGeneratedRotation();
    }

    public int maxSpeed() {
        return 32;
    }

    public int getDefaultSpeed() {
        return 16;
    }

    public int getSpeedCurrent() {
        return actualSpeed;
    }

    public float stressImpact() {
        return 4f;
    }

    public int capacity() {
        return 2048;
    }

    public int receive() {
        return (int) (maxSpeed() * (stressImpact()) * Config.fEPerRotation * 1.5f);
    }

    @Override
    protected void read(CompoundTag compound, boolean clientPacket) {
        energyStorage.deserializeNBT(compound.get("energy"));
        actualSpeed = compound.getInt("aSpeed");
        needsPower = compound.getBoolean("needsPower");
        super.read(compound, clientPacket);
    }

    @Override
    protected void write(CompoundTag compound, boolean clientPacket) {
        compound.put("energy", energyStorage.serializeNBT());
        compound.putInt("aSpeed", actualSpeed);
        compound.putBoolean("needsPower", needsPower);
        super.write(compound, clientPacket);
    }

    @Override
    public float calculateStressApplied() {
        return 0;
    }

    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        tooltip.add(new TextComponent(spacing).append(new TranslatableComponent(CreateElectricStonks.id + ".energy_stored", energyStorage.getEnergyStored(), energyStorage.getMaxEnergyStored())));
        tooltip.add(new TextComponent(spacing).append(new TranslatableComponent(CreateElectricStonks.id + ".usage", (int) (Math.abs(actualSpeed) * (stressImpact()) * Config.fEPerRotation))));
        tooltip.add(new TextComponent(""));

        super.addToGoggleTooltip(tooltip, isPlayerSneaking);
        return true;
    }

    @Override
    public float calculateAddedStressCapacity() {
        this.lastCapacityProvided = stressImpact() * Config.StressImpact;
        return this.lastCapacityProvided;
    }

    @Override
    public float getGeneratedSpeed() {
        return getSpeedCurrent();
    }

    @Override
    public void tick() {
        super.tick();

        int needed = (int) (Math.abs(speedBehavior.scrollableValue) * (stressImpact()) * Config.fEPerRotation);
        if (!level.isClientSide()) {
            int e = powered == needsPower ? energyStorage.extractEnergy(needed, false) : 0;
            actualSpeed = Math.floorDiv(e, (int) (stressImpact() * Config.fEPerRotation)) * (speedBehavior.scrollableValue > 0 ? 1 : -1);
            if (actualSpeed != speed) {
                updateGeneratedRotation();
                speed = actualSpeed;
            } else if (energyStorage.getEnergyStored() != prvEnergy && energySpam > 10) {
                this.sendData();
                prvEnergy = energyStorage.getEnergyStored();
                energySpam = 0;
            }
        }
        energySpam++;
    }
}
