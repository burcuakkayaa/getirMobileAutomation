package factory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Constants;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class MobileDriver {


    AppiumServer appiumServer = new AppiumServer();

    public MobileDriver() {
    }

    public DesiredCapabilities getDesiredCapabilities(String deviceType) {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        if ("realDevice".equals(deviceType)) {
            desiredCapabilities.setCapability("udid", "52004b9afeb025e1");
            desiredCapabilities.setCapability("deviceName", "GalaxyJ7Pro");
        } else {
            desiredCapabilities.setCapability("udid", "emulator-5554");
            desiredCapabilities.setCapability("deviceName", "Pixel 2 API 28");
        }
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("platformVersion", "9");
        desiredCapabilities.setCapability("appPackage", Constants.appPackage);
        desiredCapabilities.setCapability("appActivity", Constants.appActivity);
        desiredCapabilities.setCapability("skipUnlock", "true");
        desiredCapabilities.setCapability("noReset", "false");
        return desiredCapabilities;
    }

    public AppiumDriver<MobileElement> startMobileDriver(String deviceType) throws MalformedURLException {

        ThreadLocalDriver.setTLDriver(new AndroidDriver<>(appiumServer.getUrl(deviceType), getDesiredCapabilities(deviceType)));
        ThreadLocalDriver.getTLDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return ThreadLocalDriver.getTLDriver();


    }

}
