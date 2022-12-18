package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import test_config.TestConfig;

public class LoginTests extends TestConfig {

    @Test
    @Description("Логин и выход с валидными данными")
    public void loginWithValidDataTest() {
        mainPage.loginWithValidData();
        mainPage.isEmailFieldDisplayed();
        mainPage.clickOnLogoutButton();
        mainPage.isLoginButtonDisplayed();
    }

    @Test
    @Description("Логин с невалидным email")
    public void loginWithInvalidEmailTest() {
        mainPage.loginWithInvalidEmail();
        mainPage.isLoginErrorDisplayed();
    }

    @Test
    @Description("Логин с невалидным паролем")
    public void loginWithInvalidPasswordTest() {
        mainPage.loginWithInvalidPassword();
        mainPage.isLoginErrorDisplayed();
    }

    @Test
    @Description("Попытка логина без ввода email и пароля")
    public void loginWithoutEmailAndPasswordTest() {
        mainPage.loginWithoutEmailAndPassword();
        mainPage.isEmptyEmailFieldErrorDisplayed();
        mainPage.isEmptyPasswordFieldErrorDisplayed();
    }
}
