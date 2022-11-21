package nullblade.createelectricalstonks.blocks.energyrelayingpole;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import nullblade.createelectricalstonks.Config;
import org.jetbrains.annotations.NotNull;


public class EnergyRelayingPoleEntity extends BlockEntity {


    public EnergyRelayingPoleEntity(BlockEntityType<?> arg, BlockPos arg2, BlockState arg3) {
        super(arg, arg2, arg3);
    }

    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, Direction side) {
        return getCapabilityPole(0, capability, side);
    }

    public <T> LazyOptional<T> getCapabilityPole(int depth, @NotNull Capability<T> capability, Direction side) {
        Direction facing = getBlockState().getValue(EnergyRelayingPoleBlock.FACING);
        if (level != null && capability == CapabilityEnergy.ENERGY && side == facing.getOpposite() && depth < Config.maxPoleExtension) {
            BlockEntity be = level.getBlockEntity(getBlockPos().relative(facing));
            if (be instanceof EnergyRelayingPoleEntity pole) {
                return pole.getCapabilityPole(depth + 1, capability, side);
            } else if (be != null) {
                return be.getCapability(capability, side);
            }
        }
        return super.getCapability(capability, side);
    }

}
