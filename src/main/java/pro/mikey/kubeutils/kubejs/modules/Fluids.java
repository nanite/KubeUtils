package pro.mikey.kubeutils.kubejs.modules;

import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Fluid helpers module
 */
public class Fluids {
    public Fluids() {
    }

    /**
     * Allows the user to get a list of fluids from a specific namespace
     *
     * @param namespace the namespace
     * @return A list of fluids based on the namespace or null if no value is supplied
     */
    @Nullable
    public List<Fluid> getFluidsByNamespace(@Nullable String namespace) {
        if (namespace == null) {
            return null;
        }

        return ForgeRegistries.FLUIDS.getValues().stream()
                .filter(e -> e.getRegistryName().getNamespace().equals(namespace))
                .toList();
    }
}
