package pro.mikey.kubeutils.kubejs.modules;

import dev.latvian.mods.kubejs.level.ServerLevelJS;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
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

        var insideBox = new BoundingBox(playerPos).inflatedBy(min);
        var outsideBox = new BoundingBox(playerPos).inflatedBy(max);

        var xRandom = Mth.randomBetween(randomSource, outsideBox.minX(), outsideBox.maxX());
        var yRandom = Mth.randomBetween(randomSource, outsideBox.minY(), outsideBox.maxY());
        var zRandom = Mth.randomBetween(randomSource, outsideBox.minZ(), outsideBox.maxZ());

        var tries = 0;
        while (tries < 50) {
            var shift =  randomSource.nextDouble() < 0.5D ? -1 : 1;
            var newPos = new Vec3i(
                    xRandom * shift,
                    Mth.clamp(yRandom * shift, level.minecraftLevel.getMinBuildHeight(), level.minecraftLevel.getMaxBuildHeight()),
                    zRandom * shift
            );

            if (!insideBox.isInside(newPos)) {
                return new BlockPos(newPos.getX(), newPos.getY(), newPos.getZ());
            } else {
                tries ++;
            }
        }

        return playerPos.offset(xRandom, yRandom, zRandom);
    }
}
