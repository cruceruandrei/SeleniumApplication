package SeleniumTestCases;

import org.testng.annotations.Test;
import pages.BaseClass;

public class Selenium_Register_New_Valid_Account_Invalid_Verification_Code extends BaseClass {

    @Test
    public void seleniumRegisterNewValidAccountInvalidVerificationCode() {
        scriptletsUtils.openWebPage();
        scriptletsUtils.navigateToRegisterAccount();
        scriptletsUtils.registerValidAccount();
        scriptletsUtils.invalidVerificationCode();
    }
}