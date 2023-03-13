package pages;

import com.codeborne.selenide.SelenideElement;
import config.Config;
import io.qameta.allure.Step;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class MainPage extends Config {

    private final SelenideElement loginButton = $x("//div[text()='Войти']");

    private final SelenideElement emailField = $x("//input[@placeholder='Адрес электронной почты']");

    private final SelenideElement passwordField = $x("//input[@placeholder='Пароль']");

    private final SelenideElement enterButton = $x("//button[@data-ti='submit-trigger']");

    private final SelenideElement profileButtonWithEmail = $x("//a[text()='" + VALID_EMAIL + "']");

    private final SelenideElement negativeLoginError = $x("//span[starts-with( text(),'Неверный адрес почты или пароль.')]");

    private final SelenideElement emptyEmailLoginError = $x("//span[text()='Без адреса электронной почты никак.']");

    private final SelenideElement emptyPasswordLoginError = $x("//span[text()='Без пароля никак.']");

    private final SelenideElement logoutButton = $x("//div[contains(@class, 'authorized-user-info')]//div");

    private final SelenideElement trainTicketsButton = $x("//span[text()='Ж/д билеты']");

    @Step("Логинимся с валидными данными")
    public void loginWithValidData() {
        loginButton.click();
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
        loginButton.shouldBe(visible.because("Кнопка входа не отображена"), Duration.ofSeconds(10));
    }

    @Step("Проверяем видимость email залогиненного пользователя")
    public void isEmailFieldDisplayed() {
        profileButtonWithEmail.shouldBe(visible.because("Email залогиненного пользователя не отображается после входа"), Duration.ofSeconds(10));
    }

    @Step("Проверяем отображение сообщения неудавшегося логина")
    public void isLoginErrorDisplayed() {
        negativeLoginError.shouldBe(visible.because("Сообщение о неудавшемся логине не отображено"), Duration.ofSeconds(10));
    }

    @Step("Проверяем отображение сообщения о незаполненном email и пароле")
    public void isEmptyEmailAndPasswordFieldsErrorDisplayed() {
        emptyEmailLoginError.shouldBe(visible.because("Сообщение о незаполненном email не отображено"), Duration.ofSeconds(10));
        emptyPasswordLoginError.shouldBe(visible.because("Сообщение о незаполненном пароле не отображено"), Duration.ofSeconds(10));
    }

    @Step("Нажимаем на кнопку выбора Ж/Д билетов")
    public void clickOnChooseTrainTicketButton() {
        trainTicketsButton.click();
    }
}
