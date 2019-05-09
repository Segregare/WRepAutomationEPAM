package Test;

import Page.BringItOnPage;
import Page.HardCorePage;
import Page.HurtMePlentyPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HardCoreTest {

    private WebDriver driver;
    private HardCorePage hardCorePage;
    private HurtMePlentyPage hurtMePlentyPage;


    @Test
    public void isTrueCost() {
        hurtMePlentyPage.calculateCostOfProducts();
        hardCorePage.sendEmail();
        String actualResult = hardCorePage.receivedCost();
        String expectedResult = hardCorePage.actualCost();
        Assert.assertTrue(expectedResult.contains(actualResult));
    }

    @BeforeClass
    public void beforeClass() {
        driver.get("https://cloud.google.com/");
        hurtMePlentyPage = new HurtMePlentyPage(driver = new ChromeDriver());
        hardCorePage = new HardCorePage(driver = new ChromeDriver());
        hardCorePage.sendEmail();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
