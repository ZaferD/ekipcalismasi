package odev3Bounus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {


    //
    private final String URL = "https://www.saucedemo.com/";
    String title="Swag Labs";
    @FindBy(id = "user-name")
    private WebElement eUsername;

    @FindBy(id = "password")
    private WebElement ePassword;

    @FindBy(id = "login-button")
    private WebElement eLoginButton;

    @FindBy(css = ".app_logo")
    private WebElement eAppLogo;

    @FindBy(id = "shopping_cart_container")
    private WebElement eCart;

    @FindBy(xpath = "//span[text()='Your Cart']")
    private WebElement eCartHeader;


    /**
     * constructor
     * WebDriver alacak ve elementler initialize edilecek
     *
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * ana sayfayi get eden method
     */
    public void gotoSite() {
        driver.get(URL);

    }

    /**
     * sayfanin title'ini assert eden method
     *
     * @param title
     */
    public void assertTitle(String title) {

        Assert.assertEquals(driver.getTitle(),title,"Sayfanın title FAILED");

    }

    /**
     * login yapan method
     *
     * @param username
     * @param password
     */
    public void login(String username, String password) {
    sendKeys(eUsername, username);
    sendKeys(ePassword,password);
    click(eLoginButton);
    }

    /**
     * aldigi element visible oluncaya kadar bekleyen element
     *
     * @param element
     */
    private void assertVisibility(WebElement element) {
    wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Login olundugunu assert eden method
     */
    public void assertToLogin() {
    assertVisibility(eAppLogo);
    }

    /**
     * cart sayfasina girildigini assert eden method
     */
    public void assertToCart() {
    assertVisibility(eCartHeader);
    }

    /**
     * cart sayfasina giden method
     */
    public void gotoCart() {
    click(eCart);
    }

}
