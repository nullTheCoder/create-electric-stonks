package nullblade.createelectricalstonks;

import com.simibubi.create.content.kinetics.base.HalfShaftInstance;
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

import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static nullblade.createelectricalstonks.CreateElectricStonks.registrate;

public class Motors {
    private static final CreateRegistrate TABBED_REGISTRATE = registrate.creativeModeTab(() -> StonksTab.MAIN);

    public static final BlockEntry<MotorBlock> MOTOR = TABBED_REGISTRATE.block("motor", MotorBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.color(MaterialColor.METAL))
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntityEntry<MotorEntity> MOTOR_ENTITY = registrate
            .blockEntity("motor", MotorEntity::new)
            .instance(() -> HalfShaftInstance::new)
            .validBlock(MOTOR)
            .renderer(() -> HalfShaftRendererThing::new)
            .register();

    public static final BlockEntry<WeakMotorBlock> WEAK_MOTOR = TABBED_REGISTRATE.block("weak_motor", WeakMotorBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.color(MaterialColor.METAL))
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntityEntry<WeakMotorEntity> WEAK_MOTOR_ENTITY = registrate
            .blockEntity("weak_motor", WeakMotorEntity::new)
            .instance(() -> HalfShaftInstance::new)
            .validBlock(WEAK_MOTOR)
            .renderer(() ->  HalfShaftRendererThing::new)
            .register();


    public static final BlockEntry<ReinforcedMotorBlock> REINFORCED_MOTOR = TABBED_REGISTRATE.block("reinforced_motor", ReinforcedMotorBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.color(MaterialColor.METAL))
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntityEntry<ReinforcedMotorEntity> REINFORCED_MOTOR_ENTITY = registrate
            .blockEntity("reinforced_motor", ReinforcedMotorEntity::new)
            .instance(() -> HalfShaftInstance::new)
            .validBlock(REINFORCED_MOTOR)
            .renderer(() ->  HalfShaftRendererThing::new)
            .register();


    public static final BlockEntry<HeavyMotorBlock> HEAVY_MOTOR = TABBED_REGISTRATE.block("heavy_motor", HeavyMotorBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.color(MaterialColor.METAL))
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntityEntry<HeavyMotorEntity> HEAVY_MOTOR_ENTITY = registrate
            .blockEntity("heavy_motor", HeavyMotorEntity::new)
            .instance(() -> HalfShaftInstance::new)
            .validBlock(HEAVY_MOTOR)
            .renderer(() ->  HalfShaftRendererThing::new)
            .register();


    public static final BlockEntry<ReinforcedHeavyMotorBlock> REINFORCED_HEAVY_MOTOR = TABBED_REGISTRATE.block("reinforced_heavy_motor", ReinforcedHeavyMotorBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.color(MaterialColor.METAL))
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntityEntry<ReinforcedHeavyMotorEntity> REINFORCED_HEAVY_MOTOR_ENTITY = registrate
            .blockEntity("reinforced_heavy_motor", ReinforcedHeavyMotorEntity::new)
            .instance(() -> HalfShaftInstance::new)
            .validBlock(REINFORCED_HEAVY_MOTOR)
            .renderer(() ->  HalfShaftRendererThing::new)
            .register();


    public static final BlockEntry<SwiftMotorBlock> SWIFT_MOTOR = TABBED_REGISTRATE.block("swift_motor", SwiftMotorBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.color(MaterialColor.METAL))
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntityEntry<SwiftMotorEntity> SWIFT_MOTOR_ENTITY = registrate
            .blockEntity("swift_motor", SwiftMotorEntity::new)
            .instance(() -> HalfShaftInstance::new)
            .validBlock(SWIFT_MOTOR)
            .renderer(() ->  HalfShaftRendererThing::new)
            .register();

}
