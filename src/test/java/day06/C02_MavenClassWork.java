package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_MavenClassWork {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //http://zero.webappsecurity.com sayfasına gidin
        driver.get("http://zero.webappsecurity.com");

        //Signin buttonuna tıklayın
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //Login alanına  “username” yazdırın
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        //Password alanına “password” yazdırın
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        //Sign in buttonuna tıklayın
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();

        //online banking kismina tiklayin
        driver.findElement(By.xpath("//strong[.='Online Banking']")).click();
        //2.yol
        //driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();

        //Pay Bills sayfasına gidin
        driver.findElement(By.id("pay_bills_link")).click();

        //Amount kısmına yatırmak istediğiniz herhangi bir miktarı yazın
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("100");

        //Date kısmına “2023-03-27” yazdırın
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2023-03-27");

        //Pay buttonuna tıklayın
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();

        //“The payment was successfully submitted.” mesajının çıktığını kontrol edin
        WebElement message=driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));
        if (message.isDisplayed())
            System.out.println("TEST PASSED");
        else
            System.out.println("TEST FAILED");

        driver.close();

    }
}
