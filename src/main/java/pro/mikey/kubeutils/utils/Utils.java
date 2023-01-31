package pro.mikey.kubeutils.utils;

public class Utils {
    public static final String PREFIX = "ku";
    private static final String STORAGE_PERSISTENT = "pr";
    private static final String STORAGE_GENERIC = "gn";

    public static String kuId(String suffix) {
        return String.join(".", PREFIX, STORAGE_GENERIC, suffix);
    }

    public static String kuIdStorage(String suffix) {
        return String.join(".", PREFIX, STORAGE_PERSISTENT, suffix);
    }
}
