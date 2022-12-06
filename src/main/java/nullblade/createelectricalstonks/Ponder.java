package nullblade.createelectricalstonks;

import com.simibubi.create.foundation.ponder.PonderPalette;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.utility.Pointing;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Ponder {

    public static void motor(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("motor", "Using A motor to generate electric force");
        scene.configureBasePlate(0, 0, 5);
        scene.world.showSection(util.select.everywhere(), Direction.DOWN);

        scene.idle(10);
        scene.overlay.showText(65)
                .text("Motors allow you to generate rotational force from electricity.")
                .placeNearTarget()
                .pointAt(util.vector.of(2.5, 2, 2.5));

        scene.idle(70);

        scene.overlay.showText(100)
                .text("When powered with electricity it will generate rotation. The amount of electricity consumed is based on the speed and power of the motor")
                .placeNearTarget()
                .pointAt(util.vector.of(2.5, 3.2, 2.5));

        scene.world.setKineticSpeed(util.select.position(2, 2, 2), 16);
        scene.effects.rotationSpeedIndicator(util.grid.at(2, 2, 2));

        scene.idle(100);

        scene.rotateCameraY(90);

        scene.overlay.showText(75)
                .text("You can change it's speed by scrolling on it's back panel!")
                .placeNearTarget()
                .pointAt(util.vector.of(2.5, 3.2, 2.5));

        Vec3 pos = util.vector.of(2.85, 2.5, 2.5);
        scene.overlay.chaseBoundingBoxOutline(PonderPalette.WHITE, pos, new AABB(pos, pos).inflate(0.08), 60);
        scene.overlay.showControls(new InputWindowElement(util.vector.of(2.85, 2.5, 2.5), Pointing.DOWN).scroll(), 60);

        scene.idle(50);

        scene.world.setKineticSpeed(util.select.position(2, 2, 2), -16);
        scene.effects.rotationSpeedIndicator(util.grid.at(2, 2, 2));

        scene.idle(30);

        scene.world.setKineticSpeed(util.select.position(2, 2, 2), -4);
        scene.effects.rotationSpeedIndicator(util.grid.at(2, 2, 2));

        scene.rotateCameraY(-120);

        scene.idle(30);

        scene.world.setKineticSpeed(util.select.position(2, 2, 2), -32);
        scene.effects.rotationSpeedIndicator(util.grid.at(2, 2, 2));

        scene.idle(30);

        scene.world.setKineticSpeed(util.select.position(2, 2, 2), -16);
        scene.effects.rotationSpeedIndicator(util.grid.at(2, 2, 2));

        scene.idle(30);

        scene.overlay.showText(50)
                .text("By powering it with redstone you can disable it.")
                .placeNearTarget()
                .pointAt(util.vector.of(2.5, 3.2, 2.5));


        scene.idle(5);
        scene.world.setBlock(util.grid.at(2, 2, 3), Blocks.REDSTONE_TORCH.defaultBlockState(), true);
        scene.idle(5);
        scene.world.setKineticSpeed(util.select.position(2, 2, 2), 0);
        scene.idle(50);

        scene.overlay.showText(70)
                .text("You can also inverse that mechanic by clicking it with a wrench.")
                .placeNearTarget()
                .pointAt(util.vector.of(2.5, 3.2, 2.5));

        scene.idle(5);

        scene.overlay.showControls(new InputWindowElement(util.vector.of(2.5, 2.5, 2.5), Pointing.DOWN).withWrench(), 70);

        scene.idle(5);

        scene.world.setKineticSpeed(util.select.position(2, 2, 2), 16);

        scene.idle(40);

        scene.world.destroyBlock(util.grid.at(2, 2, 3));
        scene.idle(5);
        scene.world.setKineticSpeed(util.select.position(2, 2, 2), 0);

        scene.idle(50);
    }

    public static void energyRelayingPole(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("energy_relaying_pole", "Using Energy relaying poles");
        scene.configureBasePlate(0, 0, 5);
        scene.configureBasePlate(0, 0, 5);

        scene.world.showSection(util.select.layer(0), Direction.UP);
        scene.idle(2);
        scene.world.showSection(util.select.position(3, 1, 3), Direction.DOWN);
        scene.idle(2);
        scene.world.showSection(util.select.position(3, 2, 3), Direction.DOWN);
        scene.idle(2);
        scene.world.showSection(util.select.position(0, 1, 3), Direction.UP);
        scene.world.showSection(util.select.position(0, 1, 2), Direction.UP);
        scene.world.setKineticSpeed(util.select.position(0, 1, 3), 0);
        scene.world.setKineticSpeed(util.select.position(0, 1, 2), 0);

        scene.world.showSection(util.select.position(3, 1, 1), Direction.UP);
        scene.world.showSection(util.select.position(2, 1, 1), Direction.UP);
        scene.world.setKineticSpeed(util.select.position(3, 1, 1), 0);
        scene.world.setKineticSpeed(util.select.position(2, 1, 1), 0);

        scene.idle(10);

        scene.overlay.showText(200)
                .text("Energy Relaying poles are used to relay energy between two points, unlike conventional wires they can only be used forward the energy forward. Place it long short side towards the source of energy and it will power whatever block is located on the other side...")
                .placeNearTarget()
                .pointAt(util.vector.of(3, 1, 2));

        scene.world.showSection(util.select.position(3, 1, 2), Direction.DOWN);

        scene.idle(40);

        scene.world.setKineticSpeed(util.select.position(3, 1, 1), 16);
        scene.world.setKineticSpeed(util.select.position(2, 1, 1), 16);
        scene.effects.rotationSpeedIndicator(util.grid.at(3, 1, 1));

        scene.idle(80);

        scene.rotateCameraY(45);

        scene.idle(80);

        scene.world.showSection(util.select.position(2, 1, 3), Direction.DOWN);

        scene.idle(10);

        scene.overlay.showText(50)
                .text("... including themselves.")
                .placeNearTarget()
                .pointAt(util.vector.of(0, 1, 3));

        scene.world.showSection(util.select.position(1, 1, 3), Direction.DOWN);

        scene.idle(10);

        scene.world.setKineticSpeed(util.select.position(0, 1, 3), 16);
        scene.effects.rotationSpeedIndicator(util.grid.at(0, 1, 3));
        scene.world.setKineticSpeed(util.select.position(0, 1, 2), 16);
    }

    public static void generatingElectricity(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("generating_electricity", "Generating electricity");
        scene.configureBasePlate(0, 0, 5);

        scene.world.showSection(util.select.layer(0), Direction.UP);

        scene.idle(5);

        scene.world.showSection(util.select.position(2, 1, 3), Direction.DOWN);

        scene.idle(2);

        scene.world.showSection(util.select.position(2, 2, 3), Direction.DOWN);

        scene.overlay.showText(60)
                .text("This is a redstone field generator block, it generates a 'redstone field' around itself which can 'resonate' with some blocks.")
                .placeNearTarget()
                .pointAt(util.vector.of(2, 2.5, 3.5));

        scene.idle(60);

        scene.world.showSection(util.select.position(2, 1, 2), Direction.DOWN);
        scene.world.showSection(util.select.position(2, 1, 4), Direction.DOWN);

        scene.idle(5);

        scene.world.showSection(util.select.position(2, 2, 2), Direction.DOWN);
        scene.world.showSection(util.select.position(2, 2, 4), Direction.DOWN);

        scene.idle(5);

        scene.world.showSection(util.select.position(2, 3, 2), Direction.DOWN);
        scene.world.showSection(util.select.position(2, 3, 3), Direction.DOWN);
        scene.world.showSection(util.select.position(2, 3, 4), Direction.DOWN);

        scene.overlay.showText(100)
                .text("When surrounded with certain blocks it will create 'redstone resonance', different blocks give different resonance efficiency.")
                .placeNearTarget()
                .pointAt(util.vector.of(2, 2.2, 3.5));

        scene.idle(5);

        scene.world.showSection(util.select.position(1, 2, 3), Direction.WEST);

        scene.overlay.showText(20)
                .text("20% efficiency")
                .placeNearTarget()
                .pointAt(util.vector.of(2, 3.5, 3.5));

        scene.idle(20);

        int[][] generatorBlockPos = new int[][]{
                {2, 1, 2},
                {2, 1, 3},
                {2, 1, 4},

                {2, 2, 2},
                {2, 2, 4},

                {2, 3, 2},
                {2, 3, 3},
                {2, 3, 4},
        };

        for (int[] pos : generatorBlockPos) {
            scene.world.replaceBlocks(util.select.position(pos[0], pos[1], pos[2]), Blocks.DIAMOND_BLOCK.defaultBlockState(), true);
            scene.idle(2);
        }

        scene.overlay.showText(20)
                .text("34% efficiency")
                .placeNearTarget()
                .pointAt(util.vector.of(2, 3.5, 3.5));

        scene.idle(20);

        for (int[] pos : generatorBlockPos) {
            scene.world.replaceBlocks(util.select.position(pos[0], pos[1], pos[2]), Blocks.COPPER_BLOCK.defaultBlockState(), true);
            scene.idle(2);
        }

        scene.overlay.showText(20)
                .text("14% efficiency")
                .placeNearTarget()
                .pointAt(util.vector.of(2, 3.5, 3.5));

        scene.idle(20);

        for (int[] pos : generatorBlockPos) {
            scene.world.replaceBlocks(util.select.position(pos[0], pos[1], pos[2]), Blocks.REDSTONE_BLOCK.defaultBlockState(), true);
            scene.idle(2);
        }

        scene.overlay.showText(20)
                .text("5% efficiency")
                .placeNearTarget()
                .pointAt(util.vector.of(2, 3.5, 3.5));


        scene.idle(20);

        int i = 0;
        for (int[] pos : generatorBlockPos) {
            if (i % 2 == 0) {
                scene.world.replaceBlocks(util.select.position(pos[0], pos[1], pos[2]), Blocks.COPPER_BLOCK.defaultBlockState(), true);
            } else if (i % 3 == 0) {
                scene.world.replaceBlocks(util.select.position(pos[0], pos[1], pos[2]), Blocks.DIAMOND_BLOCK.defaultBlockState(), true);
            }
            scene.idle(2);
            i++;
        }

        scene.overlay.showText(50)
                .text("You can also mismatch blocks which would then give you a median efficiency between those blocks.")
                .placeNearTarget()
                .pointAt(util.vector.of(2, 1, 3.5));

        scene.idle(40);

        scene.rotateCameraY(180);

        for (int[] pos : generatorBlockPos) {
            scene.world.replaceBlocks(util.select.position(pos[0], pos[1], pos[2]), Blocks.IRON_BLOCK.defaultBlockState(), true);
            scene.idle(2);
        }

        scene.idle(10);

        scene.world.showSection(util.select.position(3, 2, 3), Direction.UP);

        scene.idle(10);

        scene.overlay.showText(70)
                .text("To convert 'redstone resonance' strength into FE, you need to place a converter near the resonance generator")
                .placeNearTarget()
                .pointAt(util.vector.of(3, 1.5, 2));

        scene.idle(70);

        scene.overlay.showText(70)
                .text("You can then use the electricity you make.")
                .placeNearTarget()
                .pointAt(util.vector.of(3, 3.5, 2));

        scene.world.showSection(util.select.position(3, 3, 3), Direction.UP);

        scene.idle(5);

        scene.world.showSection(util.select.position(3, 4, 3), Direction.UP);

        scene.idle(5);

        scene.world.showSection(util.select.position(3, 5, 3), Direction.UP);

        scene.idle(9);

        scene.world.setKineticSpeed(util.select.position(3, 5, 3), 16);
        scene.effects.rotationSpeedIndicator(util.grid.at(3, 5, 3));

        scene.idle(53);

        scene.overlay.showText(70)
                .text("You can expand the generator however much as your kinetic stress allows it!")
                .placeNearTarget()
                .pointAt(util.vector.of(5, 0, 5));

        scene.world.showSection(util.select.everywhere(), Direction.UP);
    }
}
