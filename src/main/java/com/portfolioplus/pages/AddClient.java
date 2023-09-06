package com.portfolioplus.pages;

import io.appium.java_client.windows.WindowsDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;

import java.awt.*;
import java.awt.event.KeyEvent;

public class AddClient {

    private WindowsDriver driver;

    // Page locators

    String addClientButton="ADD CLIENT";
    String typeBox="//Pane[@ClassName='#32769'][@Name='Desktop 1']//Window[@ClassName='ProMainWin'][@Name='CLIENTS']//Window[@ClassName='ProFrame'][@Name='MAIN INFORMATION']//ComboBox[@ClassName='ComboBox']";



    public AddClient(WindowsDriver driver){
        this.driver=driver;
    }

    //Actions

    public void clickOnAddToClientButton(){
       driver.findElementByName(addClientButton).click();
    }
    @Step("Select combobox value from list ")
    public void selectTypeCombobox() throws InterruptedException, FindFailed, AWTException {
       driver.findElementByAccessibilityId("24").click();
        Actions action = new Actions(driver);
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_DOWN);
        rb.keyPress(KeyEvent.VK_ENTER);

        for(int i=0;i<4;i++) {
            driver.findElementByAccessibilityId("30").click();
            Thread.sleep(2000);
            rb.keyPress(KeyEvent.VK_DOWN);
            Thread.sleep(2000);
            rb.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
            String Text=driver.findElementByAccessibilityId("30").getText();
            System.out.println(Text);
            Allure.addAttachment("salutation values are: ", Text);
        }
       }

    @Step("Enter data in all text box")
    public void enterDataInTextBox(String lName,String fName,String mName,String lang,String dob,String mStstus){
        Actions act = new Actions(driver);
        driver.findElementByAccessibilityId("35").sendKeys(lName);
       // Allure.addAttachment("Last name value is : ", lName);
        driver.findElementByAccessibilityId("40").sendKeys(fName);
        //Allure.addAttachment("First name value is : ", fName);
        driver.findElementByAccessibilityId("42").sendKeys(mName);
        //Allure.addAttachment("Middle name value is : ", mName);
        WebElement ele=driver.findElementByAccessibilityId("37");
        ele.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
        driver.findElementByAccessibilityId("37").sendKeys(lang);
        driver.findElementByAccessibilityId("44").sendKeys(dob);
       // Allure.addAttachment("Dob  value is : ", dob);
        WebElement ele1= driver.findElementByAccessibilityId("32");
        ele1.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
        driver.findElementByAccessibilityId("32").sendKeys(mStstus);
    }

    public void clickOnOkButton(){
        driver.findElementByAccessibilityId("22").click();
    }

    public boolean isDialogueBoxMessageDisplayed(){
        return driver.findElementByName("First Name cannot be left blank.").isDisplayed();
    }

    public void clickOnDialogueBoxOkButton(){
        driver.findElementByAccessibilityId("2").click();
    }

    public void clickOnCancelButton(){
        driver.findElementByAccessibilityId("33").click();
    }

}
