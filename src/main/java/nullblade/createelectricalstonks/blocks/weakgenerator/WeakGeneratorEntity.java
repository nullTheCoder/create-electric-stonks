package nullblade.createelectricalstonks.blocks.weakgenerator;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import nullblade.createelectricalstonks.blocks.generator.GeneratorEntity;

public class WeakGeneratorEntity extends GeneratorEntity {

    public WeakGeneratorEntity(BlockEntityType<?> arg, BlockPos arg2, BlockState arg3) {
        super(arg, arg2, arg3);
    }

    @Override
    public float getGeneratorStrength() {
        return 0.3f;
    }

}
