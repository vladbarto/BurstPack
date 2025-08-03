package vlad.bartolomei.package_burst.utils;

import lombok.experimental.UtilityClass;

import java.nio.file.Path;
import java.nio.file.Paths;

@UtilityClass
public class OSUtil {
    public static String OSSpecificSlash() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")){
            return "\\";
        }
        else {//macos or linux
            return "/";
        }
    }

    public static String getDownloadsPath() {
        String userHome = System.getProperty("user.home");
        Path downloadsPath = Paths.get(userHome, "Downloads");
        System.out.println("Downloads path: " + downloadsPath.toString());

        return downloadsPath.toString();
    }
}
