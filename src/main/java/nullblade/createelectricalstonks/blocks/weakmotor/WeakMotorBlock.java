package nullblade.createelectricalstonks.blocks.weakmotor;

import com.simibubi.create.foundation.block.ITE;
import net.minecraft.world.level.block.entity.BlockEntityType;
import nullblade.createelectricalstonks.MotorBaseBlock;

import static nullblade.createelectricalstonks.Motors.WEAK_MOTOR_ENTITY;

public class WeakMotorBlock extends MotorBaseBlock implements ITE<WeakMotorEntity> {
    public WeakMotorBlock(Properties arg) {
        super(arg.noOcclusion());
    }

    @Override
    public Class<WeakMotorEntity> getTileEntityClass() {
        return WeakMotorEntity.class;
    }

    @Override
    public BlockEntityType<? extends WeakMotorEntity> getTileEntityType() {
        return WEAK_MOTOR_ENTITY.get();
    }

}
