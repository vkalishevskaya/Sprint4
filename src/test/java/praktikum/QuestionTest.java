package praktikum;

import org.junit.Rule;
import org.junit.Test;
import praktikum.pages.*;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class QuestionTest {
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test // Тест 1-го вопроса
    public void dropListQuestions1() {
    MainPage mainPage = new MainPage(driverRule.getDriver());

    mainPage.open()
            .scrollToQuestion1()
            .waitForQuestion1()
            .clickOnQuestion1()
            .getAnswer1();

    String actualAnswer1 = mainPage.answerText1();
    assertThat(actualAnswer1, startsWith("Сутки"));
}

    @Test // Тест 3-го вопроса
    public void dropListQuestions3() {
        MainPage mainPage = new MainPage(driverRule.getDriver());

        mainPage.open()
                .scrollToQuestion3()
                .waitForQuestion3()
                .clickOnQuestion3()
                .getAnswer3();

        String actualAnswer3 = mainPage.answerText3();
        assertThat(actualAnswer3, startsWith("Сутки"));
    }
}
