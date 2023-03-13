package pro.mikey.kubeutils.events;

import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import pro.mikey.kubeutils.kubejs.events.KuEventsGroup;
import pro.mikey.kubeutils.kubejs.events.PlayerStarterItems;

// NOTE: Maybe move this to a single class of events?
public class OnPlayerLoginEvent {

    @SubscribeEvent
    void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (!event.getEntity().kjs$getPersistentData().getBoolean(PlayerStarterItems.STARTER_ITEMS_GIVEN_FLAG)) {
            KuEventsGroup.PLAYER_STARTING_ITEMS.post(new PlayerStarterItems(event.getEntity()));
        }
    }

    @SubscribeEvent
    void onPlayerChangeDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        if (!event.getEntity().kjs$getPersistentData().getBoolean(PlayerStarterItems.STARTER_ITEMS_GIVEN_FLAG)) {
            KuEventsGroup.PLAYER_STARTING_ITEMS.post(new PlayerStarterItems(event.getEntity(), "dimension_change"));
        }
    }
}
