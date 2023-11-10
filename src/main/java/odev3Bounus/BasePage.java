package odev3Bounus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    //Protected WebDriver ve WebDriver Wait tanimlayiniz
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Constructor tanimlayiniz
     * WebDriver bir parametre alacak,
     * bu class i extend eden child class'larin elementleri bu classda initialize edilebilir.
     * Bu durumda child class'larda PageFactory.initElements(driver, this);
     * kullanmaya gerek kalmaz. tercih sizin
     * @param driver
     */

    protected BasePage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);

    }

    /**
     * click methodu tanimlayiniz
     * WebElement bir parametre alacak
     * @param element
     */
    public void click(WebElement element){
        scrollIntoView(element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    /**
     * sendkeys method tanimlayiniz
     * WebElement ve String iki parametre alacak
     * @param element
     * @param text
     */
    public void sendKeys(WebElement element, String text){
        scrollIntoView(element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);


    }

    /**
     * scrollIntoView methodu tanimlayiniz
     * WebElement bir parametre alacak
     * @param element
     */
    public void scrollIntoView(WebElement element){
        new Actions(driver)
                .scrollToElement(element).perform();


    }


}
