package org.amat.primevision.com.tests.pages;

import org.amat.primevision.com.tests.common.AbstractCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderPage  extends AbstractCommon {


    WebDriver driver;
    WebDriverWait wait ;
    @FindBy(css = ".totalRow button")
    WebElement checkoutEle;

    @FindBy(css = "tr td:nth-child(3)")
    private List<WebElement> productNames;

    public OrderPage(WebDriver driver,WebDriverWait wait) {
        super(driver,wait);
        this.driver = driver;
        this.wait=wait;
        PageFactory.initElements(driver, this);

    }

    public Boolean VerifyOrderDisplay(String productName) {
        Boolean match = productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
        return match;

    }

}
