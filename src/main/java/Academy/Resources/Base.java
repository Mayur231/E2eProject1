package Academy.Resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
public WebDriver driver;
public Properties prop;
    public WebDriver initializeDriver() throws IOException {
        prop=new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");

        prop.load(fis);

        //mvn test-Dbrowser=chrome
        String browsername = System.getProperty("browser");
        System.out.println(browsername);

        //String browsername=prop.getProperty("browser");

        if(browsername.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pranay\\Downloads\\chromedriver_win32\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            if (browsername.contains("headless"))
            {
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);
        }

        else if (browsername.equals("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if (browsername.equals("Ie"))
        {
            driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
public String getScreenShotpath(String result, WebDriver driver) throws IOException
{
   /* TakesScreenshot ts=(TakesScreenshot) driver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    String destinationfile=System.getProperty("useridir"+"\\reports\\"+testCasename+".png");
    FileUtils.copyFile(source,new File(""));
    return destinationfile;*/
    File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
    return result;
}


}
