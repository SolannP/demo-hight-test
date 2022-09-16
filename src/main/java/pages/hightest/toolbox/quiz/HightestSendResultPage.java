package pages.hightest.toolbox.quiz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.PageObjectModel;

public class HightestSendResultPage extends PageObjectModel {

    private By emailInput = By.id("email");
    private By sendEmailButton = By.id("submitMail");

    public HightestSendResultPage(WebDriver driver) {
        super(driver);
    }

    public HightestSendResultPage setEmailAs(String email){
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public HightestSendResultPage sendResultToEmail(){
        driver.findElement(sendEmailButton).click();
        return this;
    }


}
