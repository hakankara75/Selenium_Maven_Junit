package day09_Allerts;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C02_TestBaseDemo extends TestBase {
    @Test
    public void test1(){
//Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

//Başlığın "Bootcamp" içerdiğini test edelim
String actualTitle=driver.getTitle();
String expectedTitle="Bootcamp";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }


}
