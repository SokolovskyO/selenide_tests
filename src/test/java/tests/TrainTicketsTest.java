package tests;

import dto.PassengerCreateRequest;
import generator.PassengerDateGenerator;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import test_config.TestConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrainTicketsTest extends TestConfig {

    @Test
    @Description("Бронирования билета по межгороду")
    public void buyingTicketTest() {
        mainPage.loginWithValidData();
        mainPage.clickOnChooseTrainTicketButton();
        trainTicketPage.orderingTrainTickets();
        PassengerCreateRequest randomPassenger = PassengerDateGenerator.getRandomPassenger();
        buyTicketPage.setPassengerData(randomPassenger);
        boolean actual = buyTicketPage.isFinalSentenceDisplayed();
        assertTrue(actual, "Сообщение проверьте поезд не отобразилось");
    }

    @Test
    @Description("Отображения городского расписания")
    public void getTimetableTest() {
        mainPage.loginWithValidData();
        mainPage.clickOnChooseTrainTicketButton();
        trainTicketPage.getLocalTicketsList();
        boolean actual = trainTicketPage.isTimetableDisplayed();
        assertTrue(actual, "Расписание городских электричек не отобразилось");
    }
}
