package nullblade.createelectricalstonks.blocks.reinforcedheavymotor;

import com.simibubi.create.foundation.block.ITE;
import net.minecraft.world.level.block.entity.BlockEntityType;
import nullblade.createelectricalstonks.MotorBaseBlock;

import static nullblade.createelectricalstonks.Motors.REINFORCED_HEAVY_MOTOR_ENTITY;

public class ReinforcedHeavyMotorBlock extends MotorBaseBlock implements ITE<ReinforcedHeavyMotorEntity> {
    public ReinforcedHeavyMotorBlock(Properties arg) {
        super(arg.noOcclusion());
    }

    @Override
    public Class<ReinforcedHeavyMotorEntity> getTileEntityClass() {
        return ReinforcedHeavyMotorEntity.class;
    }

    @Override
    public BlockEntityType<? extends ReinforcedHeavyMotorEntity> getTileEntityType() {
        return REINFORCED_HEAVY_MOTOR_ENTITY.get();
    }

}
