package hightest;

import base.BaseTestsDesktop;
import org.testng.annotations.Test;
import pages.hightest.toolbox.HightestToolBoxPage;
import pages.hightest.toolbox.quiz.HightestQuizPage;
import pages.yopmail.YopMailHomePage;
import pages.yopmail.emailbox.YopMailEmailBox;

public class QuizTests extends BaseTestsDesktop {

    /**
     * Test responding question based on index
     */
    @Test
    public void AllCorrectAnswerForQuizRegardingISTQB(){

        yopMailHomePage.moveoToTab(urlYopMailHome);
        yopMailHomePage.acceptCookies();
        YopMailHomePage.YopMailAddress email = new YopMailHomePage.YopMailAddress("slnium-444207682");
        YopMailEmailBox mailBox = yopMailHomePage.setEmailAdress(email)
                                                 .clickOnGenerateRandomAdress();

        hightestHomePage.moveoToTab(urlHightestHome);
        hightestHomePage.acceptCookies()
                        .closeNewsLetter();

        HightestQuizPage hightestQuizPage = hightestHomePage.clickOnToolboxTab()
                                                            .clickOnQuizByTitle("Quiz ISTQB niveau Foundation", HightestToolBoxPage.Language.FRA);

        hightestQuizPage.respondToQuestion(1).selectRadioButtonAnswer(1);
        hightestQuizPage.respondToQuestion(2).selectRadioButtonAnswer(2);
        hightestQuizPage.respondToQuestion(3).selectRadioButtonAnswer(1);
        hightestQuizPage.respondToQuestion(4).selectRadioButtonAnswer(2);
        hightestQuizPage.respondToQuestion(5).selectRadioButtonAnswer(2);
        hightestQuizPage.respondToQuestion(6).selectRadioButtonAnswer(3);
        hightestQuizPage.respondToQuestion(7).selectRadioButtonAnswer(2);
        hightestQuizPage.respondToQuestion(8).selectRadioButtonAnswer(4);
        hightestQuizPage.respondToQuestion(9).selectRadioButtonAnswer(1);
        hightestQuizPage.respondToQuestion(10).selectRadioButtonAnswer(3);
        hightestQuizPage.respondToQuestion(11).selectRadioButtonAnswer(4);
        hightestQuizPage.respondToQuestion(12).selectRadioButtonAnswer(2);
        hightestQuizPage.respondToQuestion(13).selectRadioButtonAnswer(3);
        hightestQuizPage.respondToQuestion(14).selectRadioButtonAnswer(2);
        hightestQuizPage.respondToQuestion(15).selectRadioButtonAnswer(4);
        hightestQuizPage.respondToQuestion(16).selectRadioButtonAnswer(3);
        hightestQuizPage.respondToQuestion(17).selectRadioButtonAnswer(3);
        hightestQuizPage.respondToQuestion(18).selectRadioButtonAnswer(1);
        hightestQuizPage.respondToQuestion(19).selectRadioButtonAnswer(2);
        hightestQuizPage.respondToQuestion(20).selectRadioButtonAnswer(2);

        hightestQuizPage.clickOnFinishQuizButton()
                        .setEmailAs(email.toString())
                        .sendResultToEmail();

        hightestQuizPage.moveoToTab(urlYopMailBox);


        mailBox.acceptCookies()
                .waitIncomingEmailBasedOnIndex(1,10)
                .selectIncomingEmailBasedOnIndex(1);

        var resultISTQBQuiz = mailBox.getSectionInMailContaining("Vous avez bien répondu à 20 question(s) sur 20, soit 100 % de réussite. Félicitations, vous avez obtenu le score maximal !");
        assert resultISTQBQuiz.isEmpty() == false;
    }
}
