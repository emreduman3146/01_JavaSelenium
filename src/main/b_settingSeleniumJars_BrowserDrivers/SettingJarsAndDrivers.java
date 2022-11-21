package main.b_settingSeleniumJars_BrowserDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static main.b_settingSeleniumJars_BrowserDrivers.Constants.*;


public class SettingJarsAndDrivers
{
    //Bu class'a asagida 3 tane field olusturuyorum. field demek class'in mali olan degisken demektir.
    public static String driverType;//String degerler default olarak null'dir
    public static String driverPath;//String degerler default olarak null'dir
    public static WebDriver driver;

    //region getters - setters
    public static String getDriverType() {
        return driverType;
    }

    public static void setDriverType(String driverType) {
        SettingJarsAndDrivers.driverType = driverType;
    }

    public static String getDriverPath() {
        return driverPath;
    }

    public static void setDriverPath(String driverPath) {
        SettingJarsAndDrivers.driverPath = driverPath;
    }
    //endregion
    public SettingJarsAndDrivers()
    {
        //default constructor ile default degerler atadik. Her Run ettigimizde bu constructor kendiliginden calisacaktir.
        driverType= CHROME;
        driverPath= Constants.CHROME_PATH;

        //mac+windows driver,jar-> https://www.youtube.com/watch?v=snf7RYEiwD0
        //mac hatasi videoda gosteriliyor sonlara dogru
        System.setProperty(driverType,driverPath);

        //System.setProperty("webdriver.chrome.verboseLogging","false");
        //selenium webdriver'in calisma mantiginda json request vardi onun detaylarini gosterir

        //System.setProperty("webdriver.chrome.logfile", "/tmp/chromedriver.log");

    }

    public static void main(String[] args) throws InterruptedException {

        navigateToGoogleChrome("https://www.google.com","Google");
        navigateToForefoxMozilla("https://www.firefox.com","Download Firefox — Fast, Private & Free — from Mozilla (CA)");
        navigateToMicrosoftEdge("https://www.youtube.com","YouTube");
    }




    public static void navigateToGoogleChrome(String url, String expectedTitle) throws InterruptedException {
        driver = new ChromeDriver();//I CREATED AN OBJECT FROM ChromeDriver CLASS if ı dont use this object a blank webpage will be opened

        goToUrl_And_verifyTheTitle(url,expectedTitle);

    }



    private static void navigateToForefoxMozilla(String url, String expectedTitle) throws InterruptedException {
        setDriverType(FIREFOX);
        setDriverPath(FIREFOX_PATH);
        driver = new FirefoxDriver();//I CREATED AN OBJECT FROM FirefoxDriver CLASS if ı dont use this object a blank webpage will be opened

        goToUrl_And_verifyTheTitle(url,expectedTitle);


    }
    private static void navigateToMicrosoftEdge(String url, String expectedTitle) throws InterruptedException {

        setDriverType(MSEDGE);
        setDriverPath(MSEDGE_PATH);
        driver = new EdgeDriver();//I CREATED AN OBJECT FROM EdgeDriver CLASS if ı dont use this object a blank webpage will be opened

        goToUrl_And_verifyTheTitle(url,expectedTitle);


    }

    private static void goToUrl_And_verifyTheTitle(String url,String expectedTitle) throws InterruptedException {
        driver.get(url);

        driver.manage().window().maximize();//sinema modu (carpı falan dahi olmaz yukarda)
        Thread.sleep(3000);

        String actualTitle=driver.getTitle();//html tag : <title> Google </title>
        //inspect  +  ctrl+F  +  //title
        //hover over web tab to see title
        System.out.println(actualTitle);

        if(actualTitle.equals(expectedTitle))//String.equals(String)
            System.out.println("pass");
        else
            System.out.println("fail"+"\n"+
                    "Actual Title:"+actualTitle+"\n"+
                    "Expected Title:"+expectedTitle);

        System.out.println(actualTitle.equals(expectedTitle) ? "Pass" : "fail"+"\n"+
                "Actual Title:"+actualTitle+"\n"+
                "Expected Title:"+expectedTitle);

        driver.close();//ı closed the page

    }
}
