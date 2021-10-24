package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public Properties prop;

    public Properties initProp() throws IOException {
        prop = new Properties();
        FileInputStream ip = new FileInputStream(".\\src\\test\\resources\\config.properties");
        prop.load(ip);


        return prop;

    }

}
