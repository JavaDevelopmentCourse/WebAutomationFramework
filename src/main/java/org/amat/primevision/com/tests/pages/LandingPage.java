package org.amat.primevision.com.tests.pages;

import org.amat.primevision.com.tests.common.AbstractCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends AbstractCommon {


     WebDriver driver;
     WebDriverWait wait;
  public   LandingPage(WebDriver driver, WebDriverWait wait)
    {
        super(driver,wait);
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "login")
    WebElement submitButton;

    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;
    public String getErrorMessage()
    {
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }

    public ProductCatalogue loginApplications(String userName,String password)
    {
        userEmail.sendKeys(userName);
        userPassword.sendKeys(password);
        submitButton.click();
        return new ProductCatalogue(driver,wait);
    }
    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/client");
    }



}
