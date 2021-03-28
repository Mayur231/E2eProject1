package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {

    public WebDriver driver;

  private By signin= By.cssSelector("a[href*='sign_in']");
   private By title=By.cssSelector(".text-center>h2");
    private By Navbar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
    private By popup=By.xpath("//button[text()='NO THANKS']");


    public Landingpage(WebDriver driver)
    {
        this.driver=driver;
    }

    public Loginpage getlogin()
    {
        driver.findElement(signin).click();
       return new Loginpage(driver);

    }

    public WebElement gettitle()
    {
        return driver.findElement(title);
    }

    public WebElement getnavbar()
    {
        return driver.findElement(Navbar);
    }

    public int getPopUpSize()
    {
        return driver.findElements(popup).size();
    }

    public WebElement getPopUp()
    {
        return driver.findElement(popup);
    }
}
