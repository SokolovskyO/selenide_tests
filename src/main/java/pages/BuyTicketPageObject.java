package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BuyTicketPageObject {

    protected final SelenideElement firstNameField = $x(".//input[@class='o33580 o33600 o33594 o33593']");

    protected final SelenideElement lastNameField = $x(".//input[@class='o33580 o33596 o33594 o33591 o33597']");

    protected final SelenideElement patronymicField = $x(".//input[@class='o33580 o33604 o33594 o33592 o33606']");

    protected final SelenideElement genderManButton = $x(".//button[@data-ti='gender_m']");

    protected final SelenideElement birthdayField = $x(".//input[@data-ti='birth_date']");

    protected final SelenideElement documentField = $x(".//input[@class='o33580 o33644 o33594 o33592 o33646 passenger__document__1Px8e']");

    protected final SelenideElement phoneField = $x(".//input[@autocomplete='phone']");

    protected final SelenideElement checkBox = $x("(.//input[@type='checkbox'])[3]");

    protected final SelenideElement finishRegistrationButton = $x(".//button[@class='order-group-element o33540 o33543 o33547']");

    protected final SelenideElement checkTicketsSentence = $x(".//span[contains(text(), 'Проверьте поезд')]");
}
