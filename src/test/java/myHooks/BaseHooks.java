package myHooks;


import factory.AppiumServer;
import factory.MobileDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.net.MalformedURLException;


public class BaseHooks {

    private MobileDriver mobileDriver;
    public static AppiumDriver<MobileElement> driver;


    @Before(order = 0)
    public void init(Scenario scenario) {
        String name = scenario.getName();
        System.out.println("Scenario name: " + scenario.getName());

    }

    @Before("@realDevice")
    public void launchDriverAsRealDevice() throws MalformedURLException {
        mobileDriver = new MobileDriver();
        AppiumServer.startAppiumServer("realDevice");
        driver = mobileDriver.startMobileDriver("realDevice");

    }

    @Before("@emulator")
    public void launchDriverAsEmulator() throws MalformedURLException {
        mobileDriver = new MobileDriver();
        AppiumServer.startAppiumServer("emulator");
        driver = mobileDriver.startMobileDriver("emulator");
    }

    @After(order = 1)
    public void quit(Scenario scenario) {

        if (scenario.isFailed()) {

            String screenshotName = scenario.getName().replaceAll(" ", "_");

            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            scenario.attach(sourcePath, "image/png", screenshotName);

        }

        driver.quit();

    }

    @After(order = 0)
    public void tearDown() {

        AppiumServer.service.stop();
        System.out.println("service is stopped..");


    }

}
