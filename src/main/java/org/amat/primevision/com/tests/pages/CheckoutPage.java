package org.amat.primevision.com.tests.pages;

import org.amat.primevision.com.tests.common.AbstractCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

;

public class CheckoutPage extends AbstractCommon {
    WebDriver driver;
    WebDriverWait wait ;
    public CheckoutPage(WebDriver driver,WebDriverWait wait) {
        super(driver,wait);
        this.driver = driver;
        this.wait=wait;
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = ".action__submit")
    private WebElement submit;

    @FindBy(css = "[placeholder='Select Country']")
    private WebElement country;

    @FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
    private WebElement selectCountry;

    private By results = By.cssSelector(".ta-results");

    public void selectCountry(String countryName) {
        Actions a = new Actions(driver);
        a.sendKeys(country, countryName).build().perform();
        waitForElementToAppear(By.cssSelector(".ta-results"));
        selectCountry.click();
    }

    public ConfirmationPage submitOrder()
    {
        submit.click();
        return new ConfirmationPage(driver,wait);


    }
}
