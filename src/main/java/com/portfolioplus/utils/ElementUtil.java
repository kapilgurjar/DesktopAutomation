package com.portfolioplus.utils;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.Set;

public class ElementUtil {
    protected WindowsDriver driver;

    public static WebElement WaitForElementToBeVisible(WindowsDriver<WindowsElement> NotepadSession, String locatorType,
                                                       String locatorValue) throws InterruptedException {

        WebElement element = null;

        for (int i = 0; i< 100; i++) {

            if (locatorType.contains("name")) {
                element = NotepadSession.findElementByName(locatorValue);
                element.isDisplayed();
                break;
            }
            if (locatorType.contains("id")) {
                element = NotepadSession.findElementByAccessibilityId(locatorValue);
                element.isDisplayed();
                break;
            }
            Thread.sleep(1000);
        }
        return element;
    }

    public Set<String> getWindowHandles() {
        // Log.info("Window Handling");
        return driver.getWindowHandles();
    }

    public void SwitchToWindow(int index) {

        LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());
        System.out.println(windowsId);
        driver.switchTo().window(windowsId.get(index));
        driver.manage().window().maximize();
        //test.log(LogStatus.INFO, "Switch to Window is Successfull");
    }

    public void switchToParentWindow() {
        LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());
        driver.switchTo().window(windowsId.get(0));
        //test.log(LogStatus.INFO, "Switch to Parent Window");
    }

    public void switchToParentWithChildClose() {
        LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());

        for (int i = 1; i < windowsId.size(); i++) {
            System.out.println(windowsId.get(i));
            driver.switchTo().window(windowsId.get(i));
            driver.close();
        }
        switchToParentWindow();
    }

    public void switchToFrame(String nameOrId) {
        driver.switchTo().frame(nameOrId);
        System.out.println("Frame ID/Name : " + nameOrId);
    }

    public void switchToFrameByIndex(int index) {
        driver.switchTo().frame(index);
        //test.log(LogStatus.INFO, "Frame Index : " + index);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
        //test.log(LogStatus.INFO, "Switch to Default Content");
    }

    public void pageRefresh() {
        driver.navigate().refresh();
    }


    public static void log(String message) {
        System.out.println(message);
    }

    public static void sleep(long timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}



