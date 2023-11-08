package odev3Bounus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductPage extends BasePage {


    /*
        Bu kisma login olduktan sonra acilan products sayfasindaki
        elementleri @FindBy ile ekleyinit.

        * tanimlama asagidaki gibi olur ise, yazilan selector 1 den fazla
        * element bulsa dahi ilk elementi alir.
        * "driver.findElement" islemi yürütür
        @FindBy(css = ".inventory_item")
        private WebElement eProduct;

        * tanimlama asagidaki gibi olur ise, yazilan selector bulunan tüm
        * elementleri List olarak return eder.
        * "driver.findElements" islemi yürütür
        @FindBy(css = ".inventory_item")
        private List<WebElement> eProducts;

     */
    @FindBy(css = ".inventory_item")
    private List<WebElement> eProducts;

    @FindBy(css = ".inventory_item_name")
    private List<WebElement> eProductNames;

    @FindBy(css = ".inventory_item_price")
    private List<WebElement> eProductPrices;

    @FindBy(css = ".inventory_item button")
    private List<WebElement> eProductAddToCarts;

    @FindBy(css = ".cart_item")
    private List<WebElement> eCartItems;

    private Product rootProduct;


    /**
     * constructor
     * WebDriver alacak ve elementler initialize edilecek
     * @param driver
     */
    public ProductPage(WebDriver driver){
        super(driver);
    }

    /**
     * Products sayfasindaki tüm elementlerin isim listesini return edecek method
     * stream ya da for ile List doldurulabilir
     * @return
     */
    public List<String> getListOfAllProductNames(){
        return null;
    }

    /**
     * Sayfadaki tüm Productlari Product.class'ina atayan ve
     * List<Product> return eden method
     * @return
     */
    public List<Product> getAllProducts(){
        return null;
    }

    /**
     * bu method productName'i alacak ve o product grubu icinde isminda productName gecen ürünü
     * yukarida "private Product rootProduct;" olarak tanimlanan variable'a atayacak
     * stream ya da for kullanabilirsiniz
     * @param productName
     */
    private void setSelectedProduct(String productName){

    }

    /**
     * Bu method aldigi name ile yukaridaki setSelectedProduct() methodunu kullanarak
     * rootProduct'i belirler ve o Product'in ismini return eder.
     * @param name
     * @return
     */
    public String getProductName(String name){
        return null;
    }

    /**
     * bu method aldigi name ile yukaridaki setselectedproduct() methodunu kullanarak
     * rootproduct'i belirler ve o product'in ismini return eder.
     * @param name
     * @return
     */
    public double getProductPrice(String name){
        return 0;
    }

    /**
     * Bu method aldigi name ile yukaridaki setSelectedProduct() methodunu kullanarak
     * rootProduct'i belirler ve o Product'in Add To Cart Butonuna click eder.
     * @param name
     * @return
     */
    public void addProductToCart(String name){

    }

    /**
     * Bu method aldigi isimli ürünün cart icinde olup olmadigini assert eder
     * contains kullanin
     * @param name
     */
    public void checkProductInCart(String name){

    }


}
