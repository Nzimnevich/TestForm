package pages;

import com.codeborne.selenide.SelenideElement;
import utils.Constants;
import utils.User;


import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FormPopup extends BasePage {

    private static final String MAIN_ELEMENT = "#example-modal-sizes-title-lg";
    private static final String CLOSE_BTN = "#closeLargeModal";

    private static final String TITLE = "#example-modal-sizes-title-lg";
    private static final String NAME = "//td[text()='Student Name']";
    private static final String EMAIL = "//td[text()='Student Email']";
    private static final String GENDER = "//td[text()='Gender']";
    private static final String MOBILE = "//td[text()='Mobile']";
    private static final String DATA_OF_BIRTH = "//td[text()='Date of Birth']";
    private static final String SUBJECTS = "//td[text()='Subjects']";
    private static final String HOBBY = "//td[text()='Hobbies']";
    private static final String PICTURE = "//td[text()='Picture']";
    private static final String ADDRESS = "//td[text()='Address']";
    private static final String STATE_AND_CITY = "//td[text()='State and City']";
    private static final String PICTURE_JPG ="Picture cat.jpg";


    @Override
    protected SelenideElement getMainElement() {
        return $(MAIN_ELEMENT);
    }


    public void checkTitle() {
        $(TITLE).shouldBe(text(Constants.TITLE_THANKFUL_FORM));
    }


    public void checkForm(User user) {
       checkName(user.getFirstName() + " " + user.getLastName());
        checkEmail(user.getEmail());
        checkGender(user.getGender());
        checkMobile(user.getNumber());
        checkDateOfBirth(user.getDayOfBirth()+ " "+ user.getMonthOfBirth()+","+user.getYearOfBirth());
        checkSubject(user.getSubject());
        checkHobby(user.getHobby());
        checkPicture(PICTURE_JPG);
        checkAddress(user.getCurrentAddress());
        checkStateAndCity(user.getState() + " " + user.getCity());

    }


    public void checkName(String name) {
        $x(NAME).parent().shouldBe(text(name));
    }

    public void checkEmail(String email) {
        $x(EMAIL).parent().shouldBe(text(email));
    }

    public void checkGender(String gender) {
        $x(GENDER).parent().shouldBe(text(gender));
    }

    public void checkMobile(String mobile) {
        $x(MOBILE).parent().shouldBe(text(mobile));
    }

    public void checkDateOfBirth(String dateOfBirth) {
        $x(DATA_OF_BIRTH).parent().shouldBe(text(dateOfBirth));
    }

    public void checkSubject(String subject) {
        $x(SUBJECTS).parent().shouldBe(text(subject));
    }

    public void checkHobby(String hobby) {
        $x(HOBBY).parent().shouldBe(text(hobby));

    }

    public void checkPicture(String picture) {
        $x(PICTURE).parent().shouldBe(text(picture));
    }

    public void checkAddress(String address) {
        $x(ADDRESS).parent().shouldBe(text(address));
    }

    public void checkStateAndCity(String stateAndCityValue) {
        $x(STATE_AND_CITY).parent().shouldBe(text(stateAndCityValue));
    }

    public void closeForm() {
        $(CLOSE_BTN).click();
        getMainElement().shouldBe(disappear);
    }
}
