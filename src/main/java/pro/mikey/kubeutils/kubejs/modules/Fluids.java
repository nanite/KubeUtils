package pro.mikey.kubeutils.kubejs.modules;

import dev.latvian.mods.kubejs.util.ListJS;
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

    /**
     * Same as {@link Fluids#getFluidsByNamespace(String)} but accepts a list of namespaces
     *
     * @param namespaces the namespaces you want to fetch the fluids for
     *
     * @return a list of fluids that belong to that namespace
     */
    @Nullable
    public List<Fluid> getFluidsByNamespaces(@Nullable ListJS namespaces) {
        if (namespaces == null || namespaces.isEmpty()) {
            return List.of();
        }

        return ForgeRegistries.FLUIDS.getValues().stream()
                .filter(e -> namespaces.stream().anyMatch(x -> e.getRegistryName().getNamespace().equals(x)))
                .toList();
    }
}
