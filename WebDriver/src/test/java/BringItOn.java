import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;


public class BringItOn {

    @Test
    public void bringItOn() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");
        WebElement searchNewPaste = driver.findElement(By.id("header_new_paste"));
        searchNewPaste.click();
        WebElement searchInput = driver.findElement(By.xpath("//textarea[@name='paste_code']"));
        String code = "git config --global user.name  \"New Sheriff in Town\"\ngit reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\ngit push origin master --force";
        searchInput.sendKeys(code);
        WebElement dropSyntax = driver.findElement(By.xpath("(//span[@class='select2-selection__arrow'])[1]"));
        dropSyntax.click();
        WebElement selectSyntax = driver.findElement(By.xpath("(//*[@class='select2-results__option'])[2]"));
        selectSyntax.click();
        WebElement dropDate = driver.findElement(By.xpath("(//span[@class='select2-selection__arrow'])[2]"));
        dropDate.click();
        WebElement selectDate = driver.findElement(By.xpath("(//*[@class='select2-results__option'])[1]"));
        selectDate.click();
        WebElement inputWord = driver.findElement(By.xpath("//input[@name='paste_name']"));
        inputWord.sendKeys("how to gain dominance among developers");
        WebElement saveNewPaste = driver.findElement(By.xpath("//*[@value='Create New Paste']"));
        saveNewPaste.click();

        if(driver.getTitle().contains("how to gain dominance among developers")) {
            System.out.println("Заголовок страницы браузера соответствует Paste Name / Title: \"how to gain dominance among developers\" ");
        }
        else
            System.out.println("Не соответствие заголовка: \"how to gain dominance among developers\" ");

        String syntaxColor = driver.findElement(By.xpath("//*[@class='kw2']")).getCssValue("color");
        String hex = Color.fromString(syntaxColor).asHex();
        System.out.println("Цвет подсветки синтаксиса Bash: " + hex) ;

        String syntaxText = driver.findElement(By.xpath("//*[@id='selectable']/ol")).getText();
        boolean checkCode;
        checkCode = code.equals(syntaxText);
        System.out.println("Код соответствует введенному в пункте 2? Ответ: " + checkCode);

        driver.quit();

    }
}
