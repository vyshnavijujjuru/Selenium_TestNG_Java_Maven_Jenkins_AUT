import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


class  SignUpUser {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://login.mailchimp.com/";
        String chromeDriverPath = "C:\\software\\chromedriver_113Version\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        driver.get(url);
        //System.out.println(driver.getTitle());

        String signUpUrl = "https://login.mailchimp.com/signup/";
        driver.get(signUpUrl);

        //  Thread.sleep(2000);
        String locBusinessEmail = "//input[@id='email']";
        String locUserName = "//input[@id='new_username']";
        String locPassword = "//input[@id='new_password']";
        String locSignUp = "//*[@id='create-account-enabled']";

        //Thread.sleep(2000);
        WebElement BusinessEmail = driver.findElement(By.xpath(locBusinessEmail));
        WebElement UserName = driver.findElement(By.xpath(locUserName));
        WebElement Password = driver.findElement(By.xpath(locPassword));
        WebElement SignUp = driver.findElement(By.xpath(locSignUp));

        BusinessEmail.sendKeys("vyshujv@gmail.com");
        UserName.sendKeys("");
        Password.sendKeys("qwe@123K");
        SignUp.click();
        Thread.sleep(2000);
        driver.quit();
        System.out.println("Successfully created userlogin");
    }

}

