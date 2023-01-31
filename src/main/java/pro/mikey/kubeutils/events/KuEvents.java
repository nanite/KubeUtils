package pro.mikey.kubeutils.events;

import pro.mikey.kubeutils.utils.Utils;

public enum KuEvents {
    PLAYER_STARTER_ITEMS("player.starter-items");

    private final String id;

    KuEvents(String id) {
        this.id = "%s.%s".formatted(Utils.PREFIX, id);
    }

    public String id() {
        return id;
    }
}
