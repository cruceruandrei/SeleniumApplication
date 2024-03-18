package driver;

import enums.WebElementsText;
import logger.CustomAssert;
import logger.TestLogger;
import org.apache.logging.log4j.Level;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DriverUtils {

    private WebDriver webDriver;

    public DriverUtils(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void open(String url) {
        webDriver.get(url);
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public void click(WebElement actionElementName, WebElement elementName) {
        try {
            Actions actions = new Actions(webDriver);
            actions.moveToElement(actionElementName).build().perform();
            elementName.click();
        } catch (Exception ex) {
            TestLogger.get().log(Level.ERROR, ex.getMessage());
        }
    }

    public void click(WebElement elementName) {
        try {
            elementName.click();
        } catch (Exception ex) {
            TestLogger.get().log(Level.ERROR, ex.getMessage());
        }
    }

    public void sendKeys(WebElement webElement, String valuetoSend) {
        try {
            webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), "");
            webElement.sendKeys(valuetoSend);
        } catch (Exception ex) {
            TestLogger.get().log(Level.ERROR, ex.getMessage());
        }
    }

    public String getWebElementText(WebElement webElement) {
        try {
            return webElement.getText();
        } catch (Exception ex) {
            TestLogger.get().log(Level.ERROR, ex.getMessage());
            return null;
        }
    }

    public void registerAccountWithInvalidPassword(List<WebElement> webElementList) {
        try {
            int count = 0;
            List<WebElementsText> passwordErrorList = Arrays.stream(WebElementsText.values())
                    .filter(x -> x.name().contains("PASSWORD_"))
                    .collect(Collectors.toList());

            for (WebElement webElement : webElementList) {
                CustomAssert.assertEquals(
                        webElement.getText(),
                        passwordErrorList.get(count).getWebElementsText(),
                        "Verifies that a password error is displayed"
                );
                count++;
            }
        } catch (Exception ex) {
            TestLogger.get().log(Level.ERROR, ex.getMessage());
        }
    }

    public void registerAccountWithInvalidPasswordOneCheck(WebElement webElement, String expectedError) {
        try {
            CustomAssert.assertEquals(
                    webElement.getText(),
                    expectedError,
                    "Verifies that a password error is displayed"
            );
        } catch (Exception ex) {
            TestLogger.get().log(Level.ERROR, ex.getMessage());
        }
    }
}