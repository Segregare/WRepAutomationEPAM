package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HurtMePlentyPage {

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

    @FindBy(xpath = "//md-option[@ng-disabled='item.value != 0 && item.value < listingCtrl.minGPU' and @value='1']")///
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
    private  WebElement location;

    @FindBy(xpath = "(//md-option[@value='europe-west3'])[4]")//////////
    private WebElement locationFrankfurt;

    @FindBy(xpath = "//md-select[@ng-disabled='listingCtrl.isCudDisabled']")
    private WebElement commitedUsage;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='1']")
    private WebElement commitedUsageOne;

    @FindBy(xpath = "(.//button[@aria-label=\"Add to Estimate\"])[1]")
    private WebElement addToEstimate;

    @FindBy(xpath = "(.//div[@class=\"md-list-item-text ng-binding\"])[2]")
    private WebElement actualClassVM;

    @FindBy(xpath = "(.//div[@class=\"md-list-item-text ng-binding\"])[3]")
    private WebElement actualInstanceType;

    @FindBy(xpath = "(.//div[@class=\"md-list-item-text ng-binding\"])[4]")
    private WebElement actualRegion;

    @FindBy(xpath = "(.//div[@class=\"md-list-item-text ng-binding\"])[5]")
    private WebElement actualSSD;

    @FindBy(xpath = "(.//div[@class=\"md-list-item-text ng-binding\"])[6]")
    private WebElement actualCommitmentTerm;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[7]/div/b")
    private WebElement actualTotalEstimatedCost;


    public HurtMePlentyPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void calculateCostOfProducts() {
        seeProducts.click();
        seePricing.click();
        calculateProducts.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='idIframe']")));
        driver.switchTo().frame("idIframe");

        numberOfInstances.click();
        numberOfInstances.sendKeys("4");
        computerEngine.click();

        wait.until(ExpectedConditions.visibilityOf(operatingSystem));
        operatingSystem.click();

        wait.until(ExpectedConditions.visibilityOf(operatingSystemFree));
        operatingSystemFree.click();
        operatingSystem.click();
        wait.until(ExpectedConditions.visibilityOf(operatingSystemFree));
        operatingSystemFree.click();

        instanceType.click();
        wait.until(ExpectedConditions.visibilityOf(instanceTypeN1Standart8));
        instanceTypeN1Standart8.click();
        instanceType.click();
        instanceTypeN1Standart8.click();
        classVm.click();
        classVmRegular.click();

        addGpus.click();
        numberOfGups.click();
        wait.until(ExpectedConditions.visibilityOf(numberOfGupsOne));
        numberOfGupsOne.click();

        typeOfGups.click();
        wait.until(ExpectedConditions.visibilityOf(typeOfGupsV100));
        typeOfGupsV100.click();
        localSSD.click();

        wait.until(ExpectedConditions.visibilityOf(localSSD375Gb));
        localSSD375Gb.click();
        localSSD.click();

        localSSD375Gb.click();
        location.click();
        wait.until(ExpectedConditions.visibilityOf(locationFrankfurt));

        locationFrankfurt.click();
        location.click();
        locationFrankfurt.click();

        commitedUsage.click();
        commitedUsageOne.click();
        addToEstimate.click();
    }

    public String getClassVW() {
        return actualClassVM.getText();
    }

    public String getInstanceType() {
        return actualInstanceType.getText();
    }

    public String getRegion() {
        return actualRegion.getText();
    }

    public String getSSD() {
        return actualSSD.getText();
    }

    public String getCommitmentTerm() {
        return actualCommitmentTerm.getText();
    }

    public String getTotalEstimatedCost() {
        return actualTotalEstimatedCost.getText();
    }

}
