package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrackPage {

    final WebDriver driver;

    private static final By orderNotFound = By.cssSelector("[alt='Not found']"); // страница Такого заказа нет

    public TrackPage(WebDriver driver) {

        this.driver = driver;
    }
    public TrackPage waitForOrderNotFound() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfigs.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(orderNotFound));
        return this;
    }
}
