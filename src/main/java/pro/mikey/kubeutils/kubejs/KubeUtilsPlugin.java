package pro.mikey.kubeutils.kubejs;

import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingsEvent;

public class KubeUtilsPlugin extends KubeJSPlugin {
    @Override
    public void addBindings(BindingsEvent event) {
        event.add("Ku", BaseBindings.class);
    }
}
