package praktikum;

import org.junit.Rule;
import org.junit.Test;
import praktikum.pages.*;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class test {


    @Rule
    public DriverRule driverRule = new DriverRule();


    @Test // Тест некорректного номера заказа
    public void invalidOrderNumber(){
        MainPage mainPage = new MainPage(driverRule.getDriver());

        mainPage.open()
                .clickOnGoButton()
                .typeOrderNumber(EnvConfigs.INVALID_ORDER_NUBMER);

        TrackPage trackPage = mainPage.clickOnShowStatus();
        trackPage.waitForOrderNotFound();

    }


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

    @Test // Тест заказ самоката 1
    public void order() {
        MainPage mainPage = new MainPage(driverRule.getDriver());

        mainPage.open();
        
        OrderPage orderPage = mainPage.clickOrderButton()
                .waitForOrderPageHeader()
                .typeName(EnvConfigs.DEFAULT_NAME)
                .typeSecondName(EnvConfigs.DEFAULT_SECONDNAME)
                .typeAdress(EnvConfigs.DEFAULT_ADRESS)
                .clickOnMetroSelector()
                .chooseMetroStation()
                .phoneInput(EnvConfigs.DEFAULT_PHONE_NUMBER);
        DetailsPage detailsPage = orderPage.clickOnNextButton()
                .waitForAboutHeader()
                .putDate(EnvConfigs.FUTURE_DATE)
                .getRentDuration()
                .chooseRentDuration()
                .chooseColor();
       AcceptWindow acceptWindow = detailsPage.clickOrderButton()
                .clickOnYesButton();
       String actualText = acceptWindow.successfullOrderText();
       assertThat(actualText, startsWith("Заказ оформлен"));
    }

        @Test // Тест заказ самоката 2
        public void orderMiddlePage() {
            MainPage mainPage = new MainPage(driverRule.getDriver());

            mainPage.open()
                    .scrollToButton()
                    .waitForButton();
            OrderPage orderPage = mainPage.clickOrderButtonMiddlePage()
                    .waitForOrderPageHeader()
                    .typeName(EnvConfigs.DEFAULT_NAME)
                    .typeSecondName(EnvConfigs.DEFAULT_SECONDNAME)
                    .typeAdress(EnvConfigs.DEFAULT_ADRESS)
                    .clickOnMetroSelector().chooseMetroStation()
                    .phoneInput(EnvConfigs.PHONE_NUMBER_WITHOUT_PLUS);
            DetailsPage detailsPage = orderPage.clickOnNextButton()
                    .waitForAboutHeader()
                    .putDate(EnvConfigs.EXP_DATE)
                    .getRentDuration()
                    .chooseRentDuration()
                    .chooseColor();
            AcceptWindow acceptWindow = detailsPage.clickOrderButton()
                    .clickOnYesButton();
            String actualText = acceptWindow.successfullOrderText();
            assertThat(actualText, startsWith("Заказ оформлен"));
    }
}


