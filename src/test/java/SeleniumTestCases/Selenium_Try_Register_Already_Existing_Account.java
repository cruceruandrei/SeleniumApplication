package SeleniumTestCases;

import org.testng.annotations.Test;
import pages.BaseClass;

public class Selenium_Try_Register_Already_Existing_Account extends BaseClass {

    @Test
    public void seleniumTryRegisterAlreadyExistingAccount() {
        scriptletsUtils.openWebPage();
        scriptletsUtils.navigateToRegisterAccount();
        scriptletsUtils.registerAlreadyExistingAccount();
    }
}