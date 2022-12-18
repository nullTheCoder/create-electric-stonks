package nullblade.createelectricalstonks;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.material.MaterialColor;

import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static nullblade.createelectricalstonks.CreateElectricStonks.registrate;

public class ModBlocks {

    private static final CreateRegistrate TABBED_REGISTRATE = registrate.creativeModeTab(() -> StonksTab.MAIN);


    public static BlockEntry<RotatedPillarBlock> RESONANCE_COIL_BLOCK;
    public static BlockEntry<Block> RESONATING_BLOCK;

    public static void init() {
        RESONANCE_COIL_BLOCK = TABBED_REGISTRATE.block("resonance_coil_block", RotatedPillarBlock::new)
                .initialProperties(SharedProperties::copperMetal)
                .properties(p -> p.color(MaterialColor.METAL))

                .item()
                .transform(customItemModel())
                .register();

        RESONATING_BLOCK = TABBED_REGISTRATE.block("resonating_block", Block::new)
                .initialProperties(SharedProperties::copperMetal)
                .properties(p -> p.color(MaterialColor.METAL))
                .item()
                .transform(customItemModel())
                .register();

    }

}
