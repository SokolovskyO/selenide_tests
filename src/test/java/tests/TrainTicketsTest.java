package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import test_config.TestConfig;

public class TrainTicketsTest extends TestConfig {

    @Test
    @Description("Проверка отображения списка билетов")
    public void getTicketListCheck() {
        mainPage.loginWithValidData();
        mainPage.clickOnChooseTrainTicketButton();
        trainTicketPage.isTicketListDisplayed();
    }

    @Test
    @Description("Проверка возможности выбора билета")
    public void chooseTicketTest() {
        mainPage.loginWithValidData();
        mainPage.clickOnChooseTrainTicketButton();
        trainTicketPage.orderingTrainTickets();
    }

}
