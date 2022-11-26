package main.d_seleniumBasicCommands;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class BrowserCommand
{
    //chrome session olusturur. Bos bir chrome sayfasi acilir.
    //new ChromeDriver(); constructor methodu ayni anda chromedriver.exe 'yi kutuphanesinde barindirir ve calistirir.
    //JSON Dilinde nasil calistigini da gorduk
    //driver mor renktedir, cunku her methodtan erisilebilir.
    public static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException, MalformedURLException
    {
        //kirmizi yakan satira mouse ile gelin method create secenegine tiklayin ki method olussun
        //basicDriverMethods();

        //mouse ile method'un ustune gel, sol click yap
        //driverNavigateMethods();


        //driverManageWindowMethods();

         tearDownMethods();
    }

    private static void tearDownMethods() {

        //browserdaki tab'i kapatir
        //sadece 1 tab aciksa o tab'i kapatmak demek browser'in tamamen kapanmasina yol acar
        //driver.close();


        //browserda birden fazla tab aciksa, pop-up da dahil hepsini komple kapatmaya yarar
        driver.quit();// - Calls Dispose()

    }

    private static void basicDriverMethods() {
        //parametre olarak verilen String ifadeyi oku, o websitesini chrome'da ac
        //Json dilindeki karsiligi-> http://localhost:9515/session  (postman'de yapmistik)
        driver.get("https://www.google.com");//mouse ile uzerine gel, ctrl tikla, pop-up cikacak

        //Return type'i String, yani bu method string bir deger dondururur.
        //Acilan Tab'in ustunde yazan ifadeyi return eder.
        String pageTitle=driver.getTitle();//Google
        System.out.println("pageTitle = " + pageTitle);

        //retrun type:String
        //acik olan tab'in url adresini getirir
        String urlAdresi=driver.getCurrentUrl();//https://www.google.com/
        System.out.println("urlAdresi = " + urlAdresi);


        //Return type:String
        //Webte acilan sayfanin kodlarini yazdirir.
        //driver objesi WebDriver isimli interface'in objesidir.
        //driver. dedigim an WebDriver Interface'indeki tum method/variablelara erisebilirim
        String pageSource=driver.getPageSource();
        System.out.println("pageSource = " + pageSource);

    }

    private static void driverNavigateMethods() throws MalformedURLException, InterruptedException {


        //driver.get("https://www.amazon.com"); 'den farki
        // ileri git,  geri git, sayfayi refresh et(yenile)
        // gibi emirler verebilmemizi saglar
        driver.navigate().to("https://www.amazon.com");

        URL udemyUrl= new URL("https://www.udemy.com");
        driver.navigate().to(udemyUrl);

        //geri gitmek icin
        driver.navigate().back();//amazon'a geri donecek

        Thread.sleep(3000);//3 saniye intellije'deki kodlariimi beklet
        //Bu emir kendi isletim sistemimi 3 saniye bekletir
        //bunu kullanma sebebimizi, olur da chrome yavas calisir bizim satir satir yazdigimiz
        // kodlara/emirlere yetisemezse diye

        //ileriye gitmek icin
        driver.navigate().forward();//udemy'e ileri gidecek

        Thread.sleep(2000);
        //bulundugumuz page'i refresh yapar
        driver.navigate().refresh();








/*

        driver.navigate().to("https://www.amazon.com");//parametresi String

        URL seleniumURL=new URL("https://www.selenium.dev/");
        driver.navigate().to(seleniumURL);//Parametresi URL classina ait bir object olmali

        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();
*/
    }

    private static void driverManageWindowMethods() {

        //Asagidaki methodlarin aciklamasi bu documentation'da ->
        //https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.Window.html
        driver.get("https://www.google.com");
        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());

        //page'i maximize yap
        driver.manage().window().maximize();
        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());

        //page'imizi minimize deriz. bu methodun icinde default bir deger gore
        driver.manage().window().minimize();
        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());


        //Browser size'ini istedigimiz gibi ayarlamak icin
        Dimension ozelOlculer= new Dimension(600,400);
        //ozelOlculer isimli Dimension Class'inin objesi(nesnesi) icinde 500,500 koordinatlarini tutuyor

        driver.manage().window().setSize(ozelOlculer);
        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());


        Point solUstKoseKoordinatlari= driver.manage().window().getPosition();
        System.out.println("solUstKoseKoordinatlari = " + solUstKoseKoordinatlari);

        //500 horizantal - yatay
        //200 vertical - dikey
        Point IstedigimSolUstKoseKoordinatlari= new Point(500,200);
        driver.manage().window().setPosition(IstedigimSolUstKoseKoordinatlari);

        solUstKoseKoordinatlari= driver.manage().window().getPosition();
        System.out.println("solUstKoseKoordinatlari = " + solUstKoseKoordinatlari);


        //cinema mode
        driver.manage().window().fullscreen();
    }


}
