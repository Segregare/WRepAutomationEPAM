import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class HurtMePlenty {

    @Test
    public void hurtMePlenty() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://cloud.google.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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


        String vmClassValue = driver.findElement(By.xpath("(//div[@class='md-list-item-text ng-binding'])[2]")).getText();
        String typeInstanceValue = driver.findElement(By.xpath("(//div[@class='md-list-item-text ng-binding'])[3]")).getText();
        String regionValue = driver.findElement(By.xpath("(//div[@class='md-list-item-text ng-binding'])[4]")).getText();
        String localSddValue = driver.findElement(By.xpath("(//div[@class='md-list-item-text ng-binding'])[5]")).getText();
        String committmentTermValue = driver.findElement(By.xpath("(//div[@class='md-list-item-text ng-binding'])[6]")).getText();
        String totalEstimatedCost = driver.findElement(By.xpath("//md-list-item[@class='md-1-line md-no-proxy' and @role='listitem']/div/b")).getText();



        assertEquals(vmClassValue, "VM class: regular");
        assertEquals(typeInstanceValue, "Instance type: n1-standard-8");
        assertEquals(regionValue, "Region: Frankfurt");
        assertEquals(localSddValue, "Total available local SSD space 2x375 GB");
        assertEquals(committmentTermValue, "Commitment term: 1 Year");
        assertEquals(totalEstimatedCost, "Estimated Component Cost: USD 1,187.77 per 1 month");




    }
}
