package SeleniumTestCases;

import org.testng.annotations.Test;
import pages.BaseClass;

public class Selenium_Register_New_Account_With_Invalid_Email extends BaseClass {

    @Test
    public void seleniumRegisterNewAccountWithInvalidEmail() {
        scriptletsUtils.openWebPage();
        scriptletsUtils.navigateToRegisterAccount();
        scriptletsUtils.registerAccountWithInvalidEmail();
    }
}