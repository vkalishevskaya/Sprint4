package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {


    final WebDriver driver;

    private static final By showStatusButton = By.cssSelector("[class*='Header_Button']"); // кнопка Статус заказа
    private static final By orderNumberInput = By.xpath(".//input[contains(@class, 'Input_Input_')]"); // поле ввода номера заказа
    private static final By goButton = By.className("Header_Link__1TAG7"); // кнопка Go
    public static final By dropQuestion1 = By.id("accordion__heading-40"); // 1-й вопрос
    public static final By dropAnswer1 = By.id("accordion__panel-40"); // 1-й выпадающий ответ
    public static final By orderButton = By.className("Button_Button__ra12g"); // кнопка Заказать вверху страницы
    public static final By orderButtonMiddlePage = By.cssSelector("[class*='Button_Middle']"); // кнопка Заказать посередине страницы
    public static final By dropQuestion3 = By.id("accordion__heading-42"); // 3-й вопрос
    public static final By dropAnswer3 = By.id("accordion__panel-42");// 3-й выпадающий ответ
    public static final By acceptCookie = By.className("App_CookieButton__3cvqF"); // Кнопка Да все привыкли

    public MainPage(WebDriver driver) {

        this.driver = driver;
    }


    public MainPage open() {
        driver.get(EnvConfigs.BASE_URL);
        return this;
    }


    public TrackPage clickOnShowStatus() {
        driver.findElement(showStatusButton).click();
        return new TrackPage(driver);
    }

    public OrderPage clickOrderButton() {
        driver.findElement(orderButton).click();
        return new OrderPage(driver);
    }
    public OrderPage clickOrderButtonMiddlePage() {
        driver.findElement(orderButtonMiddlePage).click();
        return new OrderPage(driver);
    }

    public MainPage typeOrderNumber(String orderNumber) {
        driver.findElement(orderNumberInput).sendKeys(orderNumber);
        return this;
    }



    public MainPage clickOnGoButton() {
        driver.findElement(goButton).click();
        return this;
    }
    public MainPage clickAcceptCookies() {
        driver.findElement(acceptCookie).click();
        return this;
    }


    public MainPage clickOnQuestion1() {
        driver.findElement(dropQuestion1).click();
        return this;
    }
    public MainPage getAnswer1() {
        driver.findElement(dropAnswer1);
        return this;
    }
    public MainPage scrollToQuestion1() {
        WebElement element = driver.findElement(By.id("accordion__heading-40"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    public MainPage scrollToButton() {
        WebElement element = driver.findElement(By.className("Header_Button__28dPO"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    public MainPage waitForButton() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfigs.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(orderButtonMiddlePage));
        return this;
    }

    public MainPage waitForQuestion1() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfigs.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(dropQuestion1));
        return this;
    }
    public String answerText1(){
        return driver.findElement(dropAnswer1).getText();
    }
    public MainPage scrollToQuestion3() {
        WebElement element = driver.findElement(By.id("accordion__heading-42"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }
    public MainPage waitForQuestion3() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfigs.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(dropQuestion3));
        return this;
    }
    public MainPage clickOnQuestion3() {
        driver.findElement(dropQuestion3).click();
        return this;
    }
    public MainPage getAnswer3() {
        driver.findElement(dropAnswer3);
        return this;
    }
    public String answerText3(){
        return driver.findElement(dropAnswer3).getText();
    }

}
