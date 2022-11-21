package nullblade.createelectricalstonks.blocks.reinforcedgenerator;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import nullblade.createelectricalstonks.blocks.generator.GeneratorEntity;

public class ReinforcedGeneratorEntity extends GeneratorEntity {

    public ReinforcedGeneratorEntity(BlockEntityType<?> arg, BlockPos arg2, BlockState arg3) {
        super(arg, arg2, arg3);
    }

    @Override
    public float getGeneratorStrength() {
        return 4.0f;
    }

}
