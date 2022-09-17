package pages.hightest.toolbox.quiz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageObjectModel;

import java.time.Duration;

public class HightestQuizPage extends PageObjectModel {
    private String expectedUrl = "https://hightest.nc/ressources/test-istqb-tae2.php";
    private By allQuiz = By.xpath("//div/input[@type='radio']");
    private By finishButton = By.xpath("//div/input[@type='submit']");
    private By questionsSectionIndex;
    private WebDriverWait wait;
    public HightestQuizPage(WebDriver driver) {
        super(driver);
        moveoToTab(expectedUrl);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(allQuiz));
    }

    /**
     * Allow to select a question to respond
     * @param questionIndex starting at 1
     * @return RadioButtonsAnwserChoice having method for selecting answer
     * @see RadioButtonsAnwserChoice
     */
    public RadioButtonsAnwserChoice respondToQuestion(int questionIndex) {
        questionsSectionIndex = By.xpath("//form/div["+ questionIndex + "]");
        scrollToElement(questionsSectionIndex);
        return new RadioButtonsAnwserChoice(driver, questionsSectionIndex);
    }

    /**
     * Finish the quiz using dedicated button
     */
    public HightestSendResultPage clickOnFinishQuizButton(){
        moveToElement(finishButton);
        driver.findElement(finishButton).click();
        return new HightestSendResultPage(driver);
    }


    public class RadioButtonsAnwserChoice extends PageObjectModel {
        private By responseOne = By.xpath(".//input[@value=1][@type='radio']");
        private By responseTwo = By.xpath(".//input[@value=2][@type='radio']");
        private By responseThree = By.xpath(".//input[@value=3][@type='radio']");
        private By responseFour = By.xpath(".//input[@value=4][@type='radio']");
        private By allPossibleResponse;

        public RadioButtonsAnwserChoice(WebDriver driver,By questionSection){
            super(driver);
            allPossibleResponse = questionSection;
        }
        /**
         * Click on a radio button based on index
         * @param indexNumber start at 1
         */
        public void selectRadioButtonAnswer(int indexNumber){
            switch (indexNumber){
                case 1 -> driver.findElement(allPossibleResponse).findElement(responseOne).click();
                case 2 -> driver.findElement(allPossibleResponse).findElement(responseTwo).click();
                case 3 -> driver.findElement(allPossibleResponse).findElement(responseThree).click();
                case 4 -> driver.findElement(allPossibleResponse).findElement(responseFour).click();
                default -> throw new UnsupportedOperationException("Question index is unknown. Please control if index or question exist.");
            }
        }
    }
}
