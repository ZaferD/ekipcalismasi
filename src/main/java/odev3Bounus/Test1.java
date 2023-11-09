package odev3Bounus;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Test1 {

    WebDriver driver;
    LoginPage lp;
    ProductPage pp;

    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        lp = new LoginPage(driver);
        pp = new ProductPage(driver);
    }

    @Test
    public void test1(){
        lp.gotoSite();
        lp.assertTitle("Swag Labs");
        lp.login("standard_user", "secret_sauce");
        lp.assertToLogin();
    }

    @Test(dependsOnMethods = {"test1"})
    public void testProduct(){

        // produk'larin isimleri alma
        List<String> names = pp.getListOfAllProductNames();
        System.out.println(names);

        // productlarin fiyatlarini consola yazdirma
        List<Product> products = pp.getAllProducts();
        for (Product product : products) {
           System.out.println(product.getPrice());
        }

        // isminde "Test.allTheThings" olan ürünü cart'a ekleme
        pp.addProductToCart("Test.allTheThings");

        // cart'a tiklama
        lp.gotoCart();

        // cart'a gidildigini assert etme
        lp.assertToCart();

        // cart'ta "Test.allTheThings" isimli ürünün oldugunu assert etme
        pp.checkProductInCart("Test.allTheThings");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
