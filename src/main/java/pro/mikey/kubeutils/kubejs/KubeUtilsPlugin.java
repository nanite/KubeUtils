package pro.mikey.kubeutils.kubejs;

import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingsEvent;
import dev.latvian.mods.kubejs.script.ScriptType;
import dev.latvian.mods.kubejs.util.ClassFilter;
import pro.mikey.kubeutils.utils.Utils;

public class KubeUtilsPlugin extends KubeJSPlugin {
    @Override
    public void addBindings(BindingsEvent event) {
        event.add("Ku", BaseBindings.class);
    }

    @Override
    public void addClasses(ScriptType type, ClassFilter filter) {
        filter.deny(Utils.class);
        filter.deny(BaseBindings.class);
        filter.deny(KubeUtilsPlugin.class);
    }


}
