package pro.mikey.kubeutils.kubejs.modules;

import dev.latvian.mods.rhino.Context;
import dev.latvian.mods.rhino.NativeObject;
import dev.latvian.mods.rhino.type.TypeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class ListsKu {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListsKu.class);

    public ListsKu() {
    }

    /**
     * Takes in a list of items that each contain a weight property and an entry property. We then will randomly
     * select one of the entries based on their weight.
     *
     * @param items List of Map<{weight: double, entry: any}>
     *
     * @return one of the items from the array
     */
    public <T> T getEntryBasedOnWeight(WeightedEntry<T>... items) {
        var inputs = Arrays.asList(items);

        double totalWeight = 0.0D;

        for (WeightedEntry<T> input : items) {
            totalWeight += input.weight;
        }

        int idx = 0;
        for (double r = Math.random() * totalWeight; idx < inputs.size() - 1; ++idx) {
            r -= inputs.get(idx).weight;
            if (r <= 0.0) break;
        }

        return inputs.get(idx).entry;
    }

    public record WeightedEntry<T>(
        T entry,
        double weight
    ) {}
}
