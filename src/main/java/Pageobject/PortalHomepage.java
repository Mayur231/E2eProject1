package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//rahulonlinetutor@gmail.com
public class PortalHomepage {


    public WebDriver driver;

    By searchBox=By.name("query");

    public PortalHomepage(WebDriver driver) {

        this.driver = driver;

    }


    public WebElement getSearchBox()
    {
        return driver.findElement(searchBox);
    }



}
