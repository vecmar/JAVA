package nightmare;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static WebDriver driver;

    public static void main(String args[]){

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hornbach.sk/shop/kontakt/kontaktny-formular.html");

        driver.findElement(By.xpath("//*[@id=\"form-type-selection:selectForm\"]/option[5]")).click();
        driver.findElement(By.xpath("//*[@id=\"tab-switch-company-private\"]/div[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"companyName\"]")).sendKeys("test");
        driver.findElement(By.xpath("//*[@id=\"contact_person\"]")).sendKeys("test");

        driver.findElement(By.xpath("//*[@id=\"additionalInfo\"]")).sendKeys("test@mail.com" );

        driver.findElement(By.xpath("//*[@id=\"strasse\"]")).sendKeys("test");
        driver.findElement(By.xpath("//*[@id=\"hausnummer\"]")).sendKeys("99999");
        driver.findElement(By.xpath("//*[@id=\"plz\"]")).sendKeys("99999");
        driver.findElement(By.xpath("//*[@id=\"ort\"]")).sendKeys("test");
        driver.findElement(By.xpath("//*[@id=\"telNummer\"]")).sendKeys("9999999999");
        driver.findElement(By.xpath("//*[@id=\"texteingabe\"]")).sendKeys("test test test test");
        driver.findElement(By.xpath("//*[@id=\"auftragsnummer\"]")).sendKeys("123456789");
        driver.findElement(By.xpath("//*[@id=\"select_type_0\"]/option[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"article_0\"]")).sendKeys("454121545");
        driver.findElement(By.xpath("//*[@id=\"article_complaintReason_0\"]")).sendKeys("test");
        driver.findElement(By.xpath("//*[@id=\"stadt-suche\"]/option[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"privacyAgreement\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"submit-contact-form\"]/b")).click();
        //driver.close();
    }
}
