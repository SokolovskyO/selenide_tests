package test_config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import steps.BuyTicketPage;
import steps.MainPage;
import steps.TrainTicketPage;

import static com.codeborne.selenide.Selenide.open;
import static config.Config.BASE_URI;

public abstract class TestConfig {

    @BeforeEach
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        open(BASE_URI);
    }

    @AfterEach
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    protected MainPage mainPage = new MainPage();

    protected TrainTicketPage trainTicketPage = new TrainTicketPage();

    protected BuyTicketPage buyTicketPage = new BuyTicketPage();

}
