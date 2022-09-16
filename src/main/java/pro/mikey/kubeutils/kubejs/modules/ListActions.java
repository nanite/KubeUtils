package pro.mikey.kubeutils.kubejs.modules;

import dev.latvian.mods.kubejs.util.ListJS;
import dev.latvian.mods.kubejs.util.MapJS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ListActions {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListActions.class);

    public ListActions() {
    }

    /**
     * Takes in a list of objects with two properties an {@link Object} entry, and a {@link Object} weight
     * which is type cast to a double. This method will then use the weight to find a single item based on
     * a random selection that takes the items weight into consideration
     *
     * @param items {@link MapJS} of {@link Object} entry, and a {@link Object} weight
     *
     * @return one of the items from the array
     */
    public Object getEntryBasedOnWeight(ListJS items) {
        double totalWeight = 0.0;
        for (Object i : items) {
            totalWeight += ((Number) ((MapJS) i).get("weight")).doubleValue();
        }

        int idx = 0;
        for (double r = Math.random() * totalWeight; idx < items.size() - 1; ++idx) {
            r -= ((Number) ((MapJS) items.get(idx)).get("weight")).doubleValue();
            if (r <= 0.0) break;
        }

        return ((MapJS) items.get(idx)).get("entry");
    }
}
