package nullblade.createelectricalstonks;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import static nullblade.createelectricalstonks.Generators.GENERATOR;

public class StonksTab extends CreativeModeTab {
    public static StonksTab MAIN;

    public StonksTab(String name) {
        super(CreateElectricStonks.id + ":" + name);
        MAIN = this;
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(GENERATOR.get());
    }
}