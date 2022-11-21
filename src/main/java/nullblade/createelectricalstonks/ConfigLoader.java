// Someone make this work

//package nullblade.createelectricalstonks;
//
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.common.ForgeConfigSpec;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.event.config.ModConfigEvent;
//import org.apache.commons.lang3.tuple.Pair;
//
//@Mod.EventBusSubscriber()
//public class ConfigLoader {
//
//    @SubscribeEvent
//    public static void onReload(ModConfigEvent event) {
//        System.out.println("test");
//        Config.maxPoleExtension = maxExtension.get();
//        Config.poleDisabledUpdate = noPolesUpdate.get();
//        Config.generatorStrength = generatorStr.get();
//        Config.fEPerRotation = feperrot.get();
//        Config.StressImpact = stressImpact.get();
//    }
//
//    private static final ForgeConfigSpec.ConfigValue<Integer> maxExtension;
//    private static final ForgeConfigSpec.ConfigValue<Boolean> noPolesUpdate;
//
//    private static final ForgeConfigSpec.ConfigValue<Float> generatorStr;
//
//    private static final ForgeConfigSpec.ConfigValue<Float> feperrot;
//
//    private static final ForgeConfigSpec.ConfigValue<Float> stressImpact;
//
//    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
//    public static final ForgeConfigSpec SPEC;
//
//    static {
//        BUILDER.push("Config");
//
//        maxExtension = BUILDER.comment("Max distance an electricity pole can transfer electricity")
//                .define("maxEnergyRelayingThroughPoles", 10);
//
//        noPolesUpdate = BUILDER.comment("Disable pole updates, this makes electric poles work worse however if you own a public server it would be better to disable pole updates because they could allow for creation of lag machines.")
//                .define("disablePoleUpdates", false);
//
//        generatorStr = BUILDER.comment("The multiplier over how much generators generate and how much stress they add.")
//                .define("generatorStrength", 16f);
//
//        feperrot = BUILDER.comment("The amount of FE per rotation")
//                .define("FEPerRotation", 0.5f);
//
//        stressImpact = BUILDER.comment("The stress multiplier for everything")
//                .define("stressMultiplier", 4.0f);
//
//        BUILDER.pop();
//        SPEC = BUILDER.build();
//    }
//}
