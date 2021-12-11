package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static aquality.selenium.browser.AqualityServices.getLogger;

public class ConfigManager {
    private static Properties PROPERTIESConf;
    private static final String PathConf = "src/test/resources/testData.properties";

    static {
        try (FileReader fileInputStreamConf = new FileReader(PathConf)) {
            PROPERTIESConf = new Properties();
            PROPERTIESConf.load(fileInputStreamConf);

        } catch (IOException e) {
            getLogger().info("file data failed!", e);
        }
    }

    public static String getPropertyConf(String key) {
        return PROPERTIESConf.getProperty(key);
    }

}
