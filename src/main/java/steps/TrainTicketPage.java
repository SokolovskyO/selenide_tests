package steps;

import io.qameta.allure.Step;
import pages.TrainTicketsPageObject;
import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.switchTo;

public class TrainTicketPage extends TrainTicketsPageObject {

    @Step("Заходим в список городских электричек")
    public void getLocalTicketsList() {
        fromField.shouldBe(visible, Duration.ofSeconds(10));
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
        continueRegistrationButton.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Проверяем отображения списка городских электричек")
    public boolean isTimetableDisplayed() {
        localTimetable.shouldBe(visible, Duration.ofSeconds(10));
        return localTimetable.isDisplayed();
    }
}
