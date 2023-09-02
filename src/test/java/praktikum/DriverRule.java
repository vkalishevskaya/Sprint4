package praktikum;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.time.Duration;

public class DriverRule extends ExternalResource {
    WebDriver driver;


    @Override
    protected void before() throws Throwable {
        if ("firefox".equals(System.getProperty("browser")))
            SetUpFirefox();
        else
            SetUpChrome();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    public void SetUpChrome(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("/Users/v.kalishevskaya/Downloads/chromedriver-mac-x64/chromedriver"))
                .build();

        ChromeOptions options = new ChromeOptions()
                .setBinary("/Users/v.kalishevskaya/Downloads/chrome-mac-x64 2/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");

        driver = new ChromeDriver(service);
    }

    /* static void setupAll() {
        WebDriverManager.chromedriver().setup();
    } */

    public void SetUpFirefox(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        GeckoDriverService service = new GeckoDriverService.Builder()
                .usingDriverExecutable(new File("/Users/v.kalishevskaya/Downloads/geckodriver"))
                .build();

        FirefoxOptions options = new FirefoxOptions()
                .setBinary("/Users/v.kalishevskaya/Downloads/chromedriver-mac-x64/chromedriver/Applications/Firefox.app");

        driver = new FirefoxDriver(service, options);
    }

    @Override
    protected void after() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
