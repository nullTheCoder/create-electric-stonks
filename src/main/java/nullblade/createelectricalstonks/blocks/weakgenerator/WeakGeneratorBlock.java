package nullblade.createelectricalstonks.blocks.weakgenerator;


import com.simibubi.create.content.kinetics.base.DirectionalKineticBlock;
import com.simibubi.create.content.kinetics.base.IRotate;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import static nullblade.createelectricalstonks.Generators.WEAK_GENERATOR_ENTITY;

public class WeakGeneratorBlock extends DirectionalKineticBlock implements IBE<WeakGeneratorEntity>, IRotate {

    protected static final VoxelShape Y_AXIS_AABB = Block.box(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
    protected static final VoxelShape Z_AXIS_AABB = Block.box(2.0, 2.0, 0.0, 14.0, 14.0, 16.0);
    protected static final VoxelShape X_AXIS_AABB = Block.box(0.0, 2.0, 2.0, 16.0, 14.0, 14.0);

    public WeakGeneratorBlock(Properties arg) {
        super(arg.noOcclusion());
    }

    public VoxelShape getShape(BlockState arg, BlockGetter arg2, BlockPos arg3, CollisionContext arg4) {
        return switch ((arg.getValue(FACING)).getAxis()) {
            case X -> X_AXIS_AABB;
            case Z -> Z_AXIS_AABB;
            case Y -> Y_AXIS_AABB;
        };
    }

    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        return face == state.getValue(FACING) || face == state.getValue(FACING).getOpposite();
    }


    @Override
    public Direction.Axis getRotationAxis(BlockState blockState) {
        return blockState.getValue(FACING).getAxis();
    }


    @Override
    public Class<WeakGeneratorEntity> getBlockEntityClass() {
        return WeakGeneratorEntity.class;
    }

    @Override
    public BlockEntityType<? extends WeakGeneratorEntity> getBlockEntityType() {
        return WEAK_GENERATOR_ENTITY.get();
    }

    @Override
    public SpeedLevel getMinimumRequiredSpeedLevel() {
        return SpeedLevel.NONE;
    }
}
