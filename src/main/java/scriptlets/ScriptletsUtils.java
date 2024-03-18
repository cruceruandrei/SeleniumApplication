package scriptlets;

import configuration.ConfigurationData;
import driver.DriverUtils;
import enums.PagesTitle;
import enums.UsersAndPasswords;
import enums.WebElementsText;
import logger.CustomAssert;
import org.openqa.selenium.WebDriver;
import pages.WebElements;

public class ScriptletsUtils {
    private WebDriver webDriver;
    private DriverUtils driverUtils;
    private WebElements webElements;

    public ScriptletsUtils(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.driverUtils = new DriverUtils(webDriver);
        this.webElements = new WebElements(webDriver);
    }

    public void openWebPage() {
        driverUtils.open(ConfigurationData.getAddress());
        driverUtils.click(webElements.acceptDialog);
        String pageTitle = driverUtils.getPageTitle();

        CustomAssert.assertEquals(
                pageTitle,
                PagesTitle.LIDL_ONLINESHOP.getTitle(),
                "Verifies that page title is correct"
        );
    }

    public void navigateToRegisterAccount() {
        driverUtils.click(webElements.myAccount, webElements.registerAccount);
    }

    public void registerValidAccount() {
        driverUtils.click(webElements.fieldEmail);
        driverUtils.sendKeys(webElements.fieldEmail, UsersAndPasswords.VALID_EMAIL.getValue());
        driverUtils.click(webElements.fieldConfirmEmail);
        driverUtils.sendKeys(webElements.fieldConfirmEmail, UsersAndPasswords.VALID_EMAIL.getValue());
        driverUtils.click(webElements.fieldPassword);
        driverUtils.sendKeys(webElements.fieldPassword, UsersAndPasswords.VALID_PASSWORD.getValue());
        driverUtils.click(webElements.nextButton);

        CustomAssert.assertTrue(
                !webElements.emailVerification.isEmpty(),
                "Verifies that email-verififcation-code-step content-block div is present"
        );

        driverUtils.click(webElements.sendEmail);

        CustomAssert.assertTrue(
                !webElements.verififcationCode.isEmpty(),
                "Verifies that verififcation-code div is present"
        );
    }

    public void invalidVerificationCode() {
        driverUtils.click(webElements.fieldEmailVerificationCode);
        driverUtils.sendKeys(webElements.fieldEmailVerificationCode, UsersAndPasswords.INVALID_VERIFICATION_CODE.getValue());
        driverUtils.click(webElements.buttonEmailVerificationNext);

        CustomAssert.assertEquals(
                driverUtils.getWebElementText(webElements.errorEmailVerificationCode),
                WebElementsText.ERROR_INVALID_VERIFICATION_CODE.getWebElementsText(),
                "Verifies that a invalid verification code error is displayed"
        );
    }

    public void registerAlreadyExistingAccount() {
        driverUtils.click(webElements.fieldEmail);
        driverUtils.sendKeys(webElements.fieldEmail, UsersAndPasswords.ALREADY_EXISTING_EMAIL.getValue());
        driverUtils.click(webElements.fieldConfirmEmail);
        driverUtils.sendKeys(webElements.fieldConfirmEmail, UsersAndPasswords.ALREADY_EXISTING_EMAIL.getValue());
        driverUtils.click(webElements.fieldPassword);
        driverUtils.sendKeys(webElements.fieldPassword, UsersAndPasswords.VALID_PASSWORD.getValue());
        driverUtils.click(webElements.nextButton);

        CustomAssert.assertEquals(
                driverUtils.getWebElementText(webElements.errorEmail),
                WebElementsText.ALREADY_EXISTING_EMAIL.getWebElementsText(),
                "Verifies that a email error is displayed"
        );
    }

    public void registerAccountWithInvalidEmail() {
        driverUtils.click(webElements.fieldEmail);
        driverUtils.sendKeys(webElements.fieldEmail, UsersAndPasswords.INVALID_EMAIL.getValue());
        driverUtils.click(webElements.fieldConfirmEmail);
        driverUtils.sendKeys(webElements.fieldConfirmEmail, UsersAndPasswords.INVALID_EMAIL.getValue());
        driverUtils.click(webElements.fieldPassword);
        driverUtils.sendKeys(webElements.fieldPassword, UsersAndPasswords.VALID_PASSWORD.getValue());
        driverUtils.click(webElements.nextButton);

        CustomAssert.assertEquals(
                driverUtils.getWebElementText(webElements.errorEmail),
                WebElementsText.INVALID_EMAIL.getWebElementsText(),
                "Verifies that a email error is displayed"
        );
    }

