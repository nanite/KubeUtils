package pro.mikey.kubeutils.kubejs.modules;

import dev.latvian.mods.kubejs.item.ItemStackJS;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

public class Utils {
    public Utils() {
    }

    /**
     * Simple helper to easily know if something is null or an empty version of itself
     *
     * @param entry the thing you want to check against
     * @return if the entry is null or Minecraft empty
     */
    public boolean nullOrMcEmpty(Object entry) {
        if (entry == null) {
            return true;
        }

        if (entry instanceof String) {
            return entry == "" || entry.equals("minecraft:empty");
        }

        if (entry instanceof Fluid) {
            return ((Fluid) entry).isSame(Fluids.EMPTY);
        }

        return entry instanceof ItemStackJS && entry == ItemStackJS.EMPTY;
    }
}
