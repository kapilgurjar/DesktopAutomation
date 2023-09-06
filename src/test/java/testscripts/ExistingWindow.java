package testscripts;

import com.portfolioplus.factory.DriverFactory;
import com.portfolioplus.utils.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;

import java.io.IOException;
import java.net.*;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ExistingWindow {

    public  ProcessBuilder builder;
    public  Process process;

    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("Z:\\Launch Portfolio+ Client.bat").inheritIO();
        try {
            Process process = processBuilder.start();

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("ok");
                //System.exit(0);
            } else {
                //abnormal...
                System.out.println("not ok");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {

            DesiredCapabilities desktopCapabilities = new DesiredCapabilities();
            desktopCapabilities.setCapability("platformName", "Windows");
            desktopCapabilities.setCapability("deviceName", "WindowsPC");
            desktopCapabilities.setCapability("app", "Root");


            WindowsDriver desktopSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), desktopCapabilities);

            desktopSession.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            WebElement BHWebElement = desktopSession.findElementByName("Sign In");
            String CalcWinHandleStr = BHWebElement.getAttribute("NativeWindowHandle");
            int CalcWinHandleInt = Integer.parseInt(CalcWinHandleStr);
            String CalcWinHandleHex = Integer.toHexString(CalcWinHandleInt);

            DesiredCapabilities CalcCapabilities = new DesiredCapabilities();
            CalcCapabilities.setCapability("platformName", "Windows");
            CalcCapabilities.setCapability("deviceName", "WindowsPC");
            CalcCapabilities.setCapability("appTopLevelWindow", CalcWinHandleHex);
            System.out.println("Calc Handle is: " + CalcWinHandleHex);
//
            WindowsDriver calcSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), CalcCapabilities);

            Thread.sleep(2000);
            calcSession.findElementByAccessibilityId("userName").sendKeys("testuser");
            calcSession.findElementByAccessibilityId("Password").sendKeys("automation");
            calcSession.findElementByAccessibilityId("button1").click();
            Thread.sleep(20000);
            Set<String> windowSize=calcSession.getWindowHandles();
            String parent=calcSession.getWindowHandle();
            //System.out.println(calcSession.switchTo().window(parent).getTitle());
            System.out.println("Size:\t"+calcSession.getWindowHandles().size());
            //Loop through until we find a new window handle
            for (String windowHandle : calcSession.getWindowHandles()) {
                if(!parent.contentEquals(windowHandle)) {
                    calcSession.switchTo().window(windowHandle);
                    break;
                }
            }

            calcSession.findElementByAccessibilityId("module_accounting").click();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
