package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AcceptWindow {
    final WebDriver driver;
    private static final By orderModalHeader = By.cssSelector("[class*='orderModalHeader']"); // Заголовок окна подтверждения заказа
    private static final By yesButton = By.className("Button_Middle__1CSJM"); // Кнопка Да в окне подтверждения заказа
    public static final By gotOrder = By.cssSelector("[class*='Button_Middle']"); // Заголовок окна Заказ оформлен


    public AcceptWindow(WebDriver driver) {

        this.driver = driver;
    }
    public AcceptWindow waitForAboutHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfigs.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(orderModalHeader));
        return this;
    }

    public AcceptWindow clickOnYesButton(){
        driver.findElement(yesButton).click();
        return this;
    }

    public String successfullOrderText(){
        return driver.findElement(gotOrder).getText();
    }




}
