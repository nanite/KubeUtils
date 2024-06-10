package pro.mikey.kubeutils.kubejs.modules;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.Fluid;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Fluid helpers module
 */
public class FluidsKu {
    public FluidsKu() {}

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

        return BuiltInRegistries.FLUID.holders()
                .filter(e -> e.key().location().getNamespace().equals(namespace))
                .map(Holder.Reference::value)
                .filter(this::notEmpty)
                .toList();
    }

    /**
     * Same as {@link FluidsKu#getFluidsByNamespace(String)} but accepts a list of namespaces
     *
     * @param namespaces the namespaces you want to fetch the fluids for
     *
     * @return a list of fluids that belong to that namespace
     */
    public List<Fluid> getFluidsByNamespaces(@Nullable List<String> namespaces) {
        if (namespaces == null || namespaces.isEmpty()) {
            return List.of();
        }

        return BuiltInRegistries.FLUID.holders()
                .filter(e -> namespaces.stream().anyMatch(x -> e.key().location().getNamespace().equals(x)))
                .map(Holder.Reference::value)
                .filter(this::notEmpty)
                .toList();
    }

    /**
     * Checks if the fluid is not Minecrafts empty fluid
     *
     * @param fluid the fluid to check against
     *
     * @return if the fluid is not empty
     */
    public boolean notEmpty(Fluid fluid) {
        return fluid != net.minecraft.world.level.material.Fluids.EMPTY;
    }

    /**
     * Inverts the logic on notEmpty to check if the fluid is empty
     *
     * @param fluid the fluid to check against
     *
     * @return if the fluid is empty
     */
    public boolean isEmpty(Fluid fluid) {
        return !notEmpty(fluid);
    }
}
