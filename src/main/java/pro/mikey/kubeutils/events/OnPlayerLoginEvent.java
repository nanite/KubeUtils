package pro.mikey.kubeutils.events;

import dev.latvian.mods.kubejs.core.EntityKJS;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import pro.mikey.kubeutils.kubejs.events.KuEventsGroup;
import pro.mikey.kubeutils.kubejs.events.PlayerStarterItems;

// NOTE: Maybe move this to a single class of events?
public class OnPlayerLoginEvent {

    @SubscribeEvent
    void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (!((EntityKJS) event.getEntity()).kjs$getPersistentData().getBoolean(PlayerStarterItems.STARTER_ITEMS_GIVEN_FLAG)) {
            KuEventsGroup.PLAYER_STARTING_ITEMS.post(new PlayerStarterItems(event.getEntity()));
        }
    }

    @SubscribeEvent
    void onPlayerChangeDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        if (!((EntityKJS) event.getEntity()).kjs$getPersistentData().getBoolean(PlayerStarterItems.STARTER_ITEMS_GIVEN_FLAG)) {
            KuEventsGroup.PLAYER_STARTING_ITEMS.post(new PlayerStarterItems(event.getEntity(), "dimension_change"));
        }
    }
}
