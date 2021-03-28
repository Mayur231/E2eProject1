package Academy1;

import Academy.Resources.Base;
import Pageobject.Forgetpassword;
import Pageobject.Landingpage;
import Pageobject.Loginpage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Homepage extends Base {
    public WebDriver driver;

    public static Logger log = LogManager.getLogger(Base.class.getName());
    @BeforeTest
    public void initialize() throws IOException
    {
        driver = initializeDriver();

    }

    @Test(dataProvider = "getdata")

    public void basePageNavigation(String Username,String Password,String text) throws IOException
    {
        driver.get(prop.getProperty("url"));
        Landingpage lp=new Landingpage(driver);
        Loginpage lp1=lp.getlogin();
        //Loginpage lp1=new Loginpage(driver);
        lp1.getEmail().sendKeys(Username);
        lp1.getpwd().sendKeys(Password);
        log.info(text);
        //System.out.println(text);
        lp1.login().click();
        Forgetpassword fp=lp1.Forgetpassword();
        fp.getEmail().sendKeys("may123");
        fp.Getinstructions().click();

    }
    @AfterTest

    public void teardown()
    {
        driver.close();
    }

    @DataProvider

    public Object[][] getdata()
    {
        Object [][] data=new Object[2][3];
        //row 0
        data[0][0]="non restricted user.com";
        data[0][1]="1122345";
        data[0][2]="Restricted user";
        //row 1
        data[1][0]="Restricted user.com";
        data[1][1]="1342345";
        data[1][2]="Non Restricted user";

        return data;
    }


    }

