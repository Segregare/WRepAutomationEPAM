package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BringItOnPage {

    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(id = "header_new_paste")
    private WebElement newPasteButton;

    @FindBy(xpath = "//textarea[@name='paste_code']")
    private WebElement inputField;

    @FindBy(xpath = "(//span[@class='select2-selection__arrow'])[1]")
    private WebElement dropSyntax;

    @FindBy(xpath = "(//*[@class='select2-results__option'])[2]")
    private WebElement selectSyntax;

    @FindBy(xpath = "(//span[@class='select2-selection__arrow'])[2]")
    private WebElement dropDate;

    @FindBy(xpath = "(//*[@class='select2-results__option'])[1]")
    private WebElement selectDate;

    @FindBy(xpath = "//input[@name='paste_name']")
    private WebElement inputWord;

    @FindBy(xpath = "//*[@value='Create New Paste']")
    private WebElement saveNewPaste;

    @FindBy(xpath = "(.//a[@class=\"buttonsm\"])[4]")
    private WebElement syntax;

    @FindBy(xpath = ".//textarea[@id=\"paste_code\"]")
    private WebElement actualPaste;

    public BringItOnPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);

        PageFactory.initElements(driver, this);
    }

    public void makeDifferentActionsWithPage(String text, String line) {
        newPasteButton.click();
        inputField.sendKeys(text);
        dropSyntax.click();
        selectSyntax.click();
        dropDate.click();
        selectDate.click();
        inputWord.sendKeys(line);
        saveNewPaste.click();
    }

    public String getTitelPage() {
        return driver.getTitle();
    }

    public String getSyntax() {
        return syntax.getText();
    }

    public String getPaste() {
        return actualPaste.getText();
    }
}
