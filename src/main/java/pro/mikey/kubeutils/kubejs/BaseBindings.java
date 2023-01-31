package pro.mikey.kubeutils.kubejs;

import dev.latvian.mods.kubejs.util.ClassWrapper;
import pro.mikey.kubeutils.kubejs.modules.*;

public interface BaseBindings {
    FluidsKu Fluids = new FluidsKu();
    UtilsKu Utils = new UtilsKu();
    StreamsHelper Streams = new StreamsHelper();
    ListsKu Lists = new ListsKu();
    ClassWrapper<LevelKu> Level = new ClassWrapper<>(LevelKu.class);
    ClassWrapper<PlayerKu> Player = new ClassWrapper<>(PlayerKu.class);
}
