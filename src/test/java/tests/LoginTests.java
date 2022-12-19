package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import test_config.TestConfig;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends TestConfig {

    @Test
    @Description("Логин и выход с валидными данными")
    public void loginWithValidDataTest() {
        mainPage.loginWithValidData();
        mainPage.isEmailFieldDisplayed();
        mainPage.clickOnLogoutButton();
        boolean actual = mainPage.isLoginButtonDisplayed();
        assertTrue(actual, "Кнопка входа не отобразилась после выхода");
    }

    @Test
    @Description("Логин с невалидным email")
    public void loginWithInvalidEmailTest() {
        mainPage.loginWithInvalidEmail();
        boolean actual = mainPage.isLoginErrorDisplayed();
        assertTrue(actual, "Сообщение неудавшегося логина не отобразилось");
    }

    @Test
    @Description("Логин с невалидным паролем")
    public void loginWithInvalidPasswordTest() {
        mainPage.loginWithInvalidPassword();
        boolean actual = mainPage.isLoginErrorDisplayed();
        assertTrue(actual, "Сообщение неудавшегося логина не отобразилось");
    }

    @Test
    @Description("Попытка логина без ввода email и пароля")
    public void loginWithoutEmailAndPasswordTest() {
        mainPage.loginWithoutEmailAndPassword();
        boolean actualEmptyEmail = mainPage.isEmptyEmailFieldErrorDisplayed();
        assertTrue(actualEmptyEmail, "Сообщение о незаполненном email не отобразилось");
        boolean actualEmptyPW =mainPage.isEmptyPasswordFieldErrorDisplayed();
        assertTrue(actualEmptyPW, "Сообщение о незаполненном пароле не отобразилось");
    }
}
