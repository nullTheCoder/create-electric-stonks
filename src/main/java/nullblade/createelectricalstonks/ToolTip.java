package nullblade.createelectricalstonks;


import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)

public class ToolTip {
    @SubscribeEvent
    public static void toolTip(ItemTooltipEvent e) {
        Component c = GenerationBlocksRegistry.getToolTip(e.getItemStack().getDescriptionId());
        if (c != null) {
            e.getToolTip().add(c);
        }

    }
}
