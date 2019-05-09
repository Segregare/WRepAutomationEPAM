package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class HardCorePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[@href='https://cloud.google.com/products/' and @track-name='seeProducts']")
    private WebElement seeProducts;

    @FindBy(xpath = "//a[@track-name='seePricing']")
    private WebElement seePricing;

    @FindBy(xpath = "//a[@track-name='pricingNav/calculators']")
    private WebElement calculateProducts;

    @FindBy(xpath = "(//input[@aria-label='quantity'])[1]")
    private WebElement numberOfInstances;

    @FindBy(xpath = "(.//div[@title=\"Compute Engine\"])[1]")
    private WebElement computerEngine;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']/md-select-value")
    private WebElement operatingSystem;

    @FindBy(xpath = ".//md-option[@id=\"select_option_51\"]")
    private WebElement operatingSystemFree;

    @FindBy(xpath = ".//md-select[@id=\"select_96\"]")
    private WebElement instanceType;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement instanceTypeN1Standart8;

    @FindBy(xpath = ".//md-select[@id=\"select_65\"]")
    private WebElement classVm;

    @FindBy(xpath = ".//md-option[@id=\"select_option_63\"]")
    private WebElement classVmRegular;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addGpus;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGups;

    @FindBy(xpath = "//md-option[@ng-disabled='item.value != 0 && item.value < listingCtrl.minGPU' and @value='1']")
    private WebElement numberOfGupsOne;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']/md-select-value")
    private WebElement typeOfGups;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement typeOfGupsV100;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']//span[1]")
    private WebElement localSSD;

    @FindBy(xpath = "//md-option[@ng-repeat='item in listingCtrl.supportedSsd' and @value='2']/div[@class='md-text ng-binding']")
    private WebElement localSSD375Gb;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    private WebElement location;

    @FindBy(xpath = "(//md-option[@value='europe-west3'])[4]")
    private WebElement locationFrankfurt;

    @FindBy(xpath = "//md-select[@ng-disabled='listingCtrl.isCudDisabled']")
    private WebElement commitedUsage;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='1']")
    private WebElement commitedUsageOne;

    @FindBy(xpath = "(.//button[@aria-label=\"Add to Estimate\"])[1]")
    private WebElement addToEstimate;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement emailEstimate;

    @FindBy(xpath = ".//input[@id='fe_text']")
    private WebElement emailAddres;

    @FindBy(xpath = ".//input[@id='input_385']")
    private WebElement email;

    @FindBy(xpath = "//button[@ng-click='emailQuote.emailQuote(true); emailQuote.$mdDialog.hide()']")
    private WebElement sendEmail;

    @FindBy(xpath = ".//a[text()='Google Cloud Platform Price Estimate']")
    private WebElement openEmail;

    @FindBy(xpath = "//td//h3[text()[contains(.,'USD')]]")
    private WebElement receivedCost;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[7]/div/b")
    private WebElement actualTotalEstimatedCost;

    public HardCorePage(WebDriver driver) {
        this.driver = driver;
        int waitTime = 10;
        wait = new WebDriverWait(driver, waitTime);
        PageFactory.initElements(driver, this);
    }

    public void sendEmail(){

        emailEstimate.click();

        ((JavascriptExecutor) driver).executeScript("window.open('https://10minutemail.net/')");

        ArrayList<String> windowHadles = new ArrayList<String>(driver.getWindowHandles());
        String tabGoogle = windowHadles.get(0);
        String tabMinutemail = windowHadles.get(1);

        driver.switchTo().window(tabMinutemail);
        wait.until(ExpectedConditions.visibilityOf(emailAddres));

        String emailCopy = emailAddres.getAttribute("value");

        driver.switchTo().window(tabGoogle);

        driver.switchTo().frame("idIframe");

        wait.until(ExpectedConditions.visibilityOf(email));
        email.click();
        email.sendKeys(emailCopy);

        sendEmail.click();

        driver.switchTo().window(tabMinutemail);

        new WebDriverWait(driver, 400).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(".//a[text()=\"Google Cloud Platform Price Estimate\"]")));
        openEmail.click();

    }

    public String receivedCost() {
        return receivedCost.getText();
    }

    public String actualCost() {
        ArrayList<String> windowHadles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHadles.get(0));
        driver.switchTo().frame("idIframe");
        return actualTotalEstimatedCost.getText();
    }
}

