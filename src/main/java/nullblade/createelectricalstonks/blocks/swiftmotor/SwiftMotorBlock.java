package nullblade.createelectricalstonks.blocks.swiftmotor;

import com.simibubi.create.foundation.block.IBE;
import net.minecraft.world.level.block.entity.BlockEntityType;
import nullblade.createelectricalstonks.MotorBaseBlock;

import static nullblade.createelectricalstonks.Motors.SWIFT_MOTOR_ENTITY;

public class SwiftMotorBlock extends MotorBaseBlock implements IBE<SwiftMotorEntity> {
    public SwiftMotorBlock(Properties arg) {
        super(arg.noOcclusion());
    }

    @Override
    public Class<SwiftMotorEntity> getBlockEntityClass() {
        return SwiftMotorEntity.class;
    }

    @Override
    public BlockEntityType<? extends SwiftMotorEntity> getBlockEntityType() {
        return SWIFT_MOTOR_ENTITY.get();
    }

}
