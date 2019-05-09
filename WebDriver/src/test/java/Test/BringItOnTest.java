package Test;

import Page.BringItOnPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BringItOnTest {

    private WebDriver driver;
    private BringItOnPage bringItOnPage;

    @Test
    public void isTitelTrue() {
        String titelExpected = "how to gain dominance among developers";
        Assert.assertTrue(bringItOnPage.getTitelPage().contains(titelExpected));
    }

    @Test
    public void isSyntaxBash() {
        String syntaxExpected = "Bash";
        Assert.assertEquals(bringItOnPage.getSyntax(), syntaxExpected);
    }

    @Test
    public void truePaste() {
        String textExpected = "git config --global user.name  \"New Sheriff in Town\"\ngit reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\ngit push origin master --force";
        Assert.assertEquals(bringItOnPage.getPaste(), textExpected);
    }

    @Before
    public void beforeClass() {
        bringItOnPage = new BringItOnPage(driver = new ChromeDriver());
        driver.get("https://pastebin.com/");
        String text = "git config --global user.name  \"New Sheriff in Town\"\ngit reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\ngit push origin master --force";
        String titel = "how to gain dominance among developers";
        bringItOnPage.makeDifferentActionsWithPage(text, titel);
    }

    @After
    public void afterClass() {
        driver.quit();
    }
}
