package tests.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PozitiveLoginTest extends utilities.TestBase {

    @Test
    public void amazonPozitiveLoginTesti() throws InterruptedException {

        //Kullanıcı amazon sayfasına gider
        driver.get("https://www.amazon.com.tr");

        //cerezleri kabul et sekmesini tiklar
        WebElement cerezleriKabulEtElementi= driver.findElement(By.id("sp-cc-accept"));
        cerezleriKabulEtElementi.click();

        //mouse ı "Merhaba,Giris yapin" yazisi üzerinde tutar
        Actions actions=new Actions(driver);
        WebElement merhabaElementi= driver.findElement(By.xpath("//span[@id=\"nav-link-accountList-nav-line-1\"]"));
        actions.moveToElement(merhabaElementi).perform();
        Thread.sleep(5000);

        //"giris yap" sekmesine tiklar
        WebElement anaSayfaGirisYapElementi= driver.findElement(By.xpath("(//span[@class=\"nav-action-inner\"])[1]"));
        anaSayfaGirisYapElementi.click();

        //"E-posta adresi veya telefon numarası" bölümüne gecerli telefon numarasi girer ve "devam et" butonuna tiklar
        WebElement kullaniciAdiSekmesiElementi= driver.findElement(By.id("ap_email"));
        kullaniciAdiSekmesiElementi.sendKeys("5414542930");
        WebElement devamEtKutusuElementi=driver.findElement(By.id("continue"));
        devamEtKutusuElementi.click();

        //sifre bölümüne gecerli sifre girer "giris yap" sekmesine tiklar
        WebElement passwordKutusuElementi=driver.findElement(By.id("ap_password"));
        passwordKutusuElementi.sendKeys("15935728");
        WebElement girisYapElementi=driver.findElement(By.id("signInSubmit"));
        girisYapElementi.click();

        //basarili giris yaptigini test eder
        WebElement basariliGrisiYazisiElementi=driver.findElement(By.xpath("//div[@id='glow-ingress-block']/span[@class='nav-line-1 nav-progressive-content']"));
        Assert.assertTrue(basariliGrisiYazisiElementi.isDisplayed());

        //sayfayi kapatir.


    }
}

