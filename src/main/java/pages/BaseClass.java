package pages;

import configuration.ConfigurationData;
import driver.ObjectsManager;
import driver.enums.BrowserTypes;
import logger.TestLogger;
import org.apache.logging.log4j.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseClass extends ObjectsManager {

    protected WebDriver webDriver;

    @BeforeMethod
    public void setup() {
        try {
            System.setProperty("webdriver.chrome.driver", getFilePath(BrowserTypes.valueOf(ConfigurationData.getBrowser()).getName()));
            this.webDriver = new ChromeDriver();
            this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            this.webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            this.webDriver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
            this.webDriver.manage().window().maximize();

            init(this.webDriver);
        } catch (Exception ex) {
            TestLogger.get().log(Level.ERROR, ex.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        this.webDriver.quit();
    }

    private String getFilePath(String fileName) {
        File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
        return file.getAbsolutePath();
    }
}