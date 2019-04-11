import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class HardCore {
    @Test
    public void hardCore() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://cloud.google.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@href='https://cloud.google.com/products/' and @track-name='seeProducts']")).click();
        driver.findElement(By.xpath("//a[@track-name='seePricing']")).click();
        driver.findElement(By.xpath("//a[@track-name='pricingNav/calculators']")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='idIframe']")));
        driver.findElement(By.xpath("(//input[@aria-label='quantity'])[1]")).sendKeys("4");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement operationSystemDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-select[@placeholder='Instance type']/md-select-value")));
        operationSystemDropDown.click();
        WebElement elementOfInstanceType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")));
        elementOfInstanceType.click();

        driver.findElement(By.xpath("//md-checkbox[@aria-label='Add GPUs']")).click();
        driver.findElement(By.xpath("//md-select[@placeholder='Number of GPUs']")).click();

        WebElement numberOfGpus = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[@ng-disabled='item.value != 0 && item.value < listingCtrl.minGPU' and @value='1']")));
        numberOfGpus.click();

        driver.findElement(By.xpath("//md-select[@placeholder='GPU type']/md-select-value")).click();
        WebElement gpuType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[@value='NVIDIA_TESLA_V100']")));
        gpuType.click();

        driver.findElement(By.xpath("//md-select[@placeholder='Local SSD']//span[1]")).click();
        WebElement sddValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[@ng-repeat='item in listingCtrl.supportedSsd' and @value='2']/div[@class='md-text ng-binding']")));
        sddValue.click();

        driver.findElement(By.xpath("//md-select[@ng-model='listingCtrl.computeServer.location']")).click();
        WebElement datacentrLocation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//md-option[@value='europe-west3'])[4]")));
        datacentrLocation.click();

        driver.findElement(By.xpath("//md-select[@ng-disabled='listingCtrl.isCudDisabled']")).click();
        WebElement committedUsage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='1']")));
        committedUsage.click();

        driver.findElement(By.xpath("//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")).click();

        WebElement emailEstimate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Email Estimate']")));
        emailEstimate.click();

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://10minutemail.com");


        WebElement tenMinuteMailAddressElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("mailAddress")));
        String tenMinuteMailAddressString = tenMinuteMailAddressElement.getAttribute("value");

        driver.switchTo().window(tabs.get(0));

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='idIframe']")));


        WebElement googleCloudEmailForm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@ng-model='emailQuote.user.email']")));
        googleCloudEmailForm.click();
        googleCloudEmailForm.sendKeys(tenMinuteMailAddressString);


        WebElement buttonSendEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@ng-click='emailQuote.emailQuote(true); emailQuote.$mdDialog.hide()']")));
        buttonSendEmail.click();


        driver.switchTo().window(tabs.get(1));

        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.id("messagesList")));
        driver.findElement(By.id("messagesList")).click();

        WebElement priceTableData = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td//h3[text()[contains(.,'USD')]]")));
        String totalEstimatedMonthlyCost = priceTableData.getAttribute("innerText");

        driver.quit();

        assertEquals(totalEstimatedMonthlyCost, "USD 1,187.77");


    }
}