package SeleniumTestCases;

import org.testng.annotations.Test;
import pages.BaseClass;

public class Selenium_Register_New_Account_With_Invalid_Password extends BaseClass {

    @Test
    public void seleniumRegisterNewAccountWithInvalidPassword() {
        scriptletsUtils.openWebPage();
        scriptletsUtils.navigateToRegisterAccount();
        scriptletsUtils.registerAccountWithInvalidPassword();
    }
}