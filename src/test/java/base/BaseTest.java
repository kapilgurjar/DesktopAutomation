package base;

import com.portfolioplus.factory.DriverFactory;
import com.portfolioplus.pages.AddClient;
import com.portfolioplus.pages.NotepadPage;
import com.portfolioplus.utils.ExcelUtil;
import com.portfolioplus.utils.Utility;
import io.appium.java_client.windows.WindowsDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BaseTest {

    DriverFactory df;
    protected ExcelUtil excelUtil;
    protected NotepadPage notepadPage;
    protected AddClient addClient;
    protected WindowsDriver driver;
    protected SoftAssert softAssert;
    protected ProcessBuilder builder;
    protected Process process;


    @BeforeTest()
    public void setUp() throws Exception {
//        Desktop desktop = Desktop.getDesktop();
//        try {
//
//            desktop.open(new File(Utility.getGlobalValue("winappexepath")));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

         builder=new ProcessBuilder(Utility.getGlobalValue("winappexepath")).inheritIO();
         process= builder.start();
        df = new DriverFactory();
        driver = df.init_driver();
        excelUtil= new ExcelUtil(System.getProperty("user.dir")+"//src//main//resources//TestData.xlsx");
        notepadPage = new NotepadPage(driver);
        addClient = new AddClient(driver);

    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.close();
//        try {
//            Runtime.getRuntime().exec("taskkill /F /IM WinAppDriver.exe");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

      // driver.close();

        try{

        }catch(Exception e){

        }
        finally {

            process.destroy();
        }
   }



}
