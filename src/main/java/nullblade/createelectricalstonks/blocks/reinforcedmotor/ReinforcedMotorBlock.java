package nullblade.createelectricalstonks.blocks.reinforcedmotor;

import com.simibubi.create.foundation.block.ITE;
import net.minecraft.world.level.block.entity.BlockEntityType;
import nullblade.createelectricalstonks.MotorBaseBlock;

import static nullblade.createelectricalstonks.Motors.REINFORCED_MOTOR_ENTITY;

public class ReinforcedMotorBlock extends MotorBaseBlock implements ITE<ReinforcedMotorEntity> {
    public ReinforcedMotorBlock(Properties arg) {
        super(arg.noOcclusion());
    }

    @Override
    public Class<ReinforcedMotorEntity> getTileEntityClass() {
        return ReinforcedMotorEntity.class;
    }

    @Override
    public BlockEntityType<? extends ReinforcedMotorEntity> getTileEntityType() {
        return REINFORCED_MOTOR_ENTITY.get();
    }

}
