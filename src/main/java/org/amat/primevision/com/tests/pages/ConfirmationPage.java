package org.amat.primevision.com.tests.pages;

import org.amat.primevision.com.tests.common.AbstractCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class  ConfirmationPage extends AbstractCommon {
    WebDriver driver;
    WebDriverWait wait;
    public ConfirmationPage(WebDriver driver, WebDriverWait wait) {

        super(driver,wait);
        this.driver = driver;
        this.wait=wait;
        PageFactory.initElements(driver, this);
    }








        @FindBy(css = ".hero-primary")
        WebElement confirmationMessage;

        public String getConfirmationMessage()
        {
            //CheckoutPage cp = new CheckoutPage(driver);
            return confirmationMessage.getText();
        }


    }
