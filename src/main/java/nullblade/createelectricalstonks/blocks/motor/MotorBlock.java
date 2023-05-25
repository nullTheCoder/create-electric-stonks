package nullblade.createelectricalstonks.blocks.motor;

import com.simibubi.create.foundation.block.IBE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import nullblade.createelectricalstonks.MotorBaseBlock;

import static nullblade.createelectricalstonks.Motors.MOTOR_ENTITY;

public class MotorBlock extends MotorBaseBlock implements IBE<MotorEntity> {
    public MotorBlock(Properties arg) {
        super(arg);
    }

    @Override
    public Direction getPreferredFacing(BlockPlaceContext context) {
        Direction f = super.getPreferredFacing(context);
        return f == null ? null : f.getOpposite();
    }

    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        return face == state.getValue(FACING);
    }

    @Override
    public Class<MotorEntity> getBlockEntityClass() {
        return MotorEntity.class;
    }

    @Override
    public BlockEntityType<? extends MotorEntity> getBlockEntityType() {
        return MOTOR_ENTITY.get();
    }
}
