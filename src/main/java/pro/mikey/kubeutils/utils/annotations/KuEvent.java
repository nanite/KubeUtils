package pro.mikey.kubeutils.utils.annotations;

import pro.mikey.kubeutils.events.KuEvents;

import java.lang.annotation.*;

/**
 * Right now it's just a marker, but it'll be used for docs eventually
 */
@Target(ElementType.TYPE)
public @interface KuEvent {
    KuEvents value();
}
