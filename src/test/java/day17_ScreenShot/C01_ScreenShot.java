package day17_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot extends TestBase {
    @Test
    public void test() throws IOException {
        /*
            Tüm ekran görüntüsünü Selenium'dan gelen getScreenShotAs methodu ile alırız.
        Bu method selenium'daki TakesScreenshot arayüz'ünden(interface) gelir
         */
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Ekran resmini projemize kaydedelim
      //1. Adim:  olarak dosyayi nereye kaydedecegimizi belirtiriz.
        //String dosyaYolu= "screenShot.png"; //1.yol target klasoru altina atar.
        //String dosyaYoluGoster= "target/screenShot/screenShot.png";//2.yol solda target klasorunde/screenshot klasoru icine kaydeder
        String dosyaYoluGoster= "TestOutput/screenShot.png";//3. yol solda target klasorunde/TestOutput klasoru icine kaydeder
/*
            FileUtils class'ı file nesneleri ile birlikte kullanabileceğimiz methodlar içerir.
        Bu methodları kullanarak dosyalarda okuma, yazma, kopyalama ve silme işlemlerini çok daha kolay yapabiliriz
        NOT: Files.write() methodu'da aynı işlemi görür
         */


        //2. Adim : TakesScrennshot arayuzunden obje olusturacagiz
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
        //FileUtils.copyFile(takesScreenshot.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        FileUtils.copyFile(takesScreenshot.getScreenshotAs(OutputType.FILE),new File(dosyaYoluGoster));
    }

    @Test
    public void test2() throws IOException {
        driver.get("https://amazon.com");

        //Kaydettiğimiz ekran resmi her seferinde aynı dosyanın üzerine yazmaması için dosya isminden sonra bir tarih atayabiliriz
        String tarih=new SimpleDateFormat("_hh__mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu= "TestOutput/screenshot"+tarih+".png";
        TakesScreenshot ts= (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
    }
}
