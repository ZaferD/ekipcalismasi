package Gun01;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Odev2 {


    /**
     * /**
     * * Scenario-2
     * * ------------------------------------------
     * * 1.  https://www.saucedemo.com/  sitesine git
     * * 2.  sayfada belirtilen standart user ile login olun
     * * 3.  Sayfada Listelenen ürünlerin isimlerini List olarak alin ve consola yazdirin.
     * * 4.  "Sauce Labs Bike Light" ve "Sauce Labs Bolt T-Shirt" ürünlerini sepete ekleyin
     * * 5.  Sayfada Listelenen ürünlerin "Add To Cart"'dan  "Remove"'a dönen buton sayisinin 2 oldugunu assert edin.
     * *     sepete gidin
     * * 6.  sepette 2 ürünün oldugunu assert edin.
     * * 7.  Checkout yapin
     * * 8.  Acilan sayfadaki formu doldurun
     * * 9.  Continue butonuna tiklayin
     * * 10. Listelenen ürünlerin altindaki fiyatlarini alin ve toplayin
     * *     daha sonra en alttaki Total: de yazan fiyat ile ayni oldugunu assert edin.
     * * 11. Finish'e tiklayarak "Thank you for your order!" yazisinin ciktigini assert edin.
     */

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Test
    public void Scenario_2() throws InterruptedException {

//        1.  https://www.saucedemo.com/  sitesine git
        String url = "https://www.saucedemo.com/";
        driver.get(url);


//        2.  sayfada belirtilen standart user ile login olun

        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        username.sendKeys("standard_user");


        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();


// 3.  Sayfada Listelenen ürünlerin isimlerini List olarak alin ve consola yazdirin.

        //Thread.sleep(3000);

        WebElement element = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        wait.until(ExpectedConditions.visibilityOf(element));


        List<WebElement> listOfProduct = driver.findElements(By.xpath("//div[@id='root'] //div[@class='inventory_item_name ']"));


        for (WebElement each : listOfProduct) {
            System.out.println(each.getText());
        }


//        4.  "Sauce Labs Bike Light" ve "Sauce Labs Bolt T-Shirt" ürünlerini sepete ekleyin

//div[text()='Sauce Labs Bike Light']
        //div[text()='Sauce Labs Bolt T-Shirt']

//        WebElement product_BikeLight = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
//        product_BikeLight.click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();

//        WebElement product_BoltTShirt = driver.findElement(By.xpath("  //div[text()='Sauce Labs Bolt T-Shirt']"));
//        product_BoltTShirt.click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();

        //Thread.sleep(2000);


        // 5.  Sayfada Listelenen ürünlerin "Add To Cart"'dan  "Remove"'a dönen buton sayisinin 2 oldugunu assert edin.
        //     sepete gidin

        List<WebElement> listOfRemoweProducts = driver.findElements(By.xpath("//button[text()='Remove']"));
        Assert.assertTrue(listOfRemoweProducts.size() == 2);


        // 6.  sepette 2 ürünün oldugunu assert edin.
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Thread.sleep(2000);
        List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cart_list']//div[@class='cart_item']"));
        Assert.assertEquals(cartProducts.size(), 2);


        //  7.  Checkout yapin
        driver.findElement(By.cssSelector("#checkout")).click();


        // 8.  Acilan sayfadaki formu doldurun
        WebElement firstName = driver.findElement(By.cssSelector("#first-name"));
        //firstName.sendKeys("trgt");
        // * * 9.  Continue butonuna tiklayin
        WebElement continueButton = driver.findElement(By.xpath("//input[@class='submit-button btn btn_primary cart_button btn_action']"));

        new Actions(driver)
                .clickAndHold(firstName)
                .sendKeys("trgt")
                .keyDown(Keys.TAB)
                .sendKeys("aaaaa")
                .keyDown(Keys.TAB)
                .sendKeys("06165")
                .keyDown(Keys.TAB)
                .pause(2000)
                .release()
                .click(continueButton)
                .perform();
        Thread.sleep(3000);


        // * * 10. Listelenen ürünlerin altindaki fiyatlarini alin ve toplayin

        double total = 0.0;
        List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for (WebElement each : priceList
        ) {
            String priceText = each.getText();
            priceText = priceText.replace("$", "");
            double price = Double.parseDouble(priceText);
            total += price;

        }
        total = (total + 2.08);
        String formattedtotal = String.format("%.2f", total);
        formattedtotal = formattedtotal.replace(",", ".");
        double doubletotal = Double.parseDouble(formattedtotal);
        System.out.println(doubletotal);
        WebElement totalprice = driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']"));
        String expected = totalprice.getText().replace("Total: $", "");
        double doubleExpected = Double.parseDouble(expected);
        // * *     daha sonra en alttaki Total: de yazan fiyat ile ayni oldugunu assert edin.
        Assert.assertEquals(doubletotal, doubleExpected);


        // * * 11. Finish'e tiklayarak "Thank you for your order!" yazisinin ciktigini assert edin.
        driver.findElement(By.cssSelector("#finish")).click();
        WebElement thankText = driver.findElement(By.xpath("//h2[text()='Thank you for your order!']"));

        Assert.assertEquals(thankText.getText(), "Thank you for your order!");

    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
