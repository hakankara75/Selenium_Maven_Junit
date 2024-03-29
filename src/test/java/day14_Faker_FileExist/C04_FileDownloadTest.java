package day14_Faker_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class C04_FileDownloadTest extends TestBase {
    /*
 "https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
 "b10 all test cases" dosyasını indirin
  Dosyanın başarıyla indirilip indirilmediğini test edin.
 */
    @Test
    public void test() throws InterruptedException {
// "https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

// "b10 all test cases" dosyasını indirin
        driver.findElement(By.xpath("//a[@href='../download/b10 all test cases, code.docx']")).click();
        bekle(3);

//  Dosyanın başarıyla indirilip indirilmediğini test edin.
        String userHome = System.getProperty("user.home")+"/Downloads/b10 all test cases, code.docx";
        boolean isExist= Files.exists(Paths.get(userHome));
        assertTrue(isExist);
    }
}
