package nullblade.createelectricalstonks;

import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.content.kinetics.base.ShaftInstance;
import com.simibubi.create.content.kinetics.base.ShaftRenderer;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.simibubi.create.foundation.ponder.PonderRegistrationHelper;
import com.simibubi.create.foundation.ponder.PonderTag;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import nullblade.createelectricalstonks.blocks.energyrelayingpole.EnergyRelayingPoleBlock;
import nullblade.createelectricalstonks.blocks.energyrelayingpole.EnergyRelayingPoleEntity;
import nullblade.createelectricalstonks.blocks.fieldconverter.ConverterBlock;
import nullblade.createelectricalstonks.blocks.fieldconverter.ConverterEntity;

import java.util.Objects;

import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static nullblade.createelectricalstonks.Generators.*;
import static nullblade.createelectricalstonks.Motors.*;

@Mod("create_electric_stonks")
public class CreateElectricStonks {
    public static final String id = "create_electric_stonks";
    public static final CreateRegistrate registrate = CreateRegistrate.create(id);

    private static final CreateRegistrate TABBED_REGISTRATE = registrate.creativeModeTab(() -> StonksTab.MAIN);

    public static final BlockEntry<ConverterBlock> CONVERTER = TABBED_REGISTRATE.block("converter", ConverterBlock::new)
            .initialProperties(SharedProperties::stone)
            .transform(BlockStressDefaults.setNoImpact())
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntityEntry<ConverterEntity> CONVERTER_ENTITY = registrate
            .blockEntity("converter", ConverterEntity::new)
            .instance(() -> ShaftInstance::new)
            .validBlock(CONVERTER)
            .renderer(() -> ShaftRenderer::new)
            .register();


    public static final BlockEntry<EnergyRelayingPoleBlock> ENERGY_RELAYING_POLE = TABBED_REGISTRATE.block("energy_relaying_pole", EnergyRelayingPoleBlock::new)
            .initialProperties(Material.DECORATION)
            .properties(p -> p.color(MaterialColor.METAL))
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntityEntry<EnergyRelayingPoleEntity> ENERGY_RELAYING_POLE_ENTITY = registrate
            .blockEntity("energy_relaying_pole", EnergyRelayingPoleEntity::new)
            .validBlock(ENERGY_RELAYING_POLE)
            .register();

    static final PonderRegistrationHelper HELPER = new PonderRegistrationHelper(id);

    public CreateElectricStonks() {
        new StonksTab("create_electric_stonks_tab");

        CraftingItems.init();
        ModBlocks.init();
        registrate.registerEventListeners(FMLJavaModLoadingContext.get()
                .getModEventBus());

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::generalSetup);

        // I have no idea anymore

        Objects.requireNonNull(WEAK_GENERATOR);
        Objects.requireNonNull(GENERATOR);
        Objects.requireNonNull(REINFORCED_GENERATOR);

        Objects.requireNonNull(MOTOR);
        Objects.requireNonNull(HEAVY_MOTOR);
        Objects.requireNonNull(REINFORCED_MOTOR);
        Objects.requireNonNull(SWIFT_MOTOR);
        Objects.requireNonNull(WEAK_MOTOR);

//        ModLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigLoader.SPEC);
    }

    private void generalSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(GenerationBlocksRegistry::init);
    }


    private void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            HELPER.addStoryBoard(ENERGY_RELAYING_POLE, "energy_relaying_pole", Ponder::energyRelayingPole);

            HELPER.addStoryBoard(MOTOR, "motor", Ponder::motor);
            HELPER.addStoryBoard(WEAK_MOTOR, "motor", Ponder::motor);
            HELPER.addStoryBoard(REINFORCED_MOTOR, "motor", Ponder::motor);
            HELPER.addStoryBoard(HEAVY_MOTOR, "motor", Ponder::motor);
            HELPER.addStoryBoard(REINFORCED_HEAVY_MOTOR, "motor", Ponder::motor);
            HELPER.addStoryBoard(SWIFT_MOTOR, "motor", Ponder::motor);

            HELPER.addStoryBoard(CONVERTER, "generating_electricity", Ponder::generatingElectricity);
            HELPER.addStoryBoard(GENERATOR, "generating_electricity", Ponder::generatingElectricity);
            HELPER.addStoryBoard(WEAK_GENERATOR, "generating_electricity", Ponder::generatingElectricity);
            HELPER.addStoryBoard(REINFORCED_GENERATOR, "generating_electricity", Ponder::generatingElectricity);
        });
    }

}