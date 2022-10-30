package pro.mikey.kubeutils;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(KubeUtils.MOD_ID)
public class KubeUtils {
    public static final String MOD_ID = "kubeutils";
    public static final Logger LOGGER = LogManager.getLogger();

    public KubeUtils() {}

    public static String getId() {
        return MOD_ID;
    }
}
