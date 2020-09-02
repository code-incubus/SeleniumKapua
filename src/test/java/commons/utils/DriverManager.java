package commons.utils;

import org.apache.commons.lang3.SystemUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Abstract class used for handling driver properties...
 * @author code-incubus
 */
public abstract class DriverManager {

    /**
     * The static driver of this {@link DriverManager}.
     */
    public static WebDriver driver;

    /**
     * The {@link #initializeDriver()} of this {@link DriverManager}.
     * which is used to adjust the driver depending on the OS before each test execution
     * @see <a href="https://github.com/webdriverextensions/webdriverextensions-maven-plugin</a>
     */
    @Before
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

    /**
     * The {@link #close()} ()} of this {@link DriverManager}.
     * which is used to quit driver after each test execution
     */
    @After
    public void close() {
        driver.quit();
    }
}
