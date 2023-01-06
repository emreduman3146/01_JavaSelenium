package main.d_seleniumBasicCommands;

import main.b_settingSeleniumJars_BrowserDrivers.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class ChromeOptionss
{
    //WebDriver'imizi declare ettikten sonra
    public static WebDriver driver;

    //initializing yapmadan once, ayarlar yapicaz
    //driver=new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {

        //varargs ozelligi sayesinde istedigim kadar deger girebilrim
        //method1("chromeMaximizedOlsun",
                //"chromeGizliSekmedeAcilsin",
                //"notificationlariKapat");

        //Chrome Browser'in ayarlarini git.
        ChromeOptions chromeOption = new ChromeOptions();

        //browser calismadan once setting yap.
        chromeOption.addArguments(
                "--start-maximized",//maximized olarak launch/baslatmak edilir
                //"--incognito",//browser gizli mode
                //"--headless",//arkaplanda calisir, browser launch edilmez
                "--disable-notifications"//bildirim almak ister misin pop-up'i

        );//ayarlarimi yaptim, parantezimi kapattim

        //bu websiteden chromeOption lari bulabilriz
        //https://peter.sh/experiments/chromium-command-line-switches/

        //to accept untrusted certificate,
        //bazen url'ye gittigimizde, guvenilir adres degildir diye uyari aliriz.
        chromeOption.setAcceptInsecureCerts(true);

        //add extension to chrome
        //Bu sitede  extension nasil indirilir basamak basamak anlatiyor
        //https://techpp.com/2022/08/22/how-to-download-and-save-chrome-extension-as-crx/
        chromeOption.addExtensions(new File("C:\\Users\\Emre Duman\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 4\\Extensions\\mcgbeeipkmelnpldkobichboakdfaeon\\2.6.7_0.crx"));


        //1-> default pop-up engellenir
        //2->controlled by chrome yazisi kaldirilir
        //setExperimentalOption bu method ile daha farkli ayarlar yapabiliriz.
        //2 ayar yapiyoruz burada
        //1.-> default olarak karsimiza cikacak pop-up'lari otomatik kapat->"disable-popup-blocking"
        //2.->chrome'da chrome automate ediliyor cumlesini gosterme->"enable-automation"
        chromeOption.setExperimentalOption("excludeSwitches", new String[]{ "disable-popup-blocking","enable-automation"});


        //driver'imi declare etmistim
        //ardindan ayarlarini yapmistim
        //simdi, driver'imi initialize ediyorum
        driver=new ChromeDriver(chromeOption);

        driver.get("https://www.google.com");
        Thread.sleep(3000);
        driver.quit();


    }

    //JAVA'DA VARARGS METHOD-PARAMETRE KONUSU
    //Ayni zamanda methodlari overloading yapiyoruz
    //Overloading method ismi ayni, parametre cesitleri farkli
    void method1(String s1)
    {
        System.out.println(s1);
    }
    void method1(String s1,String s2)
    {
        System.out.println(s1+s2);
    }
    static void method1(String s1, String s2, String s3)
    {
        System.out.println(s1+s2+s3);
    }

    //Java Static konusu
    //Static bir method, baska bir static method icinden direk cagrilabilir
    static void method1(String... s)
    {

    }

}
