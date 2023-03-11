package test_config;

import com.codeborne.selenide.Configuration;
import config.Config;
import org.junit.jupiter.api.BeforeEach;
import pages.BuyTicketPage;
import pages.MainPage;
import pages.TrainTicketsPage;

import static com.codeborne.selenide.Selenide.open;

public abstract class TestConfig extends Config {

    @BeforeEach
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.startMaximized = true;
        open(BASE_URI);
    }

    protected MainPage mainPage = new MainPage();

    protected TrainTicketsPage trainTicketsPage = new TrainTicketsPage();

    protected BuyTicketPage buyTicketPage = new BuyTicketPage();
}
