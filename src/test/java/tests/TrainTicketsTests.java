package tests;

import dto.PassengerCreateRequest;
import generator.PassengerDateGenerator;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import test_config.TestConfig;

public class TrainTicketsTests extends TestConfig {

    @Test
    @Description("Бронирования билета по межгороду")
    public void buyingTicketTest() {
        mainPage.loginWithValidData();
        mainPage.clickOnChooseTrainTicketButton();
        trainTicketsPage.orderingTrainTickets();
        PassengerCreateRequest randomPassenger = PassengerDateGenerator.getRandomPassenger();
        buyTicketPage.setPassengerData(randomPassenger);
        buyTicketPage.isFinalSentenceDisplayed();
    }

    @Test
    @Description("Отображения городского расписания")
    public void getTimetableTest() {
        mainPage.loginWithValidData();
        mainPage.clickOnChooseTrainTicketButton();
        trainTicketsPage.getLocalTicketsList();
        trainTicketsPage.isTimetableDisplayed();
    }
}
