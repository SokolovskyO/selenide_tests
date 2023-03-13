package pages;

import com.codeborne.selenide.SelenideElement;
import config.Config;
import io.qameta.allure.Step;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class TrainTicketsPage extends Config {

    private final SelenideElement fromField = $x("//input[@placeholder='Откуда']");

    private final SelenideElement toField = $x("//input[@placeholder='Куда']");

    private final SelenideElement openCalenderButton = $x("//img[@title='Календарь']");

    private final SelenideElement firstDate = $x("(//a[@class='ui-state-default'][text()='31'])[1]");

    private final SelenideElement showTickets = $x("//span[text()='Узнать расписание ']//ancestor::button");

    private final SelenideElement choosePlaceButton = $x("//div[text()='Выбрать места']");

    private final SelenideElement startChoosingSeatButton = $x("(//div[text()='Выбрать места']//ancestor::button)[1]");

    private final SelenideElement chooseButton = $x("(//button[@data-ti='order-button']//span[text()='Выбрать'])[1]");

    private final SelenideElement toPassengersButton = $x("//div[contains(@class, 'nextStep')]//button");

    private final SelenideElement continueRegistrationButton = $x("//span[text()='Продолжить']");

    private final SelenideElement localTimetable = $x("//h1[starts-with(text(),'Расписание поездов:')]");

    @Step("Заходим в список городских электричек")
    public void getLocalTicketsList() {
        fromField.click();
        fromField.sendKeys("Москва");
        toField.click();
        toField.sendKeys("Москва");
        openCalenderButton.click();
        firstDate.click();
        showTickets.click();
    }

    @Step("Выбираем место для брони по межгороду")
    public void orderingTrainTickets() {
        fromField.shouldBe(visible, Duration.ofSeconds(15));
        fromField.sendKeys("Санкт-Петербург");
        toField.sendKeys("Москва");
        openCalenderButton.click();
        firstDate.click();
        showTickets.click();
        choosePlaceButton.shouldBe(visible, Duration.ofSeconds(15));
        choosePlaceButton.click();
        switchTo().window(1);
        chooseButton.shouldBe(visible, Duration.ofSeconds(15));
        chooseButton.click();
        toPassengersButton.click();
        continueRegistrationButton.shouldBe(visible.because("Кнопка продолжения регистрации не отображена"), Duration.ofSeconds(10));
    }

    @Step("Проверяем отображения списка городских электричек")
    public void isTimetableDisplayed() {
        localTimetable.shouldBe(visible.because("Список городских электричек не отображен"), Duration.ofSeconds(10));
    }

}
