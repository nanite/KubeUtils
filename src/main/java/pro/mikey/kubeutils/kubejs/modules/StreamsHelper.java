package pro.mikey.kubeutils.kubejs.modules;

import dev.latvian.mods.kubejs.core.LevelKJS;
import dev.latvian.mods.kubejs.level.LevelBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;

import java.util.List;

public class StreamsHelper {
    public StreamsHelper() {
    }

    /**
     * Helper method to take a list of {@link List<BlockPos>} locations and turn them into {@link LevelBlock} objs
     *
     * @param level         the level to get the block data from
     * @param locations     the block positions
     *
     * @return List of {@link LevelBlock}
     */
    public List<LevelBlock> mapToBlock(ServerLevel level, List<BlockPos> locations) {
        return locations.stream().map(e -> ((LevelKJS) level).kjs$getBlock(e)).toList();
    }
}
