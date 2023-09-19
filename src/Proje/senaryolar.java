package Proje;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utility.BaseDriver;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class senaryolar extends BaseDriver {

    @Test
    public void US_TEC01() {

        driver.get("https://techno.study/tr");
        delay(3);

        WebElement dropDownMenu = driver.findElement(By.cssSelector("[class='t-menu__link-item t966__tm-link']"));
        dropDownMenu.click();

        List<WebElement> dropDownMenuList = driver.findElements(By.cssSelector("[class='t966__menu-list-row t966__menu-list-row_100']"));
        if (dropDownMenuList.size() == 5) {
            for (int i = 0; i < dropDownMenuList.size(); i++) {
                System.out.println((i + 1) + ". Kurs : " + dropDownMenuList.get(i).getText());
            }
        } else {
            System.out.println("Drop Down menu bulunamadı.");
        }

        WebElement veriBilimi = driver.findElement(By.xpath("//div[text()='Veri bilimi']"));
        veriBilimi.click();

        assertTrue(driver.getCurrentUrl().contains("https://techno.study/tr/data"));

        //delayQuit();
    }

    @Test
    public void US_TEC02() {

        driver.get("https://techno.study/tr");
        delay(3);

        WebElement campusLogin = driver.findElement(By.xpath("//td[text()='Campus Login']"));
        campusLogin.click();

        assertTrue(driver.getCurrentUrl().contains("https://campus.techno.study/"));

        //delayQuit();

    }

    @Test
    public void US_TEC03() {

        driver.get("https://techno.study/tr");
        delay(3);

        WebElement basvurButton = driver.findElement(By.xpath("//a[text()='BAŞVUR']"));
        basvurButton.click();

        WebElement basvurForm = driver.findElement(By.xpath("//strong[text()='Bize ulaşın!']"));
        assertTrue(basvurForm.getText().contains("Bize ulaşın!"));

        WebElement adSoyad = driver.findElement(By.cssSelector("[placeholder='Adı Soyadı']"));
        adSoyad.sendKeys("Test Techno Study");
        delay(3);

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("testTechnoStudy@techno.com");

        WebElement ulkeKodu = driver.findElement(By.cssSelector("[class='t-input-phonemask__select-flag']"));
        ulkeKodu.click();
        delay(3);

        WebElement selectAndorra = driver.findElement(By.xpath("//div[text()='Andorra']"));
        selectAndorra.click();

        WebElement phoneNumber = driver.findElement(By.cssSelector("[type='tel']"));
        phoneNumber.sendKeys("999999");
        delay(3);

        WebElement country = driver.findElement(By.id("sb-1667664755026"));
        country.click();

        Select select1 = new Select(country);
        select1.selectByValue("Andorra");

        WebElement course = driver.findElement(By.id("sb-1663337581601"));
        course.click();

        Select select2 = new Select(course);
        select2.selectByValue("SDET Türkçe");

        WebElement survey = driver.findElement(By.id("sb-1670423010572"));
        survey.click();
        delay(3);

        Select select3 = new Select(survey);
        select3.selectByValue("Youtube");

        WebElement promoCode = driver.findElement(By.cssSelector("[name='promo code']"));
        promoCode.sendKeys("Test 1234");

        WebElement checkBox = driver.findElement(By.cssSelector("[class='t-checkbox__indicator']"));
        checkBox.click();
        delay(3);

        WebElement submitButton = driver.findElement(By.cssSelector(".t-submit"));
        submitButton.click();

        WebElement successMessage = driver.findElement(By.cssSelector("svg[fill='#62C584']"));
        assertTrue(successMessage.isEnabled());

        //delayQuit();
    }

    @Test
    public void US_TEC04() {

        driver.get("https://techno.study/tr");
        delay(3);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement courseScroll = driver.findElement(By.xpath("(//*[text()='Kurslar'])[4]"));
        js.executeScript("arguments[0].scrollIntoView(true);", courseScroll);
        delay(3);

        List<WebElement> courseList = driver.findElements(By.cssSelector("[field='descr'] ul li"));
        if (courseList.size() == 4) {
            for (int i = 0; i < courseList.size(); i++) {
                System.out.println((i + 1) + ". Kurs : " + courseList.get(i).getText());
            }
        } else {
            System.out.println("List menu bulunamadı.");
        }

        WebElement sdet = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("SDET Yazılım Test Mühendisi")));
        js.executeScript("arguments[0].scrollIntoView(true);", sdet);
        delay(3);
        sdet.click();

        WebElement sdetSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Yazılım Test Mühendisi']")));
        assertTrue(sdetSuccess.isEnabled());
        delay(3);

        WebElement android = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Android uygulama geliştirme")));
        js.executeScript("arguments[0].scrollIntoView(true);", android);
        delay(3);
        android.click();

        WebElement androidSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Android uygulama geliştirme']")));
        assertTrue(androidSuccess.isEnabled());
        delay(3);

        WebElement veriBilimi = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Veri bilimi")));
        js.executeScript("arguments[0].scrollIntoView(true);", veriBilimi);
        delay(3);
        veriBilimi.click();

        WebElement veriBilimiSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Veri Bilimi Bootcamp']")));
        assertTrue(veriBilimiSuccess.isEnabled());
        delay(3);

        WebElement mastersDegree = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Master's Program")));
        js.executeScript("arguments[0].scrollIntoView(true);", mastersDegree);
        delay(3);
        mastersDegree.click();

        WebElement mastersDrageSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()=\"Master's Degree\"]")));
        assertTrue(mastersDrageSuccess.isEnabled());

        //    delayQuit();
    }

    @Test
    public void US_TEC05() {

        driver.get("https://techno.study/tr");
        delay(3);

        List<WebElement> socialMediaList = driver.findElements(By.xpath("//ul[@aria-label='Social media links']/li"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", socialMediaList.get(0));

        List<String> socialMediaSuccess = new ArrayList<>();
        Collections.addAll(socialMediaSuccess, "facebook", "instagram", "youtube", "linkedin");

        for (int i = 0; i < socialMediaList.size(); i++) {
            assertTrue(socialMediaList.get(i).getAttribute("class").contains(socialMediaSuccess.get(i)));
        }

        WebElement instagramButton = driver.findElement(By.cssSelector("[class='t-sociallinks__item t-sociallinks__item_instagram']"));
        instagramButton.click();

        Set<String> windowsHandle = driver.getWindowHandles();

        Iterator idler = windowsHandle.iterator();
        String nextId1 = idler.next().toString();
        String nextId2 = idler.next().toString();

        driver.switchTo().window(nextId2);
        delay(3);

        assertTrue(driver.getCurrentUrl().contains("https://www.instagram.com/techno.study/"));

        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_W);
        driver.switchTo().window(nextId1);

        //  delayQuit();
    }

    @Test
    public void US_TEC06() {

        driver.get("https://techno.study/tr");
        delay(3);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement homePage1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".t228__imglogo ")));
        homePage1.click();

        if (driver.getCurrentUrl().contains("https://techno.study/tr")) {
            System.out.println("Ana sayfa Doğrulama başarılı.");
        } else {
            System.out.println("Anasayfa logo https://techno.study/home sitesine yönlendirilmiştir BUG bulundu.");
        }
        System.out.println("https://techno.study/tr sayfasına gidip taska devam ediliyor");
        delay(3);

        WebElement trClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Tr'])[1]")));
        trClick.click();
        delay(3);

        WebElement sdet = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("SDET Yazılım Test Mühendisi")));
        js.executeScript("arguments[0].scrollIntoView(true);", sdet);
        delay(3);
        sdet.click();

        WebElement homePage2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".t228__imglogo ")));
        js.executeScript("arguments[0].scrollIntoView(true);", homePage2);
        delay(3);
        homePage2.click();

        if (driver.getCurrentUrl().contains("https://techno.study/tr")) {
            System.out.println("Sdet Doğrulama başarılı.");
        } else {
            System.out.println("Sdet logo https://techno.study/home sitesine yönlendirilmiştir BUG bulundu.");
        }
        System.out.println("https://techno.study/tr sayfasına gidip taska devam ediliyor");
        delay(3);
        WebElement trClick2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Tr'])[1]")));
        trClick2.click();
        delay(3);

        WebElement android = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Android Uygulama Geliştirme']")));
        js.executeScript("arguments[0].scrollIntoView(true);", android);
        delay(3);
        android.click();
        delay(3);

        WebElement homePage3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".t228__imglogo ")));
        js.executeScript("arguments[0].scrollIntoView(true);", homePage3);
        delay(3);
        homePage3.click();
        delay(3);

        if (driver.getCurrentUrl().contains("https://techno.study/tr")) {
            System.out.println("Android Doğrulama başarılı.");
        } else {
            System.out.println("Android logo https://techno.study/home sitesine yönlendirilmiştir BUG bulundu.");
        }
        System.out.println("https://techno.study/tr sayfasına gidip taska devam ediliyor");
        delay(3);

        WebElement trClick3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Tr'])[1]")));
        trClick3.click();
        delay(3);

        WebElement veriBilimi = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Veri bilimi")));
        js.executeScript("arguments[0].scrollIntoView(true);", veriBilimi);
        delay(3);
        veriBilimi.click();
        delay(3);

        WebElement homePage4 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".t228__imglogo ")));
        js.executeScript("arguments[0].scrollIntoView(true);", homePage4);
        delay(3);
        homePage4.click();
        delay(3);

        if (driver.getCurrentUrl().contains("https://techno.study/tr")) {
            System.out.println("Veri Bilimi Doğrulama başarılı.");
        } else {
            System.out.println("Veri Bilimi logo https://techno.study/home sitesine yönlendirilmiştir BUG bulundu.");
        }
        System.out.println("https://techno.study/tr sayfasına gidip taska devam ediliyor");
        delay(3);

        WebElement trClick4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Tr'])[1]")));
        trClick4.click();
        delay(3);

        WebElement mastersDegree = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Master's Program")));
        js.executeScript("arguments[0].scrollIntoView(true);", mastersDegree);
        delay(3);
        mastersDegree.click();
        delay(3);

        WebElement homePage5 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".t228__imglogo ")));
        js.executeScript("arguments[0].scrollIntoView(true);", homePage5);
        delay(3);
        homePage5.click();
        delay(3);

        if (driver.getCurrentUrl().contains("https://techno.study/tr")) {
            System.out.println("Master's Degree Doğrulama başarılı.");
        } else {
            System.out.println("Master's Degree logo https://techno.study/home sitesine yönlendirilmiştir BUG bulundu.");
        }
        System.out.println("https://techno.study/tr sayfasına gidip taska devam ediliyor");
        delay(3);

        WebElement trClick5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Tr'])[1]")));
        trClick5.click();
        delay(3);

        WebElement kullanimSartlari = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Kullanım Şartları")));
        js.executeScript("arguments[0].scrollIntoView(true);", kullanimSartlari);
        delay(3);

        kullanimSartlari.click();
        delay(3);

        WebElement homePage6 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".t228__imglogo ")));
        js.executeScript("arguments[0].scrollIntoView(true);", homePage6);
        delay(3);
        homePage6.click();
        delay(3);

        if (driver.getCurrentUrl().contains("https://techno.study/tr")) {
            System.out.println("Kullanım Şartları Doğrulama başarılı.");
        } else {
            System.out.println("Kullanım Şartları logo https://techno.study/home sitesine yönlendirilmiştir BUG bulundu.");
        }
        System.out.println("https://techno.study/tr sayfasına gidip taska devam ediliyor");
        delay(3);

        WebElement trClick6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Tr'])[1]")));
        trClick6.click();
        delay(3);

        WebElement gizlilikPolitikasi = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Gizlilik Politikası")));
        js.executeScript("arguments[0].scrollIntoView(true);", gizlilikPolitikasi);
        delay(3);
        gizlilikPolitikasi.click();
        delay(3);
        WebElement homePage7 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".t228__imglogo ")));
        js.executeScript("arguments[0].scrollIntoView(true);", homePage7);
        delay(3);
        homePage7.click();
        delay(3);

        if (driver.getCurrentUrl().contains("https://techno.study/tr")) {
            System.out.println("Gizlilik Politikası Doğrulama başarılı.");
        } else {
            System.out.println("Gizlilik Politikası logo https://techno.study/home sitesine yönlendirilmiştir BUG bulundu.");
        }
        System.out.println("https://techno.study/tr sayfasına gidip taska devam ediliyor");
        delay(3);

        WebElement trClick7 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Tr'])[1]")));
        trClick7.click();
        delay(3);

        WebElement cookiesPolitikasi = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Cookies Politikası")));
        js.executeScript("arguments[0].scrollIntoView(true);", cookiesPolitikasi);
        delay(3);
        cookiesPolitikasi.click();
        delay(3);

        WebElement homePage8 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".t228__imglogo ")));
        js.executeScript("arguments[0].scrollIntoView(true);", homePage8);
        delay(3);
        homePage8.click();
        delay(3);

        if (driver.getCurrentUrl().contains("https://techno.study/tr")) {
            System.out.println("Cookies Politikası Doğrulama başarılı.");
        } else {
            System.out.println("Cookies Politikası logo https://techno.study/home sitesine yönlendirilmiştir BUG bulundu.");
        }
        System.out.println("https://techno.study/tr sayfasına gidip taska devam ediliyor");
        delay(3);

        WebElement trClick8 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Tr'])[1]")));
        trClick8.click();
        delay(3);

        WebElement dropDownMenu = driver.findElement(By.cssSelector("[class='t-menu__link-item t966__tm-link']"));
        dropDownMenu.click();

        WebElement jobCenter = driver.findElement(By.xpath("//div[text()='Job Center & Arbeitsamt']"));
        jobCenter.click();
        delay(3);

        try {
            WebElement homePage9 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".t228__imglogo ")));
            homePage9.click();
            delay(3);
        } catch (Exception e) {
            System.out.println("Home Page Logo bulunamadı. BUG bulundu");
        }
        System.out.println("https://techno.study/tr#rec515963431 sayfasına gidip taska devam ediliyor");
        driver.get("https://techno.study/tr#rec515963431");

        WebElement homePage10 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".t228__imglogo ")));
        homePage10.click();
        delay(3);
        if (driver.getCurrentUrl().contains("https://techno.study/tr")) {
            System.out.println("Başlat Doğrulama başarılı.");
        } else {
            System.out.println("Başlat logo https://techno.study/home sitesine yönlendirilmiştir BUG bulundu.");
        }

        // delayQuit();
    }

    @Test
    public void US_TEC07() {

        driver.get("https://techno.study/tr");
        delay(3);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement sdet = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Detaylı bilgi'])[2]")));
        js.executeScript("arguments[0].scrollIntoView(false);", sdet);
        delay(3);
        sdet.click();
        delay(3);

        WebElement icerik1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Program Yapısı']")));
        js.executeScript("arguments[0].scrollIntoView(false);", icerik1);
        assertTrue(icerik1.getText().contains("Program Yapısı"));
        WebElement homePage1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".t228__imglogo ")));
        assertTrue(homePage1.isEnabled());
        WebElement trClick1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Tr'])[1]")));
        trClick1.click();

        WebElement android = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Detaylı bilgi'])[3]")));
        js.executeScript("arguments[0].scrollIntoView(false);", android);
        delay(3);
        android.click();
        delay(3);

        WebElement icerik2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//strong[text()='Eğitim İçeriği']")));
        js.executeScript("arguments[0].scrollIntoView(false);", icerik2);
        assertTrue(icerik2.getText().contains("Eğitim İçeriği"));
        WebElement homePage2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".t228__imglogo ")));
        assertTrue(homePage2.isEnabled());
        WebElement trClick2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Tr'])[1]")));
        trClick2.click();

        WebElement veriBilimi = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Detaylı bilgi'])[1]")));
        js.executeScript("arguments[0].scrollIntoView(false);", veriBilimi);
        delay(3);
        veriBilimi.click();
        delay(3);

        WebElement icerik3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[text()='Program Yapısı']")));
        js.executeScript("arguments[0].scrollIntoView(false);", icerik3);
        assertTrue(icerik3.getText().contains("Program Yapısı"));
        WebElement homePage3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".t228__imglogo ")));
        assertTrue(homePage3.isEnabled());
        WebElement trClick3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Tr'])[1]")));
        trClick3.click();

        assertTrue(driver.getCurrentUrl().contains("https://techno.study/tr"));

        // delayQuit();

    }

    @Test
    public void US_TEC08() {

        driver.get("https://techno.study/tr");
        delay(3);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement sartlar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Şartları']")));
        js.executeScript("arguments[0].scrollIntoView(true);", sartlar);
        delay(3);
        sartlar.click();

        assertFalse(!driver.getCurrentUrl().contains("https://techno.study/tr"));

        // delayQuit();

    }

    @Test
    public void US_TEC09() {

        driver.get("https://techno.study/tr");
        delay(3);

        WebElement basvur1 = driver.findElement(By.xpath("(//table[@role='presentation'])[1]"));
        assertTrue(basvur1.isEnabled());
        delay(3);
        basvur1.click();
        delay(3);

        WebElement form1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Bize ulaşın!']")));
        assertTrue(form1.isEnabled());

        WebElement dropDownMenu1 = driver.findElement(By.cssSelector("[class='t-menu__link-item t966__tm-link']"));
        dropDownMenu1.click();
        delay(3);

        WebElement sdet = driver.findElement(By.xpath("(//div[@class='t966__menu-item-title t-name'])[1]"));
        sdet.click();
        delay(3);

        WebElement basvur2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//table[@role='presentation'])[1]")));
        assertTrue(basvur2.isEnabled());
        delay(3);
        basvur2.click();
        delay(3);

        WebElement form2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Bize ulaşın!']")));
        assertTrue(form2.isEnabled());

        WebElement dropDownMenu2 = driver.findElement(By.cssSelector("[class='t-menu__link-item t966__tm-link']"));
        dropDownMenu2.click();
        delay(3);

        WebElement android = driver.findElement(By.xpath("(//div[@class='t966__menu-item-title t-name'])[2]"));
        android.click();
        delay(3);

        WebElement basvur3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//table[@role='presentation'])[1]")));
        assertTrue(basvur3.isEnabled());
        basvur3.click();
        delay(3);

        WebElement form3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Bize ulaşın!']")));
        assertTrue(form3.isEnabled());
        delay(3);

        WebElement dropDownMenu3 = driver.findElement(By.cssSelector("[class='t-menu__link-item t966__tm-link']"));
        dropDownMenu3.click();
        delay(3);

        WebElement veriBilimi = driver.findElement(By.xpath("(//div[@class='t966__menu-item-title t-name'])[3]"));
        veriBilimi.click();
        delay(3);

        WebElement basvur4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//table[@role='presentation'])[1]")));
        assertTrue(basvur4.isEnabled());
        basvur4.click();
        delay(3);

        WebElement form4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Bize ulaşın!']")));
        assertTrue(form4.isEnabled());
        delay(3);

        WebElement dropDownMenu4 = driver.findElement(By.cssSelector("[class='t-menu__link-item t966__tm-link']"));
        dropDownMenu4.click();
        delay(3);

        WebElement jobCenter = driver.findElement(By.xpath("(//div[@class='t966__menu-item-title t-name'])[4]"));
        jobCenter.click();
        delay(3);

        try {
            WebElement basvur5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//table[@role='presentation'])[1]")));
            basvur5.click();
            delay(3);
        } catch (Exception e) {
            System.out.println("Başvur button bulunamadı. BUG bulundu");
        }

        delay(3);
        WebElement form5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']")));
        assertTrue(form5.isEnabled());
        delay(3);

        driver.get("https://techno.study/tr");
        delay(3);

        WebElement dropDownMenu5 = driver.findElement(By.cssSelector("[class='t-menu__link-item t966__tm-link']"));
        dropDownMenu5.click();
        delay(3);

        WebElement mastersDegree = driver.findElement(By.xpath("(//div[@class='t966__menu-item-title t-name'])[5]"));
        mastersDegree.click();
        delay(3);

        WebElement basvur6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//table[@role='presentation'])[1]")));
        if (basvur6.getText().contains("BAŞVUR")) {
            basvur6.click();
            delay(3);
        } else {
            System.out.println("Başvur button bulunamadı. BUG bulundu yerinde farklı bir button var");
        }
        delay(3);

        WebElement form6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='We are here for you!']")));
        assertTrue(form6.isEnabled());

        delayQuit();

    }
}

