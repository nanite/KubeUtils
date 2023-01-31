package pro.mikey.kubeutils.kubejs.events;

import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventHandler;

public class KuEventsGroup {
    public static final EventGroup GROUP = EventGroup.of("KuEvents");
    public static final EventHandler PLAYER_STARTING_ITEMS = GROUP.server("playerStarterItems", () -> PlayerStarterItems.class);
}
