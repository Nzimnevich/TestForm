package test;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.FormPage;
import pages.FormPopup;
import utils.User;

public class FormTest {


    public User user = new User();


    @BeforeEach
    public void generateData() {
        Faker faker = new Faker();
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setGender("Male");
        user.setEmail(RandomStringUtils.randomAlphabetic(7).toLowerCase() + "@yandex.ru");
        user.setNumber(faker.phoneNumber().subscriberNumber(10));
        user.setSubject("English");
        user.setHobby("Sports");
        user.setCurrentAddress(faker.address().fullAddress());
        user.setState("NCR");
        user.setCity("Delhi");
        user.setDayOfBirth(String.valueOf(faker.number().numberBetween(1, 31)));
        user.setMonthOfBirth("December");
        user.setYearOfBirth(String.valueOf(faker.number().numberBetween(1983, 1997)));
    }

    @Test
    public void test(){

        FormPage formPage = new FormPage();
        formPage.openFormPage();
        formPage.checkTitle();

        formPage.setFirstName(user.getFirstName());
        formPage.setLastName(user.getLastName());
        formPage.setEmail(user.getEmail());
        formPage.setMaleGender();
        formPage.setMobileNumber(user.getNumber());
        formPage.setDateOfBirth(user.getDayOfBirth(),user.getYearOfBirth());
        formPage.setSubject(user.getSubject());
        formPage.setHobby(user.getHobby());
        formPage.setPicture();
        formPage.setCurrentAddress(user.getCurrentAddress());
        formPage.setNCRStateAndDelhiCity();
        formPage.clickSubmit();

        FormPopup formPopup = new FormPopup();
        formPopup.checkTitle();
        formPopup.checkForm(user);
        formPopup.closeForm();

    }
}
