package testscripts;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestJava {
    public WindowsDriver driver = null;


    @BeforeTest()
    public void setUp() {
        Desktop desktop= Desktop.getDesktop();
        try {
            desktop.open(new File("C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void TC01() throws IOException, InterruptedException {


        //Desktop desktop= Desktop.getDesktop();
        //desktop.open(new File("C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe"));
        System.out.println("Window appliaction server");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app","C:\\POC\\AddClient.lnk");
        cap.setCapability("platformName", "Windows");
        cap.setCapability("deviceName", "WindowsPC");

        try {
            //create webdriver instance
            driver = new WindowsDriver(new URL(" http://127.0.0.1:4723"), cap);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //provide implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(8000);
        driver.findElementByName("ADD CLIENT").click();
        //driver.findElementByName("ADD CLIENT").click();
        //driver.findElementByAccessibilityId("Close").click();
        //driver.findElementByAccessibilityId("33").click();
        //WebElement eletext=driver.findElementByXPath("//Window[@ClassName='Notepad'][@Name='Untitled - Notepad']/MenuBar[@Name='Application'][@AutomationId='MenuBar']/MenuItem[@Name='File']");
        //System.out.println("Text is equal to " +eletext.getText());
        //String text=driver.findElementByXPath("//Window[@ClassName='Notepad'][@Name='Untitled - Notepad']/MenuBar[@Name='Application'][@AutomationId='MenuBar']/MenuItem[@Name='File']").getText();
        //System.out.println(text);
        //driver.findElementByXPath("//Window[@ClassName='Notepad'][@Name='Untitled - Notepad']/MenuBar[@Name='Application'][@AutomationId='MenuBar']/MenuItem[@Name='File']").click();

        //Runtime.getRuntime().exec("taskkill /F /IM WinAppDriver.exe");
    }


    @AfterTest
    public void tearDown() {


        try {
            Runtime.getRuntime().exec("taskkill /F /IM WinAppDriver.exe");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //driver.close();

    }
}
