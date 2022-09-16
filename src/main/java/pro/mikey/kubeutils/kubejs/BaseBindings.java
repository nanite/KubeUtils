package pro.mikey.kubeutils.kubejs;

import pro.mikey.kubeutils.kubejs.modules.Fluids;
import pro.mikey.kubeutils.kubejs.modules.LevelUtils;
import pro.mikey.kubeutils.kubejs.modules.ListActions;
import pro.mikey.kubeutils.kubejs.modules.Utils;

public interface BaseBindings {
    Fluids Fluids = new Fluids();
    Utils Utils = new Utils();
    ListActions Lists = new ListActions();
    LevelUtils Level = new LevelUtils();
}
