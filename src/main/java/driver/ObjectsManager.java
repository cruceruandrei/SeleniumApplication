package driver;

import org.openqa.selenium.WebDriver;
import scriptlets.ScriptletsUtils;

public class ObjectsManager {

    protected ScriptletsUtils scriptletsUtils;

    protected void init(WebDriver driver) {
        scriptletsUtils = new ScriptletsUtils(driver);
    }
}