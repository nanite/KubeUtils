package pro.mikey.kubeutils.events;

import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import pro.mikey.kubeutils.kubejs.events.PlayerStarterItems;

// NOTE: Maybe move this to a single class of events?
public class OnPlayerLoginEvent {

    @SubscribeEvent
    void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (!event.getPlayer().getPersistentDataKJS().getBoolean(PlayerStarterItems.STARTER_ITEMS_GIVEN_FLAG)) {
            new PlayerStarterItems(event.getPlayer()).post(KuEvents.PLAYER_STARTER_ITEMS.id());
        }
    }
}
