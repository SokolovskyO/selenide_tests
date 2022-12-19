package steps;

import io.qameta.allure.Step;
import pages.MainPageObject;
import java.time.Duration;

import static config.Config.*;
import static com.codeborne.selenide.Condition.visible;

public class MainPage extends MainPageObject {


    @Step("Логинимся с валидными данными")
    public void loginWithValidData() {
        loginButton.shouldBe(visible, Duration.ofSeconds(10));
        loginButton.click();
        emailField.shouldBe(visible, Duration.ofSeconds(10));
        emailField.sendKeys(VALID_EMAIL);
        passwordField.sendKeys(VALID_PASSWORD);
        enterButton.click();
    }

    @Step("Нажатие на кнопку выхода (logout)")
    public void clickOnLogoutButton() {
        logoutButton.shouldBe(visible, Duration.ofSeconds(10));
        logoutButton.click();
    }

    @Step("Попытка логина с невалидным email")
    public void loginWithInvalidEmail() {
        loginButton.shouldBe(visible, Duration.ofSeconds(10));
        loginButton.click();
        emailField.sendKeys(INVALID_EMAIL);
        passwordField.sendKeys(VALID_PASSWORD);
        enterButton.click();
    }

    @Step("Попытка логина с невалидным паролем")
    public void loginWithInvalidPassword() {
        loginButton.shouldBe(visible, Duration.ofSeconds(10));
        loginButton.click();
        emailField.sendKeys(VALID_EMAIL);
        passwordField.sendKeys(INVALID_PASSWORD);
        enterButton.click();
    }

    @Step("Попытка логина без email и пароля")
    public void loginWithoutEmailAndPassword() {
        loginButton.shouldBe(visible, Duration.ofSeconds(10));
        loginButton.click();
        enterButton.click();
    }

    @Step("Проверка отображения кнопки входа")
    public boolean isLoginButtonDisplayed() {
        loginButton.shouldBe(visible,Duration.ofSeconds(10));
        return loginButton.isDisplayed();
    }

    @Step("Проверяем, виден ли email залогинненого пользователя")
    public void isEmailFieldDisplayed() {
        profileButtonWithEmail.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Проверяем отображение сообщения неудавшегося логина")
    public boolean isLoginErrorDisplayed() {
        negativeLoginError.shouldBe(visible, Duration.ofSeconds(10));
        return negativeLoginError.isDisplayed();
    }

    @Step("Проверяем отображение сообщения о незаполненном email")
    public boolean isEmptyEmailFieldErrorDisplayed() {
        emptyEmailLoginError.shouldBe(visible, Duration.ofSeconds(10));
        return emptyEmailLoginError.isDisplayed();
    }

    @Step("Провеояем отображение сообщения о незаполненном пароле")
    public boolean isEmptyPasswordFieldErrorDisplayed() {
        emptyPasswordLoginError.shouldBe(visible, Duration.ofSeconds(10));
        return emptyPasswordLoginError.isDisplayed();
    }

    @Step("Нажимаем на кнопку выбора Ж/Д билетов")
    public void clickOnChooseTrainTicketButton() {
        trainTicketsButton.shouldBe(visible, Duration.ofSeconds(10));
        trainTicketsButton.click();
    }
}
