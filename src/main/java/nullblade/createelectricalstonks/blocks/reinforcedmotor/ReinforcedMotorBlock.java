package nullblade.createelectricalstonks.blocks.reinforcedmotor;

import com.simibubi.create.foundation.block.IBE;
import net.minecraft.world.level.block.entity.BlockEntityType;
import nullblade.createelectricalstonks.MotorBaseBlock;

import static nullblade.createelectricalstonks.Motors.REINFORCED_MOTOR_ENTITY;

public class ReinforcedMotorBlock extends MotorBaseBlock implements IBE<ReinforcedMotorEntity> {
    public ReinforcedMotorBlock(Properties arg) {
        super(arg.noOcclusion());
    }

    @Override
    public Class<ReinforcedMotorEntity> getBlockEntityClass() {
        return ReinforcedMotorEntity.class;
    }

    @Override
    public BlockEntityType<? extends ReinforcedMotorEntity> getBlockEntityType() {
        return REINFORCED_MOTOR_ENTITY.get();
    }

}
