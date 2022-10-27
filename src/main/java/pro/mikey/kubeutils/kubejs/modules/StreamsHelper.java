package pro.mikey.kubeutils.kubejs.modules;

import dev.latvian.mods.kubejs.level.BlockContainerJS;
import dev.latvian.mods.kubejs.level.ServerLevelJS;
import net.minecraft.core.BlockPos;

import java.util.List;

public class StreamsHelper {
    public StreamsHelper() {
    }

    /**
     * Helper method to take a list of {@link List<BlockPos>} locations and turn them into {@link BlockContainerJS} objs
     *
     * @param level         the level to get the block data from
     * @param locations     the block positions
     *
     * @return List of {@link BlockContainerJS}
     */
    public List<BlockContainerJS> mapToBlock(ServerLevelJS level, List<BlockPos> locations) {
        return locations.stream().map(level::getBlock).toList();
    }
}
