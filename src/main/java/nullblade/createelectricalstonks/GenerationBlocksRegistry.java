package nullblade.createelectricalstonks;

import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;

public class GenerationBlocksRegistry {

    private static Map<Block, Float> blockEfficiencies;
    private static Map<String, Component> blockToolTips;

    public static void init() {
        blockEfficiencies = new HashMap<>();
        blockToolTips = new HashMap<>();

        add(Blocks.REDSTONE_BLOCK, 0.05f);
        add(Blocks.LAPIS_BLOCK, 0.1f);
        add(Blocks.COPPER_BLOCK, 0.15f);
        add(Blocks.WAXED_COPPER_BLOCK, 0.15f);
        add(Blocks.OBSIDIAN, 0.20f);
        add(Blocks.END_STONE, 0.20f);
        add(Blocks.BRICKS, 0.20f);
        add(Blocks.IRON_BLOCK, 0.30f);
        add(Blocks.EMERALD_BLOCK, 0.26f);
        add(Blocks.CRYING_OBSIDIAN, 0.30f);
        add(Blocks.GOLD_BLOCK, 0.40f);
        add(ModBlocks.RESONANCE_COIL_BLOCK.get(), 0.5f);
        add(Blocks.DIAMOND_BLOCK, 0.6f);
        add(ModBlocks.RESONATING_BLOCK.get(), 0.9f);
        add(Blocks.NETHERITE_BLOCK, 0.95f);


    }

    public static void add(Block block, float efficiency) {
        blockEfficiencies.put(block, efficiency);
        blockToolTips.put(block.getDescriptionId(),
                Component.translatable("§3Redstone resonance efficiency: §r" + (int) (efficiency * 100) + "%")
        );
    }

    public static void clear() {
        blockEfficiencies.clear();
        blockToolTips.clear();
    }

    public static void remove(Block block) {
        blockEfficiencies.remove(block);
        blockToolTips.remove(block.getDescriptionId());
    }

    public static float getEfficiency(Block block) {
        Float f = blockEfficiencies.get(block);

        return f == null ? 0 : f;
    }

    public static Component getToolTip(String str) {
        return blockToolTips.get(str);
    }

    public static float getEfficiency(BlockState block) {
        return getEfficiency(block.getBlock());
    }

}
