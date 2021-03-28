package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {

    public WebDriver driver;

    By email=By.cssSelector("[id='user_email']");
    By password=By.cssSelector("[type='password']");
    By login=By.cssSelector("type='submit']");
    By forgetpassword=By.cssSelector("[href*='password/new']");

    public Loginpage(WebDriver driver)
    {
        this.driver=driver;
    }

    public WebElement getEmail()
    {
        return driver.findElement(email);
    }

    public WebElement getpwd()
    {
        return driver.findElement(password);
    }

    public WebElement login()
    {
        return driver.findElement(login);
    }

    public Forgetpassword Forgetpassword()
    {
        driver.findElement(forgetpassword).click();
        return new Forgetpassword(driver);

    }


    public void click() {
    }
}
