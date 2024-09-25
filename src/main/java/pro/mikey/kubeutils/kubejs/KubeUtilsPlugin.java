package pro.mikey.kubeutils.kubejs;

import dev.latvian.mods.kubejs.event.EventGroupRegistry;
import dev.latvian.mods.kubejs.plugin.ClassFilter;
import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingRegistry;
import dev.latvian.mods.kubejs.script.ScriptType;
import pro.mikey.kubeutils.kubejs.events.KuEventsGroup;
import pro.mikey.kubeutils.utils.Utils;

public class KubeUtilsPlugin implements KubeJSPlugin {
    @Override
    public void registerBindings(BindingRegistry bindings){
        bindings.add("Ku", BaseBindings.class);
    }

    @Override
    public void registerEvents(EventGroupRegistry registry) {
        registry.register(KuEventsGroup.GROUP);
    }

    public void registerWrappers(ScriptType type, ClassFilter filter) {
        filter.deny(Utils.class);
        filter.deny(BaseBindings.class);
        filter.deny(KubeUtilsPlugin.class);
    }
}
