import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestsForm {

    String titleForm="Student Registration Form";
    String titleThankfulForm ="Thanks for submitting the form";

    String name = "Nika";
    String lastName = "Zima";
    String email = "zgdgdg@yandex.ru";
    String phone = "1234567891";
    String currentAddress = "Privet drive 1";
    String year ="1989";
    String subject ="English";
    String hobby="Sports";
    String pathFile="src/test/resources/cat.jpg";
    String state = "NCR";
    String city = "Delhi";

    @Test
    void selenideSearchTest(){
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldBe(text(titleForm));

        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(".custom-control .custom-control-label").click();
        $("input#userNumber").setValue(phone);
        $("input#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__header  .react-datepicker__year-dropdown-container select").selectOptionByValue(year);
        $(".react-datepicker__year-select").click();
        Select select = new Select($x("//*[@class='react-datepicker__month-select']"));
        select.selectByIndex(11);
        $x("//*[contains(@class,'react-datepicker__day--001') and (contains(@aria-label,'December'))]").click();


        $("#subjectsInput").val(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("input#uploadPicture").uploadFile(new File(pathFile));
        $("#currentAddress").val(currentAddress).click();
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldBe(text(titleThankfulForm));

        //check a form
        $x("//td[text()='Student Name']").parent().shouldBe(text(name + " "+ lastName));
        $x("//td[text()='Student Email']").parent().shouldBe(text(email));
        $x("//td[text()='Gender']").parent().shouldBe(text("Male"));
        $x("//td[text()='Mobile']").parent().shouldBe(text(phone));
        $x("//td[text()='Date of Birth']").parent().shouldBe(text("01 December," + year));
        $x("//td[text()='Subjects']").parent().shouldBe(text(subject));
        $x("//td[text()='Hobbies']").parent().shouldBe(text(hobby));
        $x("//td[text()='Picture']").parent().shouldBe(text("Picture cat.jpg"));
        $x("//td[text()='Address']").parent().shouldBe(text(currentAddress));
        $x("//td[text()='State and City']").parent().shouldBe(text(state + " " + city));
        
        $("#closeLargeModal").click();
        $("#example-modal-sizes-title-lg").shouldBe(disappear);


    }
}
