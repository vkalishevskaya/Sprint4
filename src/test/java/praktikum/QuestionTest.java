package praktikum;

import org.junit.Rule;
import org.junit.Test;
import praktikum.pages.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuestionTest {

    @Rule
    public DriverRule driverRule = new DriverRule();

    private final int id;
    private final String question;
    private final String answer;

    //Конструктор для данных
    public QuestionTest(int id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }


    @Parameterized.Parameters
    public static Object[][] listFaq() {
        return new Object[][]{
                {0, "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void checkTabFaq() {
        MainPage mainPage = new MainPage(driverRule.getDriver());

        mainPage.open();
        mainPage.scrollToFAQ();


        WebElement tabTitle = mainPage.getQuestion(this.id);
        WebElement tabDescription = mainPage.getAnswer(this.id);
        mainPage.scrollToTabTitle(tabTitle);
        mainPage.waitThatTabTitleDisplayed(this.id);
        tabTitle.click();
        mainPage.waitThatTabTextDisplayed(this.id);
        assertEquals(this.question, tabTitle.getText());
        assertEquals(this.answer, tabDescription.getText());
    }
}
