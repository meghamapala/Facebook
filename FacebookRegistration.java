package registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FacebookRegistration {

    @Test
    public void testUserCannotRegisterIfEmailIsNotProvided() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "/Users/meghamapalagama/IdeaProjects/facebook/src/main/java/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String facebookUrl = "https://facebook.com";
        driver.get(facebookUrl);
        Thread.sleep(3000);

        driver.findElement(By.name("firstname")).sendKeys("Megha");
        Thread.sleep(3000);
        driver.findElement(By.name("lastname")).sendKeys("Mapa");
        driver.findElement(By.name("reg_email__")).sendKeys("mm@pnt.edu");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("mm@pnt.edu");

        driver.findElement(By.name("reg_passwd__")).sendKeys("Test123!");

        Select monthDropdown = new Select(driver.findElement(By.name("birthday_month")));
        Thread.sleep(3000);
        Select dayDropdown = new Select(driver.findElement(By.name("birthday_day")));
        Select yearDropdown = new Select(driver.findElement(By.name("birthday_year")));

        monthDropdown.selectByValue("12");
        Thread.sleep(3000);
        dayDropdown.selectByValue("21");
        Thread.sleep(3000);
        yearDropdown.selectByValue("2000");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@name='sex' and @value='2l']")).click();
       // Thread.sleep(5000);

        driver.findElement(By.name("websubmit")).click();
        //Thread.sleep(5000);

        driver.close();

        driver.quit();

    }
}
