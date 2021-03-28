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

import java.io.IOException;

public class ValidateNavbar extends Base {
    public WebDriver driver;

    public static Logger log = LogManager.getLogger(Base.class.getName());
    @BeforeTest
    public void initialize() throws IOException
    {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test

    public void basePageNavigation() throws IOException {

        Landingpage lp = new Landingpage(driver);
        Assert.assertTrue(lp.getnavbar().isDisplayed());
        log.info("Navigation bar is displayed");

    }

    @AfterTest

    public void teardown()
    {
        driver.close();
    }



    }

