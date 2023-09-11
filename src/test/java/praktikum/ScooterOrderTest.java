package praktikum;

import org.junit.Rule;
import org.junit.Test;
import praktikum.pages.*;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ScooterOrderTest {
    @Rule
    public DriverRule driverRule = new DriverRule();

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

