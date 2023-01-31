package pro.mikey.kubeutils.kubejs.modules;

import dev.latvian.mods.kubejs.util.ListJS;
import dev.latvian.mods.kubejs.util.MapJS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ListsKu {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListsKu.class);

    public ListsKu() {
    }

    /**
     * Takes in a list of objects with two properties an {@link Object} entry, and a {@link Object} weight
     * which is type cast to a double. This method will then use the weight to find a single item based on
     * a random selection that takes the items weight into consideration
     *
     * @param items List of Map<{weight: double, entry: any}>
     *
     * @return one of the items from the array
     */
    public Object getEntryBasedOnWeight(Object... items) {
        double totalWeight = 0.0;
        var inputs = ListJS.orSelf(items).stream().map(MapJS::of).toList();
        for (Map<?, ?> input : inputs) {
            totalWeight += ((Number) input.get("weight")).doubleValue();
        }

        int idx = 0;
        for (double r = Math.random() * totalWeight; idx < inputs.size() - 1; ++idx) {
            r -= ((Number) inputs.get(idx).get("weight")).doubleValue();
            if (r <= 0.0) break;
        }

        return inputs.get(idx).get("entry");
    }
}
