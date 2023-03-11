package pages;

import com.codeborne.selenide.SelenideElement;
import config.Config;
import io.qameta.allure.Step;
import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class TrainTicketsPage extends Config {

    private final SelenideElement fromField = $x("//input[@name='city_from']");

    private final SelenideElement toField = $x("//input[@name='schedule_station_to']");

    private final SelenideElement openCalenderButton = $x("//div[contains(@class, 'search_form tab_active')]//input[@placeholder='Дата']");

    private final SelenideElement firstDate = $x("(//a[@class='ui-state-default'][text()='31'])[1]");

    private final SelenideElement secondDate = $x("(//a[@class='ui-state-default'][text()='14'])[1]");

    private final SelenideElement showTickets = $x("//span[text()='Найти ж/д билеты']//ancestor::button");

    private final SelenideElement choosePlaceButton = $x("//div[text()='Выбрать места']");

    private final SelenideElement startChoosingSeatButton = $x("(//div[@id='root']//button[contains(@class, 'order-group-element')])[1]");

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
        fromField.shouldBe(visible, Duration.ofSeconds(10));
        fromField.click();
        fromField.sendKeys("Санкт-Петербург");
        toField.click();
        toField.sendKeys("Москва");
        openCalenderButton.click();
        firstDate.click();
        showTickets.click();
        choosePlaceButton.shouldBe(visible, Duration.ofSeconds(10));
        choosePlaceButton.click();
        switchTo().window(1);
        startChoosingSeatButton.shouldBe(exist, Duration.ofSeconds(10));
        startChoosingSeatButton.click();
        toPassengersButton.shouldBe(visible, Duration.ofSeconds(10));
        toPassengersButton.click();
        continueRegistrationButton.shouldBe(visible.because("Кнопка продолжения регистрации не отображена"), Duration.ofSeconds(10));
    }

    @Step("Проверяем отображения списка городских электричек")
    public void isTimetableDisplayed() {
        localTimetable.shouldBe(visible.because("Список городских электричек не отображен"), Duration.ofSeconds(10));
    }

}
