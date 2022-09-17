package pages.yopmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.PageObjectModel;
import pages.yopmail.emailbox.YopMailEmailBox;

import java.util.Random;

public class YopMailHomePage extends PageObjectModel {

    private By emailAdressCreationInput = By.id("login");
    private By emailGenerationInput = By.xpath("//div[@id='refreshbut']/button");
    private By centerCookiesCloseButton = By.id("accept");

    public YopMailHomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Set email address to use
     * @param email as String
     * @see YopMailAddress for a generate a better email string
     */
    public YopMailHomePage setEmailAdress(YopMailAddress email){
        driver.findElement(emailAdressCreationInput).sendKeys(email.toString());
        return this;
    }

    /**
     * Generate an email an go to boxmail page
     */
    public YopMailEmailBox clickOnGenerateRandomAdress(){
        driver.findElement(emailGenerationInput).click();
        return new YopMailEmailBox(driver);
    }

    public YopMailHomePage acceptCookies(){
        driver.findElement(centerCookiesCloseButton).click();
        return this;
    }
    public static class YopMailAddress {
        private String email;
        public YopMailAddress(){
            var randomGenerator = new Random();
            String uniqueRandomIntAsId = String.valueOf(randomGenerator.nextInt());
            email= "slnium" + uniqueRandomIntAsId + "@yopmail.fr";
        }
        public YopMailAddress(String name){
            email = name + "@yopmail.fr";
        }
        @Override
        public String toString(){
            return email;
        }
    }

}
