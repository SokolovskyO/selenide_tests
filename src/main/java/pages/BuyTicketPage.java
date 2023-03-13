package pages;

import com.codeborne.selenide.SelenideElement;
import config.Config;
import dto.PassengerCreateRequest;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class BuyTicketPage extends Config {

    private final SelenideElement firstNameField = $x("//span[text()='Имя']//..//..//descendant::input");

    private final SelenideElement lastNameField = $x("//span[text()='Фамилия']//..//..//descendant::input");

    private final SelenideElement patronymicField = $x("//span[text()='Отчество']//..//..//descendant::input");

    private final SelenideElement genderManButton = $x("//button[@data-ti='gender_m']");

    private final SelenideElement birthdayField = $x("//input[@data-ti='birth_date']");

    private final SelenideElement documentField = $x("//input[@data-ti='doc_number']");

    private final SelenideElement phoneField = $x("//span[text()='Моб. телефон']//..//..//descendant::input");

    private final SelenideElement checkBox = $x("//span[text()='Даю']//..//..//input");

    private final SelenideElement finishRegistrationButton = $x("//button[@data-ti='next-step-button']");

    private final SelenideElement checkTicketsSentence = $x("//span[contains(text(), 'Проверьте поезд')]");

    @Step("Заполнение имени")
    public void setFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    @Step("Заполнение фамилии")
    public void setLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    @Step("Заполнение отчества")
    public void setPatronymic(String patronymic) {
        patronymicField.sendKeys(patronymic);
    }

    @Step("Заполнение дня рождения")
    public void setBirthday(String date) {
        birthdayField.click();
        birthdayField.sendKeys(date);
    }

    @Step("Заполнение серии и номера паспорта")
    public void setPassportField(String documentNumber) {
        documentField.click();
        documentField.sendKeys(documentNumber);
    }

    @Step("Заполнение номера телефона")
    public void setPhone(String phone) {
        phoneField.sendKeys(phone);
    }

    @Step("Проверяем наличие надписи проверки билета")
    public void isFinalSentenceDisplayed() {
        checkTicketsSentence.shouldBe(visible.because("Надпись о проверки билета не отображена"), Duration.ofSeconds(10));
    }

    @Step("Заполнение полей регистрации пассажира")
    public void setPassengerData(PassengerCreateRequest passengerCreateRequest) {
        setFirstName(passengerCreateRequest.getFirstName());
        setLastName(passengerCreateRequest.getLastName());
        setPatronymic(passengerCreateRequest.getPatronymic());
        setBirthday(passengerCreateRequest.getDate());
        setPassportField(passengerCreateRequest.getDocumentNumber());
        setPhone(passengerCreateRequest.getPhone());
        genderManButton.click();
        checkBox.click();
        finishRegistrationButton.click();
    }
}
