package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.Select;
import utils.Constants;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class FormPage extends BasePage {
    private static final String MAIN_ELEMENT = ".practice-form-wrapper";
    private static final String FIRST_NAME_FIELD = "#firstName";
    private static final String LAST_NAME_FIELD = "#lastName";
    private static final String EMAIL_FIELD = "#userEmail";
    private static final String GENDER = ".custom-control .custom-control-label";
    private static final String MOBILE_NUMBER = "input#userNumber";
    private static final String DATE_OF_BIRTH = "input#dateOfBirthInput";
    private static final String YEARS_BTN = ".react-datepicker__year-select";
    private static final String YEARS_LIST = ".react-datepicker__header  .react-datepicker__year-dropdown-container select";
    private static final String YEARS_CHOOSE = ".react-datepicker__year-select";
    private static final String MONTH_BTN ="//*[@class='react-datepicker__month-select']";
    private static final String DECEMBER_BIRTHDAY = "//*[contains(@class,'react-datepicker__day--0%s') and (contains(@aria-label,'December'))]";
    private static final String SUBJECT = "#subjectsInput";
    private static final String HOBBY = "#hobbiesWrapper";
    private static final String UPLOAD_PICTURE_BTN = "input#uploadPicture";
    private static final String CURRENT_ADDRESS = "#currentAddress";
    private static final String STATE = "#state";
    private static final String CITY = "#city";
    private static final String STATE_AND_CITY_WRAPPER = "#stateCity-wrapper";
    private static final String SUBMIT = "#submit";

    String pathFile = "src/test/resources/cat.jpg";

    @Override
    protected SelenideElement getMainElement() {
        return $(MAIN_ELEMENT);
    }

    public void checkTitle() {
        $(MAIN_ELEMENT).shouldBe(text(Constants.TITLE_FORM));
    }


    public void setFirstName(String firstName) {
        $(FIRST_NAME_FIELD).setValue(firstName);
    }

    public void setLastName(String lastName) {
        $(LAST_NAME_FIELD).setValue(lastName);
    }

    public void setEmail(String email) {
        $(EMAIL_FIELD).setValue(email);
    }

    public void setMaleGender() {
        $(GENDER).click();
    }

    public void setMobileNumber(String number) {
        $(MOBILE_NUMBER).sendKeys(number);
    }

    public void setDateOfBirth(String dateOfBirth, String year) {
        $(DATE_OF_BIRTH).click();
        $(YEARS_BTN).click();
        $(YEARS_LIST).selectOptionByValue(year);
        $(YEARS_CHOOSE).click();
        Select select = new Select($x( MONTH_BTN));
        select.selectByIndex(11);
        $x(String.format(DECEMBER_BIRTHDAY, dateOfBirth)).click();

    }

    public void setSubject(String subject) {
        $(SUBJECT).val(subject).pressEnter();
    }

    public void setHobby(String hobby) {
        $(HOBBY).$(byText(hobby)).click();
    }

    public void setPicture() {
        $(UPLOAD_PICTURE_BTN).uploadFile(new File(pathFile));
    }

    public void setCurrentAddress(String currentAddress) {
        $(CURRENT_ADDRESS).val(currentAddress).click();
    }

    public void setNCRStateAndDelhiCity() {
        setNCRState();
        setDelhiCity();
    }

    private void setNCRState() {
        $(STATE).scrollTo().click();
        $(STATE_AND_CITY_WRAPPER).$(byText("NCR")).click();
    }

    private void setDelhiCity() {
        $(CITY).click();
        $(STATE_AND_CITY_WRAPPER).$(byText("Delhi")).click();
    }

    public void clickSubmit() {
        $(SUBMIT).click();

    }


    @Override
    public String getPageUrl() {
        return "https://demoqa.com/automation-practice-form";
    }

    public void openFormPage() {
        open(getPageUrl());
    }


}
