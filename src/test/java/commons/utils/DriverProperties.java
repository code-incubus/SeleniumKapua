package commons.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class DriverProperties {

    public static WebDriver winChromeDriver, linuxChromeDriver, macChromeDriver;

    protected static void setChromePropertyForWindows() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver-windows-32bit.exe");
        winChromeDriver = new ChromeDriver();
        winChromeDriver.get("http://localhost:8080/");
        winChromeDriver.manage().window().maximize();
        winChromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected static void setChromePropertyForLinux() {
        System.setProperty("webdriver.linux.driver", "drivers\\chromedriver-linux-64bit");
        linuxChromeDriver = new ChromeDriver();
        linuxChromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        linuxChromeDriver.manage().window().maximize();
        linuxChromeDriver.get("http://localhost:8080/");
    }

    protected static void setChromePropertyForMac() {
        System.setProperty("webdriver.mac.driver", "drivers\\chromedriver-mac-64bit");
        macChromeDriver = new ChromeDriver();
        macChromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        macChromeDriver.manage().window().maximize();
        macChromeDriver.get("http://localhost:8080/");
    }
}
