package commons.utils;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;


public abstract class DriverManager {

    public static WebDriver driver;

    @BeforeMethod
    public void initializeDriver() {
        if (SystemUtils.IS_OS_WINDOWS) {
            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver-windows-32bit.exe");
        } else if (SystemUtils.IS_OS_LINUX) {
            System.setProperty("webdriver.linux.driver", "drivers\\chromedriver-linux-64bit");
        } else if (SystemUtils.IS_OS_MAC) {
            System.setProperty("webdriver.mac.driver", "drivers\\chromedriver-mac-64bit");
        }

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/");
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
