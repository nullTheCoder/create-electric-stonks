package nullblade.createelectricalstonks.blocks.heavymotor;

import com.simibubi.create.foundation.block.IBE;
import net.minecraft.world.level.block.entity.BlockEntityType;
import nullblade.createelectricalstonks.MotorBaseBlock;

import static nullblade.createelectricalstonks.Motors.HEAVY_MOTOR_ENTITY;

public class HeavyMotorBlock extends MotorBaseBlock implements IBE<HeavyMotorEntity> {
    public HeavyMotorBlock(Properties arg) {
        super(arg.noOcclusion());
    }

    @Override
    public Class<HeavyMotorEntity> getBlockEntityClass() {
        return HeavyMotorEntity.class;
    }

    @Override
    public BlockEntityType<? extends HeavyMotorEntity> getBlockEntityType() {
        return HEAVY_MOTOR_ENTITY.get();
    }

}
