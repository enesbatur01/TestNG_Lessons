package techproed.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    private Driver() {
        /*
        POM de Driver classindan object olusturarak getDriver methodu kullanimini engellemeliyiz
        Bu nedenle singleton pattern kullanimi benimsenmistir
        Singleton Pattern : Bir classin farkli classlardan object olusturarak kullanilmasini engellemek icin kullanilir
        bu yüzden constructor i private yaptik
         */
    }
    //WebDriver tipinde bir ThreadLocal objecti olusturduk
    //Bu sayede paralel test yaparken her threadin kendi webdriver objectine sahip olmasini sagladik
    //ve böylece pralel olarak calisan farkli threadler birbirlerinin webdriverlerini etkileyemezler
    // ThreadLocal ile her thread için ayrı bir WebDriver objesi oluşturuyoruz.
    // ThreadLocal ile her thread için ayrı bir WebDriver objesi oluşturuyoruz.
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();


    public static WebDriver getDriver() {

        if (driverPool.get() == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    driverPool.set(new ChromeDriver());
                    break;
                case "edge":
                    driverPool.set(new EdgeDriver());
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    break;
                default:
                    driverPool.set(new ChromeDriver());

            }

            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driverPool.get();
    }
    /*
    Driver i her cagirdigimizda yeni bir pencere acmammasi icin bir if bloğu ile ayarlama yaptik
     if(driver==null) ile eger driver a deger atanmamis ise driver i baslat dedik, driver acik iken tekrar cagrilirsa
     driver a deger atanmis oldugu icin if block calismayacak ve dolayisiyla bu method mevcut driver i tekar return edecek
     Böylece ayni driver uzerinden test senaryolarimiza devam edebileceğiz
     */

    /*
    Page Object Model de driver icin TestBase classina extends yaparak kullanmak yerine Driver classi olusturularak bu classtan
    static method araciligi ile driver olusturup kullanmak tercih edilir
     */

    public static void closeDriver() {
        // Açık olan WebDriver örneğini kapatıyoruz.
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();// ThreadLocal'daki referansı temizliyoruz.
        }
    }

}
