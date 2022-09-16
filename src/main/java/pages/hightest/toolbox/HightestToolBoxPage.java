package pages.hightest.toolbox;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import pages.PageObjectModel;
import pages.hightest.toolbox.quiz.HightestQuizPage;

public class HightestToolBoxPage extends PageObjectModel {
    private By targetButton;
    public HightestToolBoxPage(WebDriver driver) {
        super(driver);
    }
    public HightestQuizPage clickOnQuizByTitle(String title, Language language){
        switch (language){
            case FRA -> targetButton = By.xpath("//h2[contains(text(),'" +title+ "')]/following-sibling::*//a[contains(text(),'Français')]");
            case ENG -> targetButton = By.xpath("//h2[contains(text(),'" +title+ "')]/following-sibling::*//a[contains(text(),'Anglais')]");
            default -> throw new UnsupportedOperationException("Language enumerator is unknown. Please control the correct declaration of enum.");
        }
        boolean succesfullMovement = moveToElement(targetButton);
        if(succesfullMovement != true) throw new UnsupportedOperationException("Cannot click on requested language : not among the possibilities. Please check the available language for this card.");
        driver.findElement(targetButton).click();
        return new HightestQuizPage(driver);
    }
    /**
     * 3 letters country code using ISO-3166-1
     */
    public enum Language {
        FRA,
        ENG,
    }

}
