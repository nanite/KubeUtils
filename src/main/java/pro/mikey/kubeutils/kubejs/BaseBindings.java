package pro.mikey.kubeutils.kubejs;

import dev.latvian.mods.kubejs.util.ClassWrapper;
import pro.mikey.kubeutils.kubejs.modules.*;

public interface BaseBindings {
    Fluids Fluids = new Fluids();
    Utils Utils = new Utils();
    StreamsHelper Streams = new StreamsHelper();
    ListActions Lists = new ListActions();
    ClassWrapper<LevelUtils> Level = new ClassWrapper<>(LevelUtils.class);
}
