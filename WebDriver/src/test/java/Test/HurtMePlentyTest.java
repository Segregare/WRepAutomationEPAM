package Test;

import Page.BringItOnPage;
import Page.HurtMePlentyPage;
import Page.ICanWinPage;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class HurtMePlentyTest {

    private WebDriver driver;
    private HurtMePlentyPage hurtMePlentyPage;

    @Test
    public void isTrueTotalEstimatedCost() {
        Assert.assertTrue(hurtMePlentyPage.getTotalEstimatedCost().contains("1,187.77"));
    }

    @Test
    public void isTrueCommitmentTerm() {
        Assert.assertTrue(hurtMePlentyPage.getCommitmentTerm().contains("1 Year"));
    }

    @Test
    public void isTrueRegularClassVM() {
        Assert.assertTrue(hurtMePlentyPage.getClassVW().contains("regular"));
    }

    @Test
    public void isTrueSSD() {
        Assert.assertTrue(hurtMePlentyPage.getSSD().contains("2x375 GB"));
    }

    @Test
    public void isTrueInstanceType() {
        Assert.assertTrue(hurtMePlentyPage.getInstanceType().contains("n1-standard-8"));
    }

    @Test
    public void isTrueRegion() {
        Assert.assertTrue(hurtMePlentyPage.getRegion().contains("Frankfurt"));
    }

    @Before
    public void beforeClass() {
        hurtMePlentyPage = new HurtMePlentyPage(driver = new ChromeDriver());
        driver.get("https://cloud.google.com/");
        hurtMePlentyPage.calculateCostOfProducts();
    }

    @After
    public void afterClass() {
        driver.quit();
    }
}
