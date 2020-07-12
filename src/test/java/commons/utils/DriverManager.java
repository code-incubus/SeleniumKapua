package commons.utils;

import org.apache.commons.lang3.SystemUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


public abstract class DriverManager extends DriverProperties {

    @BeforeMethod
    public void initializeDriver() {
        if (SystemUtils.IS_OS_WINDOWS) {
            DriverProperties.setChromePropertyForWindows();
        } else if (SystemUtils.IS_OS_LINUX) {
            DriverProperties.setChromePropertyForLinux();
        } else if (SystemUtils.IS_OS_MAC) {
            DriverProperties.setChromePropertyForMac();
        }
    }

    @AfterMethod
    public void close() {
        if (SystemUtils.IS_OS_WINDOWS) {
            winChromeDriver.quit();
        } else if (SystemUtils.IS_OS_LINUX) {
            linuxChromeDriver.quit();
        } else if (SystemUtils.IS_OS_MAC) {
            macChromeDriver.quit();
        }
    }
}
