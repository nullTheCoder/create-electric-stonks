package nullblade.createelectricalstonks.blocks.swiftmotor;

import com.simibubi.create.foundation.block.ITE;
import net.minecraft.world.level.block.entity.BlockEntityType;
import nullblade.createelectricalstonks.MotorBaseBlock;

import static nullblade.createelectricalstonks.Motors.SWIFT_MOTOR_ENTITY;

public class SwiftMotorBlock extends MotorBaseBlock implements ITE<SwiftMotorEntity> {
    public SwiftMotorBlock(Properties arg) {
        super(arg.noOcclusion());
    }

    @Override
    public Class<SwiftMotorEntity> getTileEntityClass() {
        return SwiftMotorEntity.class;
    }

    @Override
    public BlockEntityType<? extends SwiftMotorEntity> getTileEntityType() {
        return SWIFT_MOTOR_ENTITY.get();
    }

}
