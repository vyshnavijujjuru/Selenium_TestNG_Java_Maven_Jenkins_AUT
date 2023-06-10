import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginDetails_Parameterization {

    WebDriver driver;
    @DataProvider(name = "data-set")
    public static Object[][] DataSet()
    {

        Object[][] obj = {
                {"valid", "standard_user", "secret_sauce"},
                {"invalid", "standard_user", "12345"},
                {"valid","problem_user","secret_sauce"},
                {"invalid","secret_sauce","secret_sauce"},
                {"invalid","abcdgth","secret_sauce"},
                {"valid","performance_glitch_user","secret_sauce"}
        };
        return obj;
    }

    @Test(dataProvider = "data-set")
    public void DataCreate(String type, String username, String password) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\software\\chromedriver_113Version\\chromedriver_win32\\chromedriver.exe");
        System.out.println(type + " " + username + " " + password);
        driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        if(type.equals("valid")){
            System.out.println("valid Successfully");
        }else
            System.out.println("invalid");

        Thread.sleep(2000);
        driver.quit();
    }

}


