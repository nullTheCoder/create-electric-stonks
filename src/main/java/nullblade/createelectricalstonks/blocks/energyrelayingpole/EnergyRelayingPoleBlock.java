package nullblade.createelectricalstonks.blocks.energyrelayingpole;

import com.simibubi.create.foundation.block.IBE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RodBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import nullblade.createelectricalstonks.Config;
import nullblade.createelectricalstonks.CreateElectricStonks;

public class EnergyRelayingPoleBlock extends RodBlock implements IBE<EnergyRelayingPoleEntity> {

    public EnergyRelayingPoleBlock(Properties arg) {
        super(arg);
        this.registerDefaultState((this.stateDefinition.any()).setValue(FACING, Direction.UP));
    }

    public BlockState getStateForPlacement(BlockPlaceContext arg) {
        Direction direction = arg.getClickedFace();
        return this.defaultBlockState().setValue(FACING, direction);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> arg) {
        arg.add(FACING);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block arg4, BlockPos arg5, boolean bl) {
        if (Config.poleDisabledUpdate)
            return;

        BlockPos poss = pos.relative(state.getValue(FACING).getOpposite());
        BlockState opp = level.getBlockState(poss);
        opp.neighborChanged(level, poss, this, pos, bl);
        super.neighborChanged(state, level, pos, arg4, arg5, bl);
    }


    @Override
    public Class<EnergyRelayingPoleEntity> getBlockEntityClass() {
        return EnergyRelayingPoleEntity.class;
    }

    @Override
    public BlockEntityType<? extends EnergyRelayingPoleEntity> getBlockEntityType() {
        return CreateElectricStonks.ENERGY_RELAYING_POLE_ENTITY.get();
    }

}
