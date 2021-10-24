package factory;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.net.MalformedURLException;
import java.net.URL;


public class AppiumServer {

    public static AppiumDriverLocalService service;


    public static void startAppiumServer(String deviceType) {

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        if ("realDevice".equals(deviceType)) {
            builder.withIPAddress("0.0.0.0").usingPort(4728);
        } else {
            builder.withIPAddress("127.0.0.1").usingAnyFreePort();
        }

        service = AppiumDriverLocalService.buildService(builder);
        if (!service.isRunning())
            service.start();
        else
            System.out.println("service is running..");

    }

    public URL getUrl(String deviceType) throws MalformedURLException {

        return service.getUrl();
    }

}
