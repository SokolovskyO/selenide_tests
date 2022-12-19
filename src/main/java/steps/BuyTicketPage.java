package steps;

import dto.PassengerCreateRequest;
import io.qameta.allure.Step;
import pages.BuyTicketPageObject;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.url;

public class BuyTicketPage extends BuyTicketPageObject {

    @Step("Заполнение имени")
    public void setFirstName(String firstName) {
        firstNameField.shouldBe(visible, Duration.ofSeconds(10));
        firstNameField.sendKeys(firstName);
    }

    @Step("Заполнение фамилии")
    public void setLastName(String lastName) {
        lastNameField.shouldBe(visible, Duration.ofSeconds(10));
        lastNameField.sendKeys(lastName);
    }

    @Step("Заполнение отчества")
    public void setPatronymic(String patronymic) {
        patronymicField.shouldBe(visible, Duration.ofSeconds(10));
        patronymicField.sendKeys(patronymic);
    }

    @Step("Заполнение дня рождения")
    public void setBirthday(String date) {
        birthdayField.shouldBe(visible, Duration.ofSeconds(10));
        birthdayField.click();
        birthdayField.sendKeys(date);
    }

    @Step("Заполнение серии и номера паспорта")
    public void setPassportField(String documentNumber) {
        documentField.shouldBe(visible, Duration.ofSeconds(10));
        documentField.click();
        documentField.sendKeys(documentNumber);
    }

    @Step("Заполнение номера телефона")
    public void setPhone(String phone) {
        phoneField.shouldBe(visible, Duration.ofSeconds(10));
        phoneField.sendKeys(phone);
    }

    @Step("Проверяем наличие надписи проверки билета")
    public boolean isFinalSentenceDisplayed() {
        checkTicketsSentence.shouldBe(visible, Duration.ofSeconds(10));
        return checkTicketsSentence.isDisplayed();
    }

    @Step("Заполнение полей регистрации пассажира")
    public void setPassengerData(PassengerCreateRequest passengerCreateRequest) {
        firstNameField.shouldBe(visible, Duration.ofSeconds(10));
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
