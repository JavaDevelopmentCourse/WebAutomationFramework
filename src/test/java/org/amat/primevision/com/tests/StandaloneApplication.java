package org.amat.primevision.com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.amat.primevision.com.genericclass.BaseClass;
import org.amat.primevision.com.tests.pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class StandaloneApplication extends BaseClass {

    String productName = "ZARA COAT 3";


    @Test(dataProvider="getData",groups= {"Purchase"})
    public void testToSubmitOrder(HashMap<String,String> input) throws Exception {

        ProductCatalogue productCatalogue = landingPage.loginApplications(input.get("email"), input.get("password"));
        productCatalogue.addProductToCart(input.get("product"));
        CartPage cartPage =   productCatalogue.goToCharPage();
        Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
        assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String confirmMessage = confirmationPage.getConfirmationMessage();
        assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    @Test(dependsOnMethods= {"testToSubmitOrder"})
    public void OrderHistoryTest()
    {
        //"ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginApplications("sagar.nitin08@gmail.com", "Nitin*88");
        OrderPage ordersPage = productCatalogue.goToOrdersPage();
        assertTrue(ordersPage.VerifyOrderDisplay(productName));

    }


    @DataProvider
    public Object[][] getData() throws IOException
    {


        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//org//amat//primevision//com//data//PurchaseOrder.json");
        return new Object[][]  {{data.get(0)}, {data.get(1) } };

    }


    static void methodDummy() throws Exception {
        String productName = "ZARA COAT 3";
        // System.getProperties().setProperty("webdriver.chrome.driver", "S:\\WebAutomation\\driver\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(options);


        /*WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();*/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        LandingPage landingPage = new LandingPage(driver, wait);
        landingPage.goTo();
        ProductCatalogue productCatalogue = landingPage.loginApplications("sagar.nitin08@gmail.com", "Nitin*88");
       /* driver.findElement(By.id("userEmail")).sendKeys("sagar.nitin08@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Nitin*88");
        driver.findElement(By.id("login")).click();*/


       /* wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));*/
        // ProductCatalogue productCatalogue=new ProductCatalogue(driver,wait);
        //List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);

        /*WebElement eachproduct = products.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
        assert eachproduct != null;

        eachproduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();*/


        /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));*/
        //ng-animating
        //wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        /*driver.findElement(By.cssSelector("[routerlink*='cart']")).click();*/
        //      productCatalogue.goToCharPage();
        //     Boolean match = new CartPage(driver, wait).VerifyProductDisplay(productName);
        CartPage cartPage =   productCatalogue.goToCharPage();
        Boolean match = cartPage.VerifyProductDisplay(productName);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
       /* List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));*/
        assertTrue(match);
        /* driver.findElement(By.cssSelector(".totalRow button")).click();*/

        checkoutPage.selectCountry("india");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String confirmMessage = confirmationPage.getConfirmationMessage();


       /* Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
        driver.findElement(By.cssSelector(".action__submit")).click();*/

        //String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
        assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        driver.quit();
    }

}
