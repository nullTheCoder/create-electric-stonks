package nullblade.createelectricalstonks;

import com.simibubi.create.Create;
import com.simibubi.create.content.AllSections;
import com.simibubi.create.content.contraptions.relays.encased.ShaftInstance;
import com.simibubi.create.content.contraptions.relays.encased.ShaftRenderer;
import com.simibubi.create.foundation.block.BlockStressDefaults;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.simibubi.create.foundation.ponder.PonderRegistrationHelper;
import com.simibubi.create.foundation.ponder.PonderTag;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
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

import static com.simibubi.create.AllTags.pickaxeOnly;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static nullblade.createelectricalstonks.Generators.*;
import static nullblade.createelectricalstonks.Motors.*;

@Mod("create_electric_stonks")
public class CreateElectricStonks {
    public static final String id = "create_electric_stonks";
    public static final NonNullSupplier<CreateRegistrate> registrate = CreateRegistrate.lazy(id);

    private static final CreateRegistrate TABBED_REGISTRATE = registrate.get().creativeModeTab(() -> StonksTab.MAIN);

    public static final BlockEntry<ConverterBlock> CONVERTER = TABBED_REGISTRATE.block("converter", ConverterBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.color(MaterialColor.METAL))
            .transform(BlockStressDefaults.setNoImpact())
            .transform(pickaxeOnly())
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntityEntry<ConverterEntity> CONVERTER_ENTITY = registrate.get()
            .tileEntity("converter", ConverterEntity::new)
            .instance(() -> ShaftInstance::new)
            .validBlock(CONVERTER)
            .renderer(() -> ShaftRenderer::new)
            .register();


    public static final BlockEntry<EnergyRelayingPoleBlock> ENERGY_RELAYING_POLE = TABBED_REGISTRATE.block("energy_relaying_pole", EnergyRelayingPoleBlock::new)
            .initialProperties(Material.DECORATION)
            .properties(p -> p.color(MaterialColor.METAL))
            .transform(pickaxeOnly())
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntityEntry<EnergyRelayingPoleEntity> ENERGY_RELAYING_POLE_ENTITY = registrate.get()
            .tileEntity("energy_relaying_pole", EnergyRelayingPoleEntity::new)
            .validBlock(ENERGY_RELAYING_POLE)
            .register();

    static final PonderRegistrationHelper HELPER = new PonderRegistrationHelper(id);

    public CreateElectricStonks() {
        new StonksTab("create_electric_stonks_tab");

        CraftingItems.init();
        ModBlocks.init();
        Create.registrate().addToSection(GENERATOR, AllSections.KINETICS);
        Create.registrate().addToSection(MOTOR, AllSections.KINETICS);
        Create.registrate().addToSection(CONVERTER, AllSections.KINETICS);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::generalSetup);

//        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigLoader.SPEC);
    }

    private void generalSetup(final FMLCommonSetupEvent event) {
        GenerationBlocksRegistry.init();
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            HELPER.addStoryBoard(ENERGY_RELAYING_POLE, "energy_relaying_pole", Ponder::energyRelayingPole, PonderTag.DECORATION);

            HELPER.addStoryBoard(MOTOR, "motor", Ponder::motor, PonderTag.KINETIC_SOURCES);
            HELPER.addStoryBoard(WEAK_MOTOR, "motor", Ponder::motor, PonderTag.KINETIC_SOURCES);
            HELPER.addStoryBoard(REINFORCED_MOTOR, "motor", Ponder::motor, PonderTag.KINETIC_SOURCES);
            HELPER.addStoryBoard(HEAVY_MOTOR, "motor", Ponder::motor, PonderTag.KINETIC_SOURCES);
            HELPER.addStoryBoard(REINFORCED_HEAVY_MOTOR, "motor", Ponder::motor, PonderTag.KINETIC_SOURCES);
            HELPER.addStoryBoard(SWIFT_MOTOR, "motor", Ponder::motor, PonderTag.KINETIC_SOURCES);


            HELPER.addStoryBoard(CONVERTER, "generating_electricity", Ponder::generatingElectricity, PonderTag.KINETIC_APPLIANCES);
            HELPER.addStoryBoard(GENERATOR, "generating_electricity", Ponder::generatingElectricity, PonderTag.KINETIC_APPLIANCES);
            HELPER.addStoryBoard(WEAK_GENERATOR, "generating_electricity", Ponder::generatingElectricity, PonderTag.KINETIC_APPLIANCES);
            HELPER.addStoryBoard(REINFORCED_GENERATOR, "generating_electricity", Ponder::generatingElectricity, PonderTag.KINETIC_APPLIANCES);

        });
        ItemBlockRenderTypes.setRenderLayer(GENERATOR.get(), RenderType.translucent());
    }

}