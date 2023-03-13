package generator;

import com.github.javafaker.Faker;
import dto.PassengerCreateRequest;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Locale;

public class PassengerDateGenerator {
    // метод генерирует рандомные данные клиента через сеттеры, с помощью java faker
    public static PassengerCreateRequest getRandomPassenger() {
        Faker faker = new Faker(new Locale("ru"));
        PassengerCreateRequest passengerCreateRequest = new PassengerCreateRequest();
        passengerCreateRequest.setFirstName(faker.name().firstName());
        passengerCreateRequest.setLastName(faker.name().lastName());
        passengerCreateRequest.setPatronymic(faker.name().lastName());
        passengerCreateRequest.setDate("0" + RandomStringUtils.randomNumeric(1) + "0" + RandomStringUtils.randomNumeric(1) + "19" + RandomStringUtils.randomNumeric(2));
        passengerCreateRequest.setDocumentNumber("3416" + RandomStringUtils.randomNumeric(6));
        passengerCreateRequest.setPhone("7800" + RandomStringUtils.randomNumeric(7));
        return passengerCreateRequest;
    }
}
