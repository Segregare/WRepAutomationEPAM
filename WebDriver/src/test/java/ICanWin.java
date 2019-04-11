import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class ICanWin {

    @Test
    public void iCanWin() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");
        WebElement searchBtn = driver.findElement(By.id("header_new_paste"));
        searchBtn.click();
        WebElement searchInput = driver.findElement(By.xpath("//textarea[@name='paste_code']"));
        searchInput.sendKeys("Hello from WebDriver");
        WebElement searchDropDown = driver.findElement(By.xpath("(//span[@class='select2-selection__arrow'])[2]"));
        searchDropDown.click();
        WebElement selectDate = driver.findElement(By.xpath("(//*[@class='select2-results__option'])[1]"));
        selectDate.click();
        WebElement inputWord = driver.findElement(By.xpath("//input[@name='paste_name']"));
        inputWord.sendKeys("helloweb");

        driver.quit();
    }
}
