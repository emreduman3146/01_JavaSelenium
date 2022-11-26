package main.b_settingSeleniumJars_BrowserDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static main.b_settingSeleniumJars_BrowserDrivers.Constants.FIREFOX;
import static main.b_settingSeleniumJars_BrowserDrivers.Constants.FIREFOX_PATH;

public class Ders_ici_Kodlar
{

    public static void main(String[] args) throws InterruptedException {

        //ben intellij'den chrome'a gitmek istiyorum.
        //bir hedefim istegim gorevim var, bunun icin bir method olusturdum.
        //navigateToGoogleChrome();
        navigateToFirefox();

       // navigateToEDGE("https://www.twitter.com");
        //navigateToEDGE("https://www.amazon.com");
    }



    private static void navigateToEDGE(String url)
    {
        //NOVEMBER 04,2022'de Selenium 4.6.0 ile bu satiri yazmadan da browserlari launch edbiliyoruz
        //https://www.selenium.dev/blog/2022/introducing-selenium-manager/
        //resmi site aciklamasi
        System.setProperty(Constants.MSEDGE,Constants.MSEDGE_PATH);
        WebDriver driver=new EdgeDriver();
        driver.get(url);
        driver.close();
    }

    public static void navigateToFirefox()
    {

        System.out.println(FIREFOX);
        System.out.println(FIREFOX_PATH);

        //NOVEMBER 04,2022'de Selenium 4.6.0 ile bu satiri yazmadan da browserlari launch edbiliyoruz
        //Firefox browser'i launch etmek icinse bu satiri yazmamamiz gerekioyr, yoksa fail aliyoruz
        System.setProperty(FIREFOX,Constants.FIREFOX_PATH);
        // bu satirda hata aldik, cunku Syste.setProperties() kullanimi selenium'da kalkti

        //polimorphism
        WebDriver driver=new FirefoxDriver();//firefox browser'i ac
        driver.get("https://www.facebook.com");//facebook'a git
        driver.close();
    }

    //javadaki bu methoduma yapmasi gereken tum gorevcikleri yazdim, simdi bu methodu main methodundan cagirayim/calistirayim.
    private static void navigateToGoogleChrome()
    {
        //EE method var ici bos nasil gitcem?
        //Selenium Api'i benim java-selenium kodlarimi alip chrome gitsin diye ilk string parametresi yazdim
        //selenium api'i chrome gidebilmek icin driver(surucu,araba) kullanmasi gerktigi icin driver pathini belirtmem gerek
        //NOVEMBER 04,2022'de Selenium 4.6.0 ile bu satiri yazmadan da browserlari launch edbiliyoruz
        //System.setProperty("webdriver.chrome.driver","C:/Users/Emre Duman/OneDrive/Documents/seleniumDependencies/drivers/chromedriver.exe");



        //Bir websitesine gitmek istiyorum, ChromeDriver ile gitmek istiyorum.
        //Java OOP conceplerinden -> Polimorphism var burda
        //WebDriver driver = new ChromeDriver();

        ChromeDriver driver2= new ChromeDriver();

        //GITMEK ISTEDIGIM URL'yi bana soyle, gideyim
        driver2.get("http://www.google.com");
        driver2.close();


    }


}
