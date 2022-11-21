package nullblade.createelectricalstonks;

import com.simibubi.create.content.contraptions.relays.encased.ShaftInstance;
import com.simibubi.create.content.contraptions.relays.encased.ShaftRenderer;
import com.simibubi.create.foundation.block.BlockStressDefaults;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.material.MaterialColor;
import nullblade.createelectricalstonks.blocks.generator.GeneratorBlock;
import nullblade.createelectricalstonks.blocks.generator.GeneratorEntity;
import nullblade.createelectricalstonks.blocks.reinforcedgenerator.ReinforcedGeneratorBlock;
import nullblade.createelectricalstonks.blocks.reinforcedgenerator.ReinforcedGeneratorEntity;
import nullblade.createelectricalstonks.blocks.weakgenerator.WeakGeneratorBlock;
import nullblade.createelectricalstonks.blocks.weakgenerator.WeakGeneratorEntity;

import static com.simibubi.create.AllTags.pickaxeOnly;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static nullblade.createelectricalstonks.CreateElectricStonks.registrate;

public class Generators {

    private static final CreateRegistrate TABBED_REGISTRATE = registrate.get().creativeModeTab(() -> StonksTab.MAIN);
    public static final BlockEntry<GeneratorBlock> GENERATOR = TABBED_REGISTRATE.block("generator", GeneratorBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.color(MaterialColor.METAL))
            .transform(BlockStressDefaults.setNoImpact())
            .transform(pickaxeOnly())
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntityEntry<GeneratorEntity> GENERATOR_ENTITY = registrate.get()
            .tileEntity("generator", GeneratorEntity::new)
            .instance(() -> ShaftInstance::new)
            .validBlock(GENERATOR)
            .renderer(() -> ShaftRenderer::new)
            .register();

    public static final BlockEntry<WeakGeneratorBlock> WEAK_GENERATOR = TABBED_REGISTRATE.block("weak_generator", WeakGeneratorBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.color(MaterialColor.METAL))
            .transform(BlockStressDefaults.setNoImpact())
            .transform(pickaxeOnly())
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntityEntry<WeakGeneratorEntity> WEAK_GENERATOR_ENTITY = registrate.get()
            .tileEntity("weak_generator", WeakGeneratorEntity::new)
            .instance(() -> ShaftInstance::new)
            .validBlock(WEAK_GENERATOR)
            .renderer(() -> ShaftRenderer::new)
            .register();


    public static final BlockEntry<ReinforcedGeneratorBlock> REINFORCED_GENERATOR = TABBED_REGISTRATE.block("reinforced_generator", ReinforcedGeneratorBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.color(MaterialColor.METAL))
            .transform(BlockStressDefaults.setNoImpact())
            .transform(pickaxeOnly())
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntityEntry<ReinforcedGeneratorEntity> REINFORCED_GENERATOR_ENTITY = registrate.get()
            .tileEntity("reinforced_generator", ReinforcedGeneratorEntity::new)
            .instance(() -> ShaftInstance::new)
            .validBlock(REINFORCED_GENERATOR)
            .renderer(() -> ShaftRenderer::new)
            .register();

}
