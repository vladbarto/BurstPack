package vlad.bartolomei.package_burst.utils;

import lombok.experimental.UtilityClass;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public class HttpUtil {
    private static final String communicationProtocol = "http://";

    private static String port = "6484";
    private static String receiveEndpoint = "/control/receive";

    public static String urlSendBuilder(String ipAddress) {
        System.out.println(communicationProtocol + ipAddress + ":" + port + receiveEndpoint);
        return communicationProtocol + ipAddress + ":" + port + receiveEndpoint;
    }
}
