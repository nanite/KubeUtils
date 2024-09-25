package pro.mikey.kubeutils.kubejs.modules;

import dev.latvian.mods.kubejs.color.Color;
import dev.latvian.mods.kubejs.core.ComponentKJS;
import dev.latvian.mods.kubejs.core.EntityKJS;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import pro.mikey.kubeutils.kubejs.events.PlayerStarterItems;


/**
 * Some player helper methods
 */
public class PlayerKu {
    private final Player player;

    public PlayerKu(Player player) {
        this.player = player;
    }

    //#region actionBar
    /**
     * Provides a simple method for displaying a client message on the action bar. Supports all the normal things that
     * the {@link Component} class can offer whilst having alternative methods to display simpler text like a string.
     *
     * @see #showActionBar(String)
     *
     *
     * <b>Example</b>
     * <code>
     * const player = Ku.Player(event.player);
     * <p>
     * player.showActionBarComponent({
     *    "text": "Hello",
     *    "bold": true
     * })
     * </code>
     *
     * @param component The component. You can make this two ways `Component.of` or pass a raw js object
     */
    public void showActionBarComponent(Component component) {
        this.player.displayClientMessage(component, true);
    }

    public void showActionBar(String text) {
        this.player.displayClientMessage(Component.literal(text), true);
    }

    public void showActionBar(String text, Color color, boolean bold, boolean italic) {
        this.player.displayClientMessage(((ComponentKJS) ((((ComponentKJS) ((ComponentKJS) Component.literal(text)).kjs$color(color)).kjs$bold(bold)))).kjs$italic(italic), true);
    }

    public void showActionBar(String text, Color color) {
        this.showActionBar(text, color, false, false);
    }

    public void showActionBar(String text, Color color, boolean bold) {
        this.showActionBar(text, color, bold, false);
    }
    //#endregion

    /**
     * Allows you to clear the flag that prevents the {@link PlayerStarterItems} event from being called on a player
     *
     * @return if the clear happened
     */
    public boolean clearStarterItemsFlag() {
        CompoundTag kubePersistent = ((EntityKJS) this.player).kjs$getPersistentData();
        if (kubePersistent.contains(PlayerStarterItems.STARTER_ITEMS_GIVEN_FLAG) && kubePersistent.getBoolean(PlayerStarterItems.STARTER_ITEMS_GIVEN_FLAG)) {
            kubePersistent.putBoolean(PlayerStarterItems.STARTER_ITEMS_GIVEN_FLAG, false);
            return true;
        }

        return false;
    }

    /**
     * If the client is an instance of the local player of if they are a server player
     *
     * @return if the player is a client side player
     */
    public boolean isClientSide() {
        return this.player instanceof LocalPlayer;
    }
}
