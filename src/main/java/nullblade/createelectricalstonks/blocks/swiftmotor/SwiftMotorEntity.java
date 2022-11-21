package nullblade.createelectricalstonks.blocks.swiftmotor;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import nullblade.createelectricalstonks.blocks.motor.MotorEntity;

public class SwiftMotorEntity extends MotorEntity {
    public SwiftMotorEntity(BlockEntityType<?> arg, BlockPos arg2, BlockState arg3) {
        super(arg, arg2, arg3);
    }

    @Override
    public int maxSpeed() {
        return 256;
    }

    @Override
    public int getDefaultSpeed() {
        return 32;
    }

    @Override
    public float stressImpact() {
        return 4f;
    }

    @Override
    public int capacity() {
        return 32768;
    }
}
