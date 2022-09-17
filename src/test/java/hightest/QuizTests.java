package hightest;

import base.BaseTestsDesktop;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.hightest.toolbox.HightestToolBoxPage;
import pages.hightest.toolbox.quiz.HightestQuizPage;
import pages.yopmail.YopMailHomePage;
import pages.yopmail.emailbox.YopMailEmailBox;

public class QuizTests extends BaseTestsDesktop {

    @DataProvider(name="ResponseISTQB")
    private Object[][] getTestIstqbResponse() {
        return new Object[][]{
                //{"Vous avez bien répondu à 20 question(s) sur 20, soit 100 % de réussite. Félicitations, vous avez obtenu le score maximal !",1,2,1,2,2,3,2,4,1,3,4,2,3,2,4,3,3,1,2,2},
                //{"Vous avez bien répondu à 19 question(s) sur 20, soit 95 % de réussite. C'est suffisant pour cet examen qui demande 65 % de réponses justes. Bravo !",4,2,1,2,2,3,2,4,1,3,4,2,3,2,4,3,3,1,2,2},
                {"Vous avez bien répondu à 13 question(s) sur 20, soit 65 % de réussite. C'est suffisant pour cet examen qui demande 65 % de réponses justes. Bravo !",4,4,4,4,4,4,4,4,1,3,4,2,3,2,4,3,3,1,2,2},
                //{"Vous avez bien répondu à 12 question(s) sur 20, soit 60 % de réussite. Il faudrait monter jusqu'à 65 %. Courage !",4,4,4,4,4,4,4,1,1,3,4,2,3,2,4,3,3,1,2,2},
                //{"Vous avez bien répondu à 0 question(s) sur 20, soit 0 % de réussite. Il faudrait monter jusqu'à 65 %. Courage !",4,4,4,4,4,4,4,1,4,4,1,4,4,4,1,4,4,4,4,4},
        };
    }
    /**
     * Test responding ISTQB question based on index
     */
    @Test(dataProvider="ResponseISTQB")
    public void AllCorrectAnswerForQuizRegardingISTQB(String expectedResult,int val1,int val2,int val3,int val4,int val5,int val6,int val7,int val8,int val9,int val10,int val11,int val12,int val13,int val14,int val15,int val16,int val17,int val18,int val19,int val20){
        yopMailHomePage.moveoToTab(urlYopMailHome);
        yopMailHomePage.acceptCookies();
        YopMailHomePage.YopMailAddress email = new YopMailHomePage.YopMailAddress();
        YopMailEmailBox mailBox = yopMailHomePage.setEmailAdress(email)
                                                 .clickOnGenerateRandomAdress();

        hightestHomePage.moveoToTab(urlHightestHome);
        hightestHomePage.acceptCookies()
                        .closeNewsLetter();
        HightestQuizPage hightestQuizPage = hightestHomePage.clickOnToolboxTab()
                                                            .clickOnQuizByTitle("Quiz ISTQB niveau Foundation", HightestToolBoxPage.Language.FRA);
        hightestQuizPage.respondToQuestion(1).selectRadioButtonAnswer(val1);
        hightestQuizPage.respondToQuestion(2).selectRadioButtonAnswer(val2);
        hightestQuizPage.respondToQuestion(3).selectRadioButtonAnswer(val3);
        hightestQuizPage.respondToQuestion(4).selectRadioButtonAnswer(val4);
        hightestQuizPage.respondToQuestion(5).selectRadioButtonAnswer(val5);
        hightestQuizPage.respondToQuestion(6).selectRadioButtonAnswer(val6);
        hightestQuizPage.respondToQuestion(7).selectRadioButtonAnswer(val7);
        hightestQuizPage.respondToQuestion(8).selectRadioButtonAnswer(val8);
        hightestQuizPage.respondToQuestion(9).selectRadioButtonAnswer(val9);
        hightestQuizPage.respondToQuestion(10).selectRadioButtonAnswer(val10);
        hightestQuizPage.respondToQuestion(11).selectRadioButtonAnswer(val11);
        hightestQuizPage.respondToQuestion(12).selectRadioButtonAnswer(val12);
        hightestQuizPage.respondToQuestion(13).selectRadioButtonAnswer(val13);
        hightestQuizPage.respondToQuestion(14).selectRadioButtonAnswer(val14);
        hightestQuizPage.respondToQuestion(15).selectRadioButtonAnswer(val15);
        hightestQuizPage.respondToQuestion(16).selectRadioButtonAnswer(val16);
        hightestQuizPage.respondToQuestion(17).selectRadioButtonAnswer(val17);
        hightestQuizPage.respondToQuestion(18).selectRadioButtonAnswer(val18);
        hightestQuizPage.respondToQuestion(19).selectRadioButtonAnswer(val19);
        hightestQuizPage.respondToQuestion(20).selectRadioButtonAnswer(val20);
        hightestQuizPage.clickOnFinishQuizButton()
                        .setEmailAs(email.toString())
                        .sendResultToEmail();

        hightestQuizPage.moveoToTab(urlYopMailBox);

        mailBox.acceptCookies()
                .waitIncomingEmailBasedOnIndex(1,10)
                .selectIncomingEmailBasedOnIndex(1);

        var resultISTQBQuiz = mailBox.getSectionInMailContaining(expectedResult);
        assert resultISTQBQuiz.isEmpty() == false;
    }
}
