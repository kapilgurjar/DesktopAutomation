package com.portfolioplus.factory;

import com.portfolioplus.utils.Utility;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public WindowsDriver driver;
    /**
     * This method is used to initialize the webdriver
     * @return this will return the driver
     */
    public static ThreadLocal<WindowsDriver>tldriver= new ThreadLocal<WindowsDriver>();

    public WindowsDriver init_driver() throws Exception {
        String appUrl=Utility.getGlobalValue("appurl");
        System.out.println(appUrl);
        System.out.println("Window appliaction server");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", appUrl);
        cap.setCapability("platformName", "Windows");
        cap.setCapability("deviceName", "WindowsPC");
        try {
            //create webdriver instance
           tldriver.set(new WindowsDriver(new URL(" http://127.0.0.1:4723"), cap));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return getDriver();

    }

    public static synchronized WindowsDriver getDriver() {

        return tldriver.get();

    }

}
