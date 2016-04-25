package automatictester.jwebfwk.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import automatictester.jwebfwk.framework.ParentPage;


public class DownloadPage extends ParentPage {
	
	private static final String DOWNLOAD_LINK = "//div[@id='mainContent']//table[1]//tbody//td[text()='%s']//..//td[4]//a[text()='Download']";

    public DownloadPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasDownloadLinkFor(String linkText) {
        By downloadLinkLocator = By.xpath(String.format(DOWNLOAD_LINK, linkText));
        return hasElement(downloadLinkLocator);
    }

}
