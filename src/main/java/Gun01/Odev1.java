package Gun01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Odev1 {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait;

    @Test
    public void odev1() {
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //    1. https://demoblaze.com/  sayfasina gidin
        driver.get("https://demoblaze.com/");
        //    2. "Log in" butonuna tiklayin
        driver.findElement(By.xpath("//a[@id='login2']")).click();

        //    3. Dialog icindeki "Log in" butonunun visible oldugunu assert edin.
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log in']"));
        wait.until(ExpectedConditions.visibilityOf(loginButton));

        Assert.assertTrue(loginButton.isDisplayed());
        //    4. "x" butonu ile dialog'u kapatin
        driver.findElement(By.xpath("(//button[@class='close'])[3]")).click();
        //    5. Dialogun kapandigini "Close" butonunun visibility'sine bakarak assert edin
        WebElement closeButton = driver.findElement(By.xpath("(//button[text()='Close'])[3]"));
        wait.until(ExpectedConditions.invisibilityOf(closeButton));
        Assert.assertFalse(closeButton.isDisplayed());
        driver.quit();
    }


}
