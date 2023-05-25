package nullblade.createelectricalstonks.blocks.fieldconverter;


import com.simibubi.create.content.kinetics.base.DirectionalKineticBlock;
import com.simibubi.create.content.kinetics.base.IRotate;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import nullblade.createelectricalstonks.CreateElectricStonks;

public class ConverterBlock extends DirectionalKineticBlock implements IBE<ConverterEntity>, IRotate {

    protected static final VoxelShape Y_AXIS_AABB = Block.box(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
    protected static final VoxelShape Z_AXIS_AABB = Block.box(2.0, 2.0, 0.0, 14.0, 14.0, 16.0);
    protected static final VoxelShape X_AXIS_AABB = Block.box(0.0, 2.0, 2.0, 16.0, 14.0, 14.0);

    public ConverterBlock(Properties arg) {
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
    public Class<ConverterEntity> getBlockEntityClass() {
        return ConverterEntity.class;
    }

    @Override
    public BlockEntityType<? extends ConverterEntity> getBlockEntityType() {
        return CreateElectricStonks.CONVERTER_ENTITY.get();
    }

    @Override
    public SpeedLevel getMinimumRequiredSpeedLevel() {
        return SpeedLevel.NONE;
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block arg4, BlockPos arg5, boolean bl) {
        if (state.hasBlockEntity()) {
            BlockEntity entity = level.getBlockEntity(pos);
            if (entity instanceof ConverterEntity en) {
                en.reCache();
            }
        }
        super.neighborChanged(state, level, pos, arg4, arg5, bl);
    }

}
