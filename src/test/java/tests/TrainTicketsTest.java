package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import test_config.TestConfig;

public class TrainTicketsTest extends TestConfig {

    @Test
    @Description("Валидный выбор билетов")
    public void validOrderTicketTest() {
        mainPage.loginWithValidData();
        mainPage.clickOnChooseTrainTicketButton();
        trainTicketPage.chooseTrainTickets();
    }
}
