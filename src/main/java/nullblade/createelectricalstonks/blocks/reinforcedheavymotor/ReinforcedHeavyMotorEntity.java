package nullblade.createelectricalstonks.blocks.reinforcedheavymotor;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import nullblade.createelectricalstonks.blocks.motor.MotorEntity;

public class ReinforcedHeavyMotorEntity extends MotorEntity {
    public ReinforcedHeavyMotorEntity(BlockEntityType<?> arg, BlockPos arg2, BlockState arg3) {
        super(arg, arg2, arg3);
    }

    @Override
    public int maxSpeed() {
        return 64;
    }

    @Override
    public int getDefaultSpeed() {
        return 8;
    }

    @Override
    public float stressImpact() {
        return 32f;
    }

    @Override
    public int capacity() {
        return 4194304;
    }
}
