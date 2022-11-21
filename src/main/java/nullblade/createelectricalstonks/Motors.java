package nullblade.createelectricalstonks;

import com.simibubi.create.content.contraptions.base.HalfShaftInstance;
import com.simibubi.create.content.contraptions.components.motor.CreativeMotorRenderer;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.material.MaterialColor;
import nullblade.createelectricalstonks.blocks.heavymotor.HeavyMotorBlock;
import nullblade.createelectricalstonks.blocks.heavymotor.HeavyMotorEntity;
import nullblade.createelectricalstonks.blocks.motor.MotorBlock;
import nullblade.createelectricalstonks.blocks.motor.MotorEntity;
import nullblade.createelectricalstonks.blocks.reinforcedheavymotor.ReinforcedHeavyMotorBlock;
import nullblade.createelectricalstonks.blocks.reinforcedheavymotor.ReinforcedHeavyMotorEntity;
import nullblade.createelectricalstonks.blocks.reinforcedmotor.ReinforcedMotorBlock;
import nullblade.createelectricalstonks.blocks.reinforcedmotor.ReinforcedMotorEntity;
import nullblade.createelectricalstonks.blocks.swiftmotor.SwiftMotorBlock;
import nullblade.createelectricalstonks.blocks.swiftmotor.SwiftMotorEntity;
import nullblade.createelectricalstonks.blocks.weakmotor.WeakMotorBlock;
import nullblade.createelectricalstonks.blocks.weakmotor.WeakMotorEntity;

import static com.simibubi.create.AllTags.pickaxeOnly;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static nullblade.createelectricalstonks.CreateElectricStonks.registrate;

public class Motors {
    private static final CreateRegistrate TABBED_REGISTRATE = registrate.get().creativeModeTab(() -> StonksTab.MAIN);

    public static final BlockEntry<MotorBlock> MOTOR = TABBED_REGISTRATE.block("motor", MotorBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.color(MaterialColor.METAL))
            .transform(pickaxeOnly())
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntityEntry<MotorEntity> MOTOR_ENTITY = registrate.get()
            .tileEntity("motor", MotorEntity::new)
            .instance(() -> HalfShaftInstance::new)
            .validBlock(MOTOR)
            .renderer(() -> CreativeMotorRenderer::new)
            .register();

    public static final BlockEntry<WeakMotorBlock> WEAK_MOTOR = TABBED_REGISTRATE.block("weak_motor", WeakMotorBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.color(MaterialColor.METAL))
            .transform(pickaxeOnly())
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntityEntry<WeakMotorEntity> WEAK_MOTOR_ENTITY = registrate.get()
            .tileEntity("weak_motor", WeakMotorEntity::new)
            .instance(() -> HalfShaftInstance::new)
            .validBlock(WEAK_MOTOR)
            .renderer(() -> CreativeMotorRenderer::new)
            .register();


    public static final BlockEntry<ReinforcedMotorBlock> REINFORCED_MOTOR = TABBED_REGISTRATE.block("reinforced_motor", ReinforcedMotorBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.color(MaterialColor.METAL))
            .transform(pickaxeOnly())
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntityEntry<ReinforcedMotorEntity> REINFORCED_MOTOR_ENTITY = registrate.get()
            .tileEntity("reinforced_motor", ReinforcedMotorEntity::new)
            .instance(() -> HalfShaftInstance::new)
            .validBlock(REINFORCED_MOTOR)
            .renderer(() -> CreativeMotorRenderer::new)
            .register();


    public static final BlockEntry<HeavyMotorBlock> HEAVY_MOTOR = TABBED_REGISTRATE.block("heavy_motor", HeavyMotorBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.color(MaterialColor.METAL))
            .transform(pickaxeOnly())
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntityEntry<HeavyMotorEntity> HEAVY_MOTOR_ENTITY = registrate.get()
            .tileEntity("heavy_motor", HeavyMotorEntity::new)
            .instance(() -> HalfShaftInstance::new)
            .validBlock(HEAVY_MOTOR)
            .renderer(() -> CreativeMotorRenderer::new)
            .register();


    public static final BlockEntry<ReinforcedHeavyMotorBlock> REINFORCED_HEAVY_MOTOR = TABBED_REGISTRATE.block("reinforced_heavy_motor", ReinforcedHeavyMotorBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.color(MaterialColor.METAL))
            .transform(pickaxeOnly())
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntityEntry<ReinforcedHeavyMotorEntity> REINFORCED_HEAVY_MOTOR_ENTITY = registrate.get()
            .tileEntity("reinforced_heavy_motor", ReinforcedHeavyMotorEntity::new)
            .instance(() -> HalfShaftInstance::new)
            .validBlock(REINFORCED_HEAVY_MOTOR)
            .renderer(() -> CreativeMotorRenderer::new)
            .register();


    public static final BlockEntry<SwiftMotorBlock> SWIFT_MOTOR = TABBED_REGISTRATE.block("swift_motor", SwiftMotorBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.color(MaterialColor.METAL))
            .transform(pickaxeOnly())
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntityEntry<SwiftMotorEntity> SWIFT_MOTOR_ENTITY = registrate.get()
            .tileEntity("swift_motor", SwiftMotorEntity::new)
            .instance(() -> HalfShaftInstance::new)
            .validBlock(SWIFT_MOTOR)
            .renderer(() -> CreativeMotorRenderer::new)
            .register();

}
