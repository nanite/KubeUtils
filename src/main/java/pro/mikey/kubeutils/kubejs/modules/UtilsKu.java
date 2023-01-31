package pro.mikey.kubeutils.kubejs.modules;

import dev.latvian.mods.kubejs.level.BlockContainerJS;
import dev.latvian.mods.rhino.Undefined;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

public class UtilsKu {
    private static final ResourceLocation EMPTY_LOCATION = new ResourceLocation("minecraft:empty");
    private static final ResourceLocation AIR_LOCATION = new ResourceLocation("minecraft:air");

    public UtilsKu() {
    }

    /**
     * Simple helper to easily know if "something" is null or an empty version of itself
     *
     * @param entry the thing you want to check against
     * @return if the entry is null or Minecraft empty
     */
    public boolean nullOrEmpty(Object entry) {
        if (entry == null || Undefined.isUndefined(entry)) {
            return true;
        }

        if (entry instanceof String) {
            return entry == "" || entry.equals("minecraft:empty") || entry.equals("minecraft:air");
        } else if (entry instanceof ResourceLocation) {
            return entry.equals(EMPTY_LOCATION) || entry.equals(AIR_LOCATION);
        } else if (entry instanceof BlockContainerJS) {
            return ((BlockContainerJS) entry).getBlockState().isAir();
        } else if (entry instanceof Block) {
            return entry == Blocks.AIR;
        } else if (entry instanceof BlockState) {
            return ((BlockState) entry).isAir();
        } else if (entry instanceof Fluid) {
            return ((Fluid) entry).isSame(Fluids.EMPTY);
        } else if (entry instanceof ItemStack) {
            return entry == ItemStack.EMPTY || ((ItemStack) entry).isEmpty();
        } else if (entry instanceof Item) {
            return entry == Items.AIR;
        } else if (entry instanceof ItemEntity) {
            return ((ItemEntity) entry).isRemoved() || ((ItemEntity) entry).getItem().isEmpty();
        }

        return false;
    }

    /**
     * Inverts {@link #nullOrEmpty(Object)}
     *
     * @param entry the thing you want to check again
     *
     * @return if the input is not null or empty
     */
    public boolean notNullOrEmpty(Object entry) {
        return !nullOrEmpty(entry);
    }
}
