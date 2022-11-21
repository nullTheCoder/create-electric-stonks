package nullblade.createelectricalstonks;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.createElectricStonks")
public class CraftTweakerSupport {

    @ZenCodeType.Method
    public static void init() {
        GenerationBlocksRegistry.init();

        Config.fEPerRotation = 0.5f;
        Config.StressImpact = 4.0f;
        Config.generatorStrength = 16.0f;
        Config.maxPoleExtension = 16;
        Config.poleDisabledUpdate = false;
    }

    @ZenCodeType.Method
    public static void fePerRotation(float f) {
        Config.fEPerRotation = f;
    }

    @ZenCodeType.Method
    public static void stressImpact(float f) {
        Config.StressImpact = f;
    }

    @ZenCodeType.Method
    public static void generatorStrength(float f) {
        Config.generatorStrength = f;
    }

    @ZenCodeType.Method
    public static void maxPoleExtension(int i) {
        Config.maxPoleExtension = i;
    }

    @ZenCodeType.Method
    public static void poleDisableUpdate(boolean b) {
        Config.poleDisabledUpdate = b;
    }

    @ZenCodeType.Method
    public static void add(String block, float efficiency) {
        GenerationBlocksRegistry.add(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(block)), efficiency);
    }

    @ZenCodeType.Method
    public static void remove(String block) {
        GenerationBlocksRegistry.remove(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(block)));
    }

    @ZenCodeType.Method
    public static void clear() {
        GenerationBlocksRegistry.clear();
    }
}
