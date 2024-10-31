package org.amat.primevision.com.tests.common;

import org.amat.primevision.com.tests.pages.CartPage;
import org.amat.primevision.com.tests.pages.OrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractCommon {
        WebDriver driver;
        WebDriverWait wait;
        public AbstractCommon(WebDriver driver,WebDriverWait wait)
        {
            this.driver=driver;
            this.wait=wait;
            PageFactory.initElements(driver,this);
        }
    @FindBy(css = "[routerlink*='cart']")
    WebElement cartHeader;
    @FindBy(css = "[routerlink*='myorders']")
    WebElement orderHeader;

        public CartPage goToCharPage()
        {
            cartHeader.click();
            return new CartPage(driver,wait);
        }
    public void waitForElementToAppear(By findBy) {


        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

    }

    public void waitForWebElementToAppear(WebElement findBy) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));

    }

    public void waitforElementToDispear(WebElement findby) throws Exception {
       /* wait.until(ExpectedConditions.invisibilityOf(findby));*/
        Thread.sleep(1000);
    }

    public OrderPage goToOrdersPage()
    {
        orderHeader.click();
        OrderPage orderPage = new OrderPage(driver,wait);
        return orderPage;
    }
}
