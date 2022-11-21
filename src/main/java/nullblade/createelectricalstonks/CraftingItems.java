package nullblade.createelectricalstonks;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.world.item.Item;

import static nullblade.createelectricalstonks.CreateElectricStonks.registrate;

public class CraftingItems {

    private static final CreateRegistrate TABBED_REGISTRATE = registrate.get().creativeModeTab(() -> StonksTab.MAIN);

    public static void init() {
        TABBED_REGISTRATE.item("redstone_resonance_coil", Item::new)
                .register();

        TABBED_REGISTRATE.item("advanced_redstone_resonance_coil", Item::new)
                .register();

    }

}
