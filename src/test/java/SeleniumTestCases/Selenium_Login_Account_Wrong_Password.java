package SeleniumTestCases;

import org.testng.annotations.Test;
import pages.BaseClass;

public class Selenium_Login_Account_Wrong_Password extends BaseClass {

    @Test
    public void seleniumRegisterNewValidAccountWrongPassword() {
        scriptletsUtils.openWebPage();
        scriptletsUtils.navigateToLogin();
        scriptletsUtils.loginAccount();
    }
}