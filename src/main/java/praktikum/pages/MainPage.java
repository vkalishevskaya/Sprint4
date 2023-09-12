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
    private final By sectionFAQ = By.className("Home_FourPart__1uthg"); //блок вопрос-ответ на главной странице
    private final String questionPrefix = "accordion__heading-"; // n-ый вопрос
    private final String answerPrefix = "accordion__panel-";  // n-ый ответ
    public static final By orderButton = By.className("Button_Button__ra12g"); // кнопка Заказать вверху страницы
    public static final By orderButtonMiddlePage = By.cssSelector("[class*='Button_Button__ra12g']"); // кнопка Заказать посередине страницы
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


    public void scrollToButton() {
        ActionHelper.scrollTo(driver, orderButtonMiddlePage);
    }

    public MainPage waitForButton() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfigs.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(orderButtonMiddlePage));
        return this;
    }

    public void scrollToFAQ() {
        ActionHelper.scrollTo(driver, sectionFAQ);
    }
    public WebElement getQuestion(int id) {
        return driver.findElement(By.id(questionPrefix + id));
    }

    public WebElement getAnswer(int id) {
        return driver.findElement(By.id(answerPrefix + id));
    }

    public void scrollToTabTitle(WebElement tabTitle) {
        ActionHelper.doScrolling(driver, tabTitle);
    }

    public void waitThatTabTitleDisplayed(int id) {
        ActionHelper.waitDisplayedElement(driver, By.id(questionPrefix + id));
    }

    public void waitThatTabTextDisplayed(int id) {
        ActionHelper.waitDisplayedElement(driver, By.id(answerPrefix + id));
    }

}
