package pro.mikey.kubeutils.kubejs.modules;

import dev.latvian.mods.kubejs.level.ServerLevelJS;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import java.util.Optional;

public class LevelUtils {
    public LevelUtils() {
    }

    public static void spawnStructure(ServerLevelJS levelUgly, String structureFile, BlockPos spawnLocation) {
        ResourceLocation structureLocation = new ResourceLocation(structureFile);
        ServerLevel level = levelUgly.getMinecraftLevel();

        Optional<StructureTemplate> structureTemplate = level.getServer().getStructureManager().get(structureLocation);
        structureTemplate.ifPresent(e -> e.placeInWorld(level, spawnLocation, spawnLocation, new StructurePlaceSettings(), level.random, Block.UPDATE_ALL));
    }

    public static BlockPos getRandomLocation(ServerLevelJS level, BlockPos playerPos, int min, int max) {
        var randomSource = level.minecraftLevel.random;
        var xRandom = Math.round(randomSource.nextDouble() * (max - min) + min);
        var yRandom = Math.round(randomSource.nextDouble() * (level.minecraftLevel.getMaxBuildHeight() - level.minecraftLevel.getMinBuildHeight()) + level.minecraftLevel.getMinBuildHeight());
        var zRandom = Math.round(randomSource.nextDouble() * (max - min) + min);

        var shift =  randomSource.nextDouble() < 0.5D ? -1 : 1;
        return new BlockPos(
          playerPos.getX() + (xRandom * shift),
          yRandom,
          playerPos.getZ() + (zRandom * shift)
        );
    }
}
