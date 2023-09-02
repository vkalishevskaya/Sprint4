package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

import java.time.Duration;

public class DetailsPage {
    final WebDriver driver;
    public static final By aboutHeader = By.className("Order_Header__BZXOb"); // хэдер страницы Про аренду
    public static final By dateInput = By.cssSelector("[placeholder*='Когда']"); // плейсхолдер ввода даты
    public static final By rentalDuration = By.className("Dropdown-arrow");// кнопка открытия выпадающего меню
    public static final By blackColor = By.id("black"); // выбор черного самоката
    public static final By orderButton = By.className("Button_Middle__1CSJM"); // кнопка Заказать
    public DetailsPage(WebDriver driver) {
        this.driver = driver;
    }
    public DetailsPage waitForAboutHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfigs.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(aboutHeader));
        return this;
    }
    public DetailsPage putDate(String date){
        driver.findElement(dateInput).sendKeys(date);
        return this;
    }
    public DetailsPage getRentDuration() {
        driver.findElement(rentalDuration).click();
        return this;
    }
    public DetailsPage chooseRentDuration() {
        driver.findElements(By.className("Dropdown-option")).get(3).click();
        return this;
    }
    public DetailsPage chooseColor() {
        driver.findElement(blackColor).click();
        return this;
    }
    public AcceptWindow clickOrderButton() {
        driver.findElement(orderButton).click();
        return new AcceptWindow(driver);
    }

}

