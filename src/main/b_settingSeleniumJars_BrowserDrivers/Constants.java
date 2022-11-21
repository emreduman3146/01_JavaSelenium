package main.b_settingSeleniumJars_BrowserDrivers;

public class Constants//Sabitler
{
    //https://www.selenium.dev/downloads/
    //selenium jarlarini indirmek icin kullanigimiz site yukarda

    //java'da final olan variable'in ismi UPPERCASE ile yazilir.
    //Bu bir gelenektir. UPPERCASE ile yazilmis bir degisken ismi gorur gormez aha bu bir final degiskendir diyebilelim diye.

    final public static String CHROME_PATH="C:/Users/Emre Duman/OneDrive/Documents/seleniumDependencies/drivers/chromedriver.exe";
    final public static String CHROME="webdriver.chrome.driver";//bu satiri degistirme

    final public static String FIREFOX_PATH="C:/Users/Emre Duman/OneDrive/Documents/seleniumDependencies/drivers/geckodriver.exe";
    final public static String FIREFOX="webdriver.gecko.driver";//bu satiri degistirme

    final public static String MSEDGE_PATH="C:/Users/Emre Duman/OneDrive/Documents/seleniumDependencies/drivers/msedgedriver.exe";
    final public static String MSEDGE="webdriver.edge.driver";//bu satiri degistirme

    //NOTE
    //-> MAC kullananlar path'in sonundaki ".exe" yi silsinler
    //.exe sadece windows pc kullananlar icin
}
