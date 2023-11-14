package Gun01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01FileDownloadTest {
    WebDriver driver=new ChromeDriver();

    @Test
    public void test01() throws InterruptedException, IOException {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/download");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='test.txt']")).click();
        Thread.sleep(3000);
        String dosyaYolu= System.getProperty("user.home")+ "/Downloads/test.txt";
        System.out.println(System.getProperty("user.home"));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        String osName = System.getProperty("os.name");

        if (osName.toLowerCase().contains("windows")) {
            Runtime.getRuntime().exec("dir");
        } else {
            Runtime.getRuntime().exec("ls");
        }
        Thread.sleep(5000);
        driver.quit();
    }
}
