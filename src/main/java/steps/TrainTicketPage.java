package steps;

import io.qameta.allure.Step;
import pages.TrainTicketsOrderPage;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class TrainTicketPage extends TrainTicketsOrderPage {

    @Step("Выбор билетов")
    public void chooseTrainTickets() {
        fromField.click();
        fromField.sendKeys("Москва");
        toField.click();
        toField.sendKeys("Санкт-Петербург");
        openCalenderButton.click();
        firstDate.click();
        //   secondDate.click();
        showTickets.click();
        choosePlaceButton.shouldBe(visible, Duration.ofSeconds(30));
    }
}
