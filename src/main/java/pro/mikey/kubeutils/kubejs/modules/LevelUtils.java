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

    /**
     * Spawn a structure into the world at the given block position. If the structure can not be found, nothing
     * will happen
     *
     * @param levelUgly         the current server level
     * @param structureFile     the structure file as a string version of the resource location
     * @param spawnLocation     the location you wish spawn the structure at
     */
    public void spawnStructure(ServerLevelJS levelUgly, String structureFile, BlockPos spawnLocation) {
        ResourceLocation structureLocation = new ResourceLocation(structureFile);
        ServerLevel level = levelUgly.getMinecraftLevel();

        Optional<StructureTemplate> structureTemplate = level.getServer().getStructureManager().get(structureLocation);
        structureTemplate.ifPresent(e -> e.placeInWorld(level, spawnLocation, spawnLocation, new StructurePlaceSettings(), level.random, Block.UPDATE_ALL));
    }

    /**
     * Generate a random location as a {@link BlockPos} at within two given bounds.
     *
     * @param level         the level
     * @param playerPos     the players position
     * @param min           the min range of the bounds
     * @param max           the max range of the bounds
     *
     * @return the new generated blockpos location
     */
    public BlockPos getRandomLocation(ServerLevelJS level, BlockPos playerPos, int min, int max) {
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
