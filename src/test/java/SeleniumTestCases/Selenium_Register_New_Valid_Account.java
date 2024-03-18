package SeleniumTestCases;

import org.testng.annotations.Test;
import pages.BaseClass;

public class Selenium_Register_New_Valid_Account extends BaseClass {

    @Test
    public void seleniumRegisterNewValidAccount() {
        scriptletsUtils.openWebPage();
        scriptletsUtils.navigateToRegisterAccount();
        scriptletsUtils.registerValidAccount();
    }
}