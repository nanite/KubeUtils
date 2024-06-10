package pro.mikey.kubeutils.kubejs.events;

import dev.latvian.mods.kubejs.core.EntityKJS;
import dev.latvian.mods.kubejs.event.EventResult;
import dev.latvian.mods.kubejs.item.ItemHandlerUtils;
import dev.latvian.mods.kubejs.player.PlayerEventJS;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import pro.mikey.kubeutils.events.KuEvents;
import pro.mikey.kubeutils.kubejs.modules.PlayerKu;
import pro.mikey.kubeutils.utils.Utils;
import pro.mikey.kubeutils.utils.annotations.KuEvent;

import java.util.*;

/**
 * Custom event fired when the player logins in and does not have the {@link PlayerStarterItems#STARTER_ITEMS_GIVEN_FLAG}
 * flag enabled. You can reset this flag at any point using {@link PlayerKu#clearStarterItemsFlag()}
 *
 * To add items, simply call the event and use the `addItems` method.
 * <p>
 * <code>
 * // 1.18
 * // Item.of is optional here
 * KuEvents.playerStarterItems(event => {
 *     event.addItems("5x minecraft:gold_ingot", Item.of("2x minecraft:grass_block"))
 * <p>
 *     event.addEquipmentItem("chest", "minecraft:golden_chestplate")
 *     event.addEquipmentItem("offhand", "minecraft:stone")
 * })
 * </code
 */
@KuEvent(KuEvents.PLAYER_STARTER_ITEMS)
public class PlayerStarterItems extends PlayerEventJS {
    public static final String STARTER_ITEMS_GIVEN_FLAG = Utils.kuIdStorage("sig");

    private final Player player;
    private final List<ItemStack> items = new ArrayList<>();
    private final Map<EquipmentSlot, ItemStack> armorItems = new HashMap<>();

    public String triggeredFrom = "join";

    public PlayerStarterItems(Player player) {
        this.player = player;
    }

    public PlayerStarterItems(Player player, String triggeredFrom) {
        this.player = player;
        this.triggeredFrom = triggeredFrom;
    }

    public void addItems(ItemStack... items) {
        this.items.addAll(List.of(items));
    }

    public void addEquipmentItem(String equipmentSlot, ItemStack item) {
        var slot = Arrays.stream(EquipmentSlot.values())
                .filter(e -> e.getName().equalsIgnoreCase(equipmentSlot))
                .findFirst()
                .orElse(EquipmentSlot.CHEST);

        this.armorItems.put(slot, item);
    }


    @Override
    protected void afterPosted(EventResult cancelled) {
        if (cancelled.interruptTrue()) {
            return;
        }

        boolean inserted = false;
        if (this.items.size() > 0) {
            this.items.forEach(item -> ItemHandlerUtils.giveItemToPlayer(this.player, item, -1));
            inserted = true;
        }

        if (this.armorItems.size() > 0) {
            this.armorItems.forEach((key, value) -> {
                this.player.setItemSlot(key, value);

                // If it didn't place, put it in their inventory
                if (this.player.getItemBySlot(key).getItem() != value.getItem()) {
                    ItemHandlerUtils.giveItemToPlayer(this.player, value, -1);
                }
            });

            inserted = true;
        }

        if (inserted) {
            ((EntityKJS) this.player).kjs$getPersistentData().putBoolean(STARTER_ITEMS_GIVEN_FLAG, true);
        }
    }

    @Override
    public Player getEntity() {
        return this.player;
    }
}
