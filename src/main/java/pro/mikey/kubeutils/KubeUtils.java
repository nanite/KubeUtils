package pro.mikey.kubeutils;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pro.mikey.kubeutils.events.OnPlayerLoginEvent;

@Mod(KubeUtils.MOD_ID)
public class KubeUtils {
    public static final String MOD_ID = "kubeutils";
    public static final Logger LOGGER = LogManager.getLogger();


    public KubeUtils() {
        NeoForge.EVENT_BUS.register(new OnPlayerLoginEvent());
    }

    public static String getId() {
        return MOD_ID;
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
