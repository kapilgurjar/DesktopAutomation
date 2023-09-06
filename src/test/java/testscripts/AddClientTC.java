package testscripts;

import base.BaseTest;
import io.qameta.allure.*;
import org.apache.log4j.Priority;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class AddClientTC extends BaseTest {


    @Test(priority=1)
    @Epic("Notepad test case ")
    @Story("Notepad jira story")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyAddClient() throws InterruptedException, FindFailed, AWTException {
        addClient.clickOnAddToClientButton();
        Thread.sleep(3000);
        addClient.selectTypeCombobox();
        addClient.enterDataInTextBox("Kumar","Kapil","Singh","H","04/07/1991","Other");
    }

    @Test(priority=0)
    @Epic("Notepad test case ")
    @Story("Notepad jira story")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyDialogueBoxMessage() throws InterruptedException, FindFailed, AWTException {
        addClient.clickOnAddToClientButton();
        addClient.clickOnOkButton();
        Thread.sleep(3000);
        addClient.isDialogueBoxMessageDisplayed();
        Assert.assertTrue(addClient.isDialogueBoxMessageDisplayed());
        Thread.sleep(3000);
        addClient.clickOnDialogueBoxOkButton();
        //addClient.clickOnCancelButton();
    }



    //@Test
    @Epic("Notepad test case ")
    @Story("Notepad jira story")
    @Description("Verify title of window")
    @Severity(SeverityLevel.CRITICAL)
    public void tc03(){
        int rowCount=excelUtil.getRowCount("Sheet1");
        for(int i=2;i<=rowCount;i++){
            String lastname = excelUtil.getCellData("Sheet1", 0, i);
            String firstName = excelUtil.getCellData("Sheet1", 1, i);
            String middleName = excelUtil.getCellData("Sheet1", 2, i);
            String lang = excelUtil.getCellData("Sheet1", 3, i);
            String dob = excelUtil.getCellData("Sheet1", 4, i);
            String mStatus = excelUtil.getCellData("Sheet1", 4, i);

            System.out.println("User name is equal " +  lastname +   "Password is equal " + firstName);
        }
    }

}