    public void registerAccountWithInvalidPassword() {
        driverUtils.click(webElements.fieldEmail);
        driverUtils.sendKeys(webElements.fieldEmail, UsersAndPasswords.VALID_EMAIL.getValue());
        driverUtils.click(webElements.fieldConfirmEmail);
        driverUtils.sendKeys(webElements.fieldConfirmEmail, UsersAndPasswords.VALID_EMAIL.getValue());
        driverUtils.click(webElements.fieldPassword);
        driverUtils.sendKeys(webElements.fieldPassword, UsersAndPasswords.EMPTY_PASSWORD.getValue());
        driverUtils.click(webElements.nextButton);

        driverUtils.registerAccountWithInvalidPassword(webElements.errorPasswordList);

        driverUtils.click(webElements.fieldPassword);
        driverUtils.sendKeys(webElements.fieldPassword, UsersAndPasswords.PASSWORD_LESS_THAN_10_CHARACTERS_LONG.getValue());
        driverUtils.click(webElements.nextButton);

        driverUtils.registerAccountWithInvalidPasswordOneCheck(
                webElements.errorPassword,
                WebElementsText.PASSWORD_AT_LEAST_10_CHARACTERS_LONG.getWebElementsText()
        );

        driverUtils.click(webElements.fieldPassword);
        driverUtils.sendKeys(webElements.fieldPassword, UsersAndPasswords.PASSWORD_NO_LOWERCASE_LETTER.getValue());
        driverUtils.click(webElements.nextButton);

        driverUtils.registerAccountWithInvalidPasswordOneCheck(
                webElements.errorPassword,
                WebElementsText.PASSWORD_AT_LEAST_1_LOWERCASE_LETTER.getWebElementsText()
        );

        driverUtils.click(webElements.fieldPassword);
        driverUtils.sendKeys(webElements.fieldPassword, UsersAndPasswords.PASSWORD_NO_CAPITAL_LETTER.getValue());
        driverUtils.click(webElements.nextButton);

        driverUtils.registerAccountWithInvalidPasswordOneCheck(
                webElements.errorPassword,
                WebElementsText.PASSWORD_AT_LEAST_1_CAPITAL_LETTER.getWebElementsText()
        );

        driverUtils.click(webElements.fieldPassword);
        driverUtils.sendKeys(webElements.fieldPassword, UsersAndPasswords.PASSWORD_NO_NUMBER.getValue());
        driverUtils.click(webElements.nextButton);

        driverUtils.registerAccountWithInvalidPasswordOneCheck(
                webElements.errorPassword,
                WebElementsText.PASSWORD_AT_LEAST_1_NUMBER.getWebElementsText()
        );

        driverUtils.click(webElements.fieldPassword);
        driverUtils.sendKeys(webElements.fieldPassword, UsersAndPasswords.PASSWORD_NO_SPECIAL_CHARACTER.getValue());
        driverUtils.click(webElements.nextButton);

        driverUtils.registerAccountWithInvalidPasswordOneCheck(
                webElements.errorPassword,
                WebElementsText.PASSWORD_AT_LEAST_1_SPECIAL_CHARACTER.getWebElementsText()
        );
    }

    public void navigateToLogin() {
        driverUtils.click(webElements.myAccount, webElements.loginButton);
    }

    public void loginAccount() {
        driverUtils.click(webElements.fieldEmailOrPhone);
        driverUtils.sendKeys(webElements.fieldEmailOrPhone, UsersAndPasswords.ALREADY_EXISTING_EMAIL.getValue());
        driverUtils.click(webElements.buttonSubmitEmail);

        CustomAssert.assertTrue(
                !webElements.passwordStepContentBlock.isEmpty(),
                "Verifies that password-step content-block div is present"
        );

        driverUtils.click(webElements.fieldPassword);
        driverUtils.sendKeys(webElements.fieldPassword, UsersAndPasswords.INCORECT_PASSWORD.getValue());
        driverUtils.click(webElements.buttonSubmit);

        CustomAssert.assertEquals(
                driverUtils.getWebElementText(webElements.errorPasswordLogin),
                WebElementsText.ERROR_WRONG_PASSWORD.getWebElementsText(),
                "Verifies that a password error is displayed"
        );
    }

    public void loginAccountWrongPasswordThreeTimes() {
        driverUtils.click(webElements.fieldEmailOrPhone);
        driverUtils.sendKeys(webElements.fieldEmailOrPhone, UsersAndPasswords.ALREADY_EXISTING_EMAIL.getValue());
        driverUtils.click(webElements.buttonSubmitEmail);

        CustomAssert.assertTrue(
                !webElements.passwordStepContentBlock.isEmpty(),
                "Verifies that password-step content-block div is present"
        );

        driverUtils.click(webElements.fieldPassword);
        driverUtils.sendKeys(webElements.fieldPassword, UsersAndPasswords.INCORECT_PASSWORD.getValue());
        driverUtils.click(webElements.buttonSubmit);

        driverUtils.click(webElements.fieldPassword);
        driverUtils.sendKeys(webElements.fieldPassword, UsersAndPasswords.INCORECT_PASSWORD.getValue());
        driverUtils.click(webElements.buttonSubmit);

        driverUtils.click(webElements.fieldPassword);
        driverUtils.sendKeys(webElements.fieldPassword, UsersAndPasswords.INCORECT_PASSWORD.getValue());
        driverUtils.click(webElements.buttonSubmit);

        CustomAssert.assertEquals(
                driverUtils.getWebElementText(webElements.errorPasswordLogin),
                WebElementsText.ERROR_WRONG_PASSWORD_THREE_TIMES.getWebElementsText(),
                "Verifies that a specific password error is displayed when trying to login " +
                        "with a wrong password three times"
        );
    }
}