package nullblade.createelectricalstonks.blocks.reinforcedmotor;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import nullblade.createelectricalstonks.blocks.motor.MotorEntity;

public class ReinforcedMotorEntity extends MotorEntity {
    public ReinforcedMotorEntity(BlockEntityType<?> arg, BlockPos arg2, BlockState arg3) {
        super(arg, arg2, arg3);
    }

    @Override
    public int maxSpeed() {
        return 128;
    }

    @Override
    public int getDefaultSpeed() {
        return 16;
    }

    @Override
    public float stressImpact() {
        return 8f;
    }

    @Override
    public int capacity() {
        return 16384;
    }
}
