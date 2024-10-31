package org.amat.primevision.com.tests.pages;

import org.amat.primevision.com.tests.common.AbstractCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductCatalogue extends AbstractCommon {

    WebDriver driver;
    WebDriverWait wait ;
    public ProductCatalogue(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);

        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }

    By productsBy = By.cssSelector(".mb-3");
   By productName= By.cssSelector(".card-body button:last-of-type");

    By toastMessage=  By.cssSelector("#toast-container");

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
    WebElement spinner;

    public List<WebElement> getProductList() {
        waitForElementToAppear(productsBy);
        return products;
    }


    public WebElement getProductByName(String productname)
    {
        WebElement eachproduct = getProductList().stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
        return eachproduct;
    }

    public void addProductToCart(String productname) throws Exception {

        WebElement productByName = getProductByName(productname);
        productByName.findElement(productName).click();
        waitForElementToAppear(toastMessage);
        waitforElementToDispear(spinner);

    }
}
