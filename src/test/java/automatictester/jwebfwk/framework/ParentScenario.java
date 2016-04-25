package automatictester.jwebfwk.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import automatictester.jwebfwk.page.objects.DownloadPage;
import automatictester.jwebfwk.page.objects.MainPage;

import java.util.concurrent.TimeUnit;

public class ParentScenario {
	
	private WebDriver driver;

    protected DownloadPage downloadPage;
    protected MainPage mainPage;

    protected void startBrowser() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        downloadPage = new DownloadPage(driver);
        mainPage = new MainPage(driver);
    }

    protected void navigateTo() {
        driver.navigate().to("http://docs.seleniumhq.org/");
    }

    protected void closeBrowser() {
        driver.quit();
    }

}
