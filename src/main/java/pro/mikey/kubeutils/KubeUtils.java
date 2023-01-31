package pro.mikey.kubeutils;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pro.mikey.kubeutils.events.OnPlayerLoginEvent;

@Mod(KubeUtils.MOD_ID)
public class KubeUtils {
    public static final String MOD_ID = "kubeutils";
    public static final Logger LOGGER = LogManager.getLogger();

    public KubeUtils() {
        this.registerEvents();
    }

    private void registerEvents() {
        MinecraftForge.EVENT_BUS.register(new OnPlayerLoginEvent());
    }

    public static String getId() {
        return MOD_ID;
    }
}
