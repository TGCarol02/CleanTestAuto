package pages;

import auxiliar.POMBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.User;

public class LoginPage extends POMBase {
    //Login Page
    @FindBy(id = "exampleInputEmail")
    WebElement emailLoginInput;

    @FindBy(id = "exampleInputPassword")
    WebElement passwordLoginInput;

    @FindBy(xpath = "//a[contains(@class,'btn-primary')]")
    WebElement loginButton;

    @FindBy(xpath = "//a[contains(@class,'btn-google')]")
    WebElement loginGoogleButton;

    @FindBy(xpath = "//a[contains(@class,'btn-facebook')]")
    WebElement loginFacebookButton;

    @FindBy(xpath = "//a[contains(@href,'password')]")
    WebElement forgotPasswordLink;

    @FindBy(xpath = "//a[contains(@href,'register')]")
    WebElement createAccountLink;

    @FindBy(xpath = "//div[contains(@class,'login-image')]")
    WebElement loginImage;

    //Create Account
    @FindBy(id = "exampleFirstName")
    WebElement firstNameInput;

    @FindBy(id = "exampleLastName")
    WebElement lastNameInput;

    @FindBy(id = "exampleInputEmail")
    WebElement emailInput;

    @FindBy(id = "exampleInputPassword")
    WebElement passwordInput;

    @FindBy(id = "exampleRepeatPassword")
    WebElement confirmPasswordInput;

    @FindBy(xpath = "//a[contains(@class,'btn-primary')]")
    WebElement registerAccountButton;
    @FindBy(xpath = "//a[contains(@class,'btn-google')]")
    WebElement registerWithGoogleButton;

    @FindBy(xpath = "//a[contains(@class,'btn-facebook')]")
    WebElement registerWithFacebookButton;

    /**
     * Class Constructor.
     * @param driver the web driver.
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Sets the email on login page
     * @param email
     */
    public void sendEmailLogin(String email){
        sendTextToElement(emailLoginInput, email);
    }

    public boolean isLoginEmailInputVisible() { return isElementVisible(emailLoginInput); }

    /**
     * Sets the password on login page
     * @param password
     */
    public void sendPasswordLogin(String password){
        sendTextToElement(passwordLoginInput, password);
    }

    public WebElement returnLoginImage() { return loginImage; }

    public boolean isLoginPasswordInputVisible() { return isElementVisible(passwordLoginInput); }

    public void clickLoginButton(){ clickElement(loginButton); }

    public boolean isLoginButtonVisible() { return isElementVisible(loginButton); }

    /**
     * Login to application
     * @param email
     * @param password
     */
    public void login (String email, String password){
        sendTextToElement(emailLoginInput, email);
        sendTextToElement(passwordLoginInput, password);
        clickElement(loginButton);
    }

    public void createUser (User user) {
        System.out.println(user.toString());
        clickElement(createAccountLink);
        sendTextToElement(firstNameInput, user.getFirstName());
        sendTextToElement(lastNameInput, user.getLastName());
        sendTextToElement(emailInput, user.getEmail());
        sendTextToElement(passwordInput, user.getPassword());
        sendTextToElement(confirmPasswordInput, user.getPassword());
        clickElement(registerAccountButton);
    }

}
