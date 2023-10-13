package praktikum;

import org.junit.Rule;
import org.junit.Test;
import praktikum.pages.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class InvalidOrderNumberTest {


    @Rule
    public DriverRule driverRule = new DriverRule();


    @Test // Тест некорректного номера заказа
    public void invalidOrderNumber() {
        MainPage mainPage = new MainPage(driverRule.getDriver());

        mainPage.open()
                .clickOnGoButton()
                .typeOrderNumber(EnvConfigs.INVALID_ORDER_NUBMER);

        TrackPage trackPage = mainPage.clickOnShowStatus();
        trackPage.waitForOrderNotFound();
    }
}






