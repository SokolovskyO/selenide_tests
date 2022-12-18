package steps;

import io.qameta.allure.Step;
import pages.TrainTicketsOrderPage;
import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;

public class TrainTicketPage extends TrainTicketsOrderPage {

    @Step("Проверка отображения списков билетов")
    public void isTicketListDisplayed() {
        fromField.click();
        fromField.sendKeys("Москва");
        toField.click();
        toField.sendKeys("Санкт-Петербург");
        openCalenderButton.click();
        firstDate.click();
        showTickets.click();
        choosePlaceButton.shouldBe(visible, Duration.ofSeconds(30));
    }

    @Step("Проверка возможности бронирования места")
    public void orderingTrainTickets() {
        fromField.click();
        fromField.sendKeys("Санкт-Петербург");
        toField.click();
        toField.sendKeys("Москва");
        openCalenderButton.click();
        firstDate.click();
        showTickets.click();
        choosePlaceButton.shouldBe(visible, Duration.ofSeconds(30));
        choosePlaceButton.click();
        switchTo().window(1);
        startChoosingSeatButton.shouldBe(exist, Duration.ofSeconds(30));
        startChoosingSeatButton.click();
        toPassengersButton.shouldBe(visible, Duration.ofSeconds(30));
        toPassengersButton.click();
        continueRegistrationButton.shouldBe(visible, Duration.ofSeconds(30));
    }

}
