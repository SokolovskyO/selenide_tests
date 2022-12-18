package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TrainTicketsOrderPage {

    protected final SelenideElement fromField = $x(".//input[@class='input_field j-station_input  j-station_input_from'][@placeholder='Откуда']");

    protected final SelenideElement toField = $x(".//input[@class='input_field j-station_input  j-station_input_to'][@placeholder='Куда']");

    protected final SelenideElement openCalenderButton = $x(".//img[@class='ui-datepicker-trigger'][@alt='Календарь']");

    protected final SelenideElement firstDate = $x("(.//a[@class='ui-state-default'][text()='31'])[1]");

    protected final SelenideElement secondDate =  $x("(.//a[@class='ui-state-default'][text()='14'])[1]");

    protected final SelenideElement showTickets = $x(".//span[@style='display: block; overflow: hidden; width: 100%; height: 100%; position: absolute; top: 0px; left: 0px;']");

    protected final SelenideElement choosePlaceButton = $x(".//div[text()='Выбрать места']");

}
