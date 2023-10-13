package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    final WebDriver driver;
    public static final By orderPageHeader = By.className("Order_Content__bmtHS"); // хэдер страницы Для кого самокат
    public static final By nameInput = By.cssSelector("[placeholder*='Имя']"); // плейсхолдер для ввода имени
    public static final By secondNameInput = By.cssSelector("[placeholder*='Фамилия']"); // плейсхолдер для ввода фамилии
    public static final By adressInput = By.cssSelector("[placeholder*='Адрес']"); // плейсхолдер для ввода адреса
    public static final By stationSelector = By.className("select-search__input"); // кнопка Станция метро
    public static final By boulevard = By.cssSelector("[value='1']"); // станция метро Бульвар Рокоссовского
    public static final By phoneNumberInput = By.cssSelector("[placeholder*='Телефон']"); // плейсхолдер для ввода номера телефона
    public static final By nextButton = By.className("Button_Middle__1CSJM"); // кнопка Далее




    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPage waitForOrderPageHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfigs.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(orderPageHeader));
        return this;
    }
    public DetailsPage clickOnNextButton() {
        driver.findElement(nextButton).click();
        return new DetailsPage (driver);
    }
    public OrderPage typeName(String name) {
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    public OrderPage typeSecondName(String secondName) {
        driver.findElement(secondNameInput).sendKeys(secondName);
        return this;
    }

    public OrderPage typeAdress(String adress) {
        driver.findElement(adressInput).sendKeys(adress);
        return this;
    }
    public OrderPage clickOnMetroSelector(){
        driver.findElement(stationSelector).click();
        return this;
    }
    public OrderPage chooseMetroStation(){
        driver.findElement(boulevard).click();
        return this;
    }

    public OrderPage phoneInput(String phoneNumber){
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
        return this;
    }


}
