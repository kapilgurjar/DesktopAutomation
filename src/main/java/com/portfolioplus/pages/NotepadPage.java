package com.portfolioplus.pages;

import com.portfolioplus.utils.ElementUtil;
import io.appium.java_client.windows.WindowsDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class NotepadPage {

    private WindowsDriver driver;
    String menuItem="//Window[@ClassName='Notepad'][@Name='Untitled - Notepad']/MenuBar[@Name='Application'][@AutomationId='MenuBar']/MenuItem[@Name='File']";
    String saveAsButton="CommandButton_7";



    public NotepadPage(WindowsDriver driver){
        this.driver=driver;
    }

    //Action
    @Step("Click on the file button and getting the text of file")
    public void click(){

        driver.findElementByXPath(menuItem).click();
    }
    @Step("Getting text of file menu")
    public String getFileMenuText(){
      return driver.findElementByXPath(menuItem) .getText();
    }

    @Step("Getting title of window")
    public String getTitle(){
        return driver.getTitle();
    }
    @Step("Click On Save button")
    public WebElement clickOnSaveAsButton() throws InterruptedException {
        //driver.findElementByName("Save").click();
        return ElementUtil.WaitForElementToBeVisible(driver,"id",saveAsButton);
    }

}



