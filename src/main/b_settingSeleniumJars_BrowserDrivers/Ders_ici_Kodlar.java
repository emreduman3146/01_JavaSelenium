package main.b_settingSeleniumJars_BrowserDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ders_ici_Kodlar
{

    public static void main(String[] args) throws InterruptedException {

        //ben intellij'den chrome'a gitmek istiyorum.
        //bir hedefim istegim gorevim var, bunun icin bir method olusturdum.
        navigateToGoogleChrome();
        navigateToFirefox();

        navigateToEDGE("https://www.twitter.com");
        navigateToEDGE("https://www.amazon.com");
    }

    private static void navigateToEDGE(String url)
    {
        WebDriver driver=new EdgeDriver();
        driver.get(url);
    }

    public static void navigateToFirefox()
    {
        //asagidaki 2 setter methodu ne yapti?
        //classimdaki 2 tane field'i gunelledik, deger atadik.
        //setDriverPath(Constants.FIREFOX_PATH);
        //setDriverType(Constants.FIREFOX);

        //System.setProperty(getDriverType(),getDriverPath());// bu satirda hata aldik, setleme kavramini tekrardan anlatacagim

        //polimorphism
        WebDriver driver=new FirefoxDriver();//firefox browser'i ac
        driver.get("https://www.facebook.com");//facebook'a git
    }

    //javadaki bu methoduma yapmasi gereken tum gorevcikleri yazdim, simdi bu methodu main methodundan cagirayim/calistirayim.
    private static void navigateToGoogleChrome()
    {
        //EE method var ici bos nasil gitcem?
        //Selenium Api'i benim java-selenium kodlarimi alip chrome gitsin diye ilk string parametresi yazdim
        //selenium api'i chrome gidebilmek icin driver(surucu,araba) kullanmasi gerktigi icin driver pathini belirtmem gerek
       // System.setProperty("webdriver.chrome.driver","C:/Users/Emre Duman/OneDrive/Documents/seleniumDependencies/drivers/chromedriver.exe");

        //Bir websitesine gitmek istiyorum, ChromeDriver ile gitmek istiyorum.
        //Java OOP conceplerinden -> Polimorphism var burda
        //WebDriver driver = new ChromeDriver();

        ChromeDriver driver2= new ChromeDriver();

        //GITMEK ISTEDIGIM URL'yi bana soyle, gideyim
        driver2.get("http://www.google.com");


    }


}
