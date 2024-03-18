package SeleniumTestCases;

import org.testng.annotations.Test;
import pages.BaseClass;

public class Selenium_Login_Account_Wrong_Password_Three_Times extends BaseClass {

    @Test
    public void seleniumLoginAccountWrongPasswordThreeTimes() {
        scriptletsUtils.openWebPage();
        scriptletsUtils.navigateToLogin();
        scriptletsUtils.loginAccountWrongPasswordThreeTimes();
    }
}