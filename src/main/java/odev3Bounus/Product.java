package odev3Bounus;

import lombok.*;
import org.openqa.selenium.WebElement;
@Getter
@Setter
@ToString
@AllArgsConstructor

public class Product {

    /**
     * WebElement name;
     * double price;
     * WebElement addToCart
     * instance variable'lari tanimlidir
     * lombok'un @Getter, @Setter, @ToString ve @AllArgsConstructor annotationslarini kullanir
     */
    WebElement name;
    double price;
    WebElement addToCart;


}
