package Test;

import Page.ICanWinPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class ICanWinTest {

    static WebDriver driver;


    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://pastebin.com");

        ICanWinPage pasteBinPage = PageFactory.initElements(driver, ICanWinPage.class);

        pasteBinPage.makeActionsWithPage();
    }
}
