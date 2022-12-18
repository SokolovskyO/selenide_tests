package steps;

import io.qameta.allure.Step;
import pages.MainPageObject;
import java.time.Duration;

import static config.Config.*;
import static com.codeborne.selenide.Condition.visible;

public class MainPage extends MainPageObject {


    @Step("Логинимся с валидными данными")
    public void loginWithValidData() {
        loginButton.click();
        emailField.shouldBe(visible, Duration.ofSeconds(30));
        emailField.sendKeys(VALID_EMAIL);
        passwordField.sendKeys(VALID_PASSWORD);
        enterButton.click();
    }

    @Step("Нажатие на кнопку выхода (logout)")
    public void clickOnLogoutButton() {
        logoutButton.click();
    }

    @Step("Попытка логина с невалидным email")
    public void loginWithInvalidEmail() {
        loginButton.click();
        emailField.sendKeys(INVALID_EMAIL);
        passwordField.sendKeys(VALID_PASSWORD);
        enterButton.click();
    }

    @Step("Попытка логина с невалидным паролем")
    public void loginWithInvalidPassword() {
        loginButton.click();
        emailField.sendKeys(VALID_EMAIL);
        passwordField.sendKeys(INVALID_PASSWORD);
        enterButton.click();
    }

    @Step("Попытка логина без email и пароля")
    public void loginWithoutEmailAndPassword() {
        loginButton.click();
        enterButton.click();
    }

    @Step("Проверка отображения кнопки входа")
    public void isLoginButtonDisplayed() {
        loginButton.shouldBe(visible);
    }

    @Step("Проверяем, виден ли email залогинненого пользователя")
    public void isEmailFieldDisplayed() {
        profileButtonWithEmail.shouldBe(visible);
    }

    @Step("Проверяем отображение сообщения неудавшегося логина")
    public void isLoginErrorDisplayed() {
        negativeLoginError.shouldBe(visible);
    }

    @Step("Проверка отображения сообщения о незаполненном email")
    public void isEmptyEmailFieldErrorDisplayed() {
        emptyEmailLoginError.shouldBe(visible);
    }

    @Step("Провека отображения сообщения о незаполненном пароле")
    public void isEmptyPasswordFieldErrorDisplayed() {
        emptyPasswordLoginError.shouldBe(visible);
    }

    @Step("Нажимаем на кнопку выбора Ж/Д билетов")
    public void clickOnChooseTrainTicketButton() {
        trainTicketsButton.shouldBe(visible, Duration.ofSeconds(30));
        trainTicketsButton.click();
    }
}
