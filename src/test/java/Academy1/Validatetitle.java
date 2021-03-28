package Academy1;

import Academy.Resources.Base;
import Pageobject.Landingpage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import org.apache.logging.log4j.Logmanager;
//import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class Validatetitle extends Base {
public WebDriver driver;

    public static Logger log = LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void initialize() throws IOException
    {
        driver = initializeDriver();
        log.info("Driver is initialised");

        driver.get(prop.getProperty("url"));
        log.info("Navigated to homepage");

    }

    @Test

    public void basePageNavigation() throws IOException {

        Landingpage lp = new Landingpage(driver);
        Assert.assertEquals(lp.gettitle().getText(),"FEATURED COURCES");
        log.info("Succesfully validated text message");
    }
    @AfterTest

    public void teardown()
    {
        driver.close();
    }


}
