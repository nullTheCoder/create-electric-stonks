package nullblade.createelectricalstonks.blocks.weakmotor;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import nullblade.createelectricalstonks.blocks.motor.MotorEntity;

public class WeakMotorEntity extends MotorEntity {
    public WeakMotorEntity(BlockEntityType<?> arg, BlockPos arg2, BlockState arg3) {
        super(arg, arg2, arg3);
    }

    @Override
    public int maxSpeed() {
        return 32;
    }

    @Override
    public int getDefaultSpeed() {
        return 12;
    }

    @Override
    public float stressImpact() {
        return 2f;
    }

    @Override
    public int capacity() {
        return 1024;
    }
}
