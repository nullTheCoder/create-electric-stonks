package nullblade.createelectricalstonks.blocks.heavymotor;

import com.simibubi.create.foundation.block.ITE;
import net.minecraft.world.level.block.entity.BlockEntityType;
import nullblade.createelectricalstonks.MotorBaseBlock;

import static nullblade.createelectricalstonks.Motors.HEAVY_MOTOR_ENTITY;

public class HeavyMotorBlock extends MotorBaseBlock implements ITE<HeavyMotorEntity> {
    public HeavyMotorBlock(Properties arg) {
        super(arg.noOcclusion());
    }

    @Override
    public Class<HeavyMotorEntity> getTileEntityClass() {
        return HeavyMotorEntity.class;
    }

    @Override
    public BlockEntityType<? extends HeavyMotorEntity> getTileEntityType() {
        return HEAVY_MOTOR_ENTITY.get();
    }

}
