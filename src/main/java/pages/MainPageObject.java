package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static config.Config.VALID_EMAIL;


public class MainPageObject {

    protected final SelenideElement loginButton = $x("//div[@class='g-link styles__unauthorized__18ak0 styles__unauthorized__157g8'][text()='Войти']");

    protected final SelenideElement emailField = $x(".//input[@placeholder='Адрес электронной почты']");

    protected final SelenideElement passwordField = $x(".//input[@placeholder='Пароль']");

    protected final SelenideElement enterButton = $x(".//button[@class='order-group-element o33131 o33136 o33138']");

    protected final SelenideElement profileButtonWithEmail = $x(".//a[@data-ti='user_name_link'][text()='"+VALID_EMAIL+"']");

    protected final SelenideElement negativeLoginError = $x(".//span[@class='styles__error__zhfb2 o3356 o3367'][text()='Превышен лимит ввода неверных логина или пароля. Повторите попытку через несколько минут.']");

    protected final SelenideElement emptyEmailLoginError = $x(".//span[text()='Без адреса электронной почты никак.']");

    protected final SelenideElement emptyPasswordLoginError = $x(".//span[text()='Без пароля никак.']");

    protected final SelenideElement logoutButton = $x("//*[name()='svg'][@viewBox='0 0 12 11']");

    protected final SelenideElement trainTicketsButton = $x(".//span[@class='styles__caption__26sCy styles__caption__LoDUe'][text()='Ж/д билеты']");

    protected final SelenideElement airTicketsButton = $x(".//span[@class='styles__caption__26sCy styles__caption__LoDUe'][text()='Авиабилеты']");

    protected final SelenideElement busTicketsButton = $x(".//span[@class='styles__caption__26sCy styles__caption__LoDUe'][text()='Автобусы']");

    protected final SelenideElement HotelsButton = $x(".//span[@class='styles__caption__26sCy styles__caption__LoDUe'][text()='Отели']");




}
