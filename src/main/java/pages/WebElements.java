package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebElements {

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptDialog;

    @FindBy(css = ".m-icon.m-icon--user")
    public WebElement myAccount;

    @FindBy(className = "n-header__account-flyout__display__register__link")
    public WebElement registerAccount;

    @FindBy(id = "field_Email")
    public WebElement fieldEmail;

    @FindBy(id = "field_ConfirmEmail")
    public WebElement fieldConfirmEmail;

    @FindBy(id = "field_Password")
    public WebElement fieldPassword;

    @FindBy(css = ".color_primary.size_default.mode_block.role_next")
    public WebElement nextButton;

    @FindBy(xpath = "//button[text()=' E-Mail senden ']")
    public WebElement sendEmail;

    @FindBy(className = "error_Email")
    public WebElement errorEmail;

    @FindBy(css = ".error.error_Password")
    public WebElement errorPassword;

    @FindBy(css = ".error.error_Password")
    public List<WebElement> errorPasswordList;

    @FindBy(css = ".email-verififcation-code-step.content-block")
    public List<WebElement> emailVerification;

    @FindBy(className = "verififcation-code")
    public List<WebElement> verififcationCode;

    @FindBy(id = "field_EmailVerificationCode")
    public WebElement fieldEmailVerificationCode;

    @FindBy(id = "button_email_verification_next")
    public WebElement buttonEmailVerificationNext;

    @FindBy(className = "error_EmailVerificationCode")
    public WebElement errorEmailVerificationCode;

    @FindBy(css = ".n-header__account-flyout__display__button.n-header__account-flyout__display__button--login")
    public WebElement loginButton;

    @FindBy(id = "field_EmailOrPhone")
    public WebElement fieldEmailOrPhone;

    @FindBy(id = "button_btn_submit_email")
    public WebElement buttonSubmitEmail;

    @FindBy(css = ".password-step.content-block")
    public List<WebElement> passwordStepContentBlock;

    @FindBy(id = "button_submit")
    public WebElement buttonSubmit;

    @FindBy(className = "error_Password")
    public WebElement errorPasswordLogin;

    public WebElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}