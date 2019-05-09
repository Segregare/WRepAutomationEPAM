package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.junit.*;




public class ICanWinPage {

    private WebDriver driver;

    public ICanWinPage(WebDriver driver){
       this.driver = driver;
    }

    @FindBy(id = "header_new_paste")
    private WebElement searchBtn;

    @FindBy(xpath = "//textarea[@name='paste_code']")
    private WebElement inputField;

    @FindBy(xpath = "(//span[@class='select2-selection__arrow'])[2]")
    private WebElement searchDropDown;

    @FindBy(xpath = "(//*[@class='select2-results__option'])[1]")
    private WebElement selectDate;

    @FindBy(xpath = "//input[@name='paste_name']")
    private WebElement inputWord;


    public void makeActionsWithPage() {
        searchBtn.click();
        inputField.sendKeys("Hello from WebDriver");
        searchDropDown.click();
        selectDate.click();
        inputWord.sendKeys("helloweb");
    }


}
