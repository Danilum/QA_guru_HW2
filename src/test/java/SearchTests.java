import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SearchTests {

    @BeforeAll
    static void setUp(){
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browserSize = "1920x1080";
    }

    @Test
    void qr_code_creation_test() {
//      Fill the form by test data
        open("/automation-practice-form");
        $("#close-fixedban").click();
        Selenide.zoom(0.65);
        $("[id=firstName]").setValue("Daniil");
        $("[id=lastName]").setValue("Shilintsev");
        $("[id=userEmail]").setValue("Dan4ikzel99@gmail.com");
        $(byText("Male")).click();
        $("[id=userNumber]").setValue("1234567890");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__month-select").selectOption("June");
        $("[aria-label='Choose Saturday, June 12th, 1999']").click();
        $("[id = subjectsInput]").setValue("h").pressEnter();
        $("[id = subjectsInput]").setValue("e").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("[id = uploadPicture]").uploadFromClasspath("test_img.jpg");
        $("#currentAddress").setValue("Lenina Street");
        $("[id = react-select-3-input]").setValue("n").pressEnter();
        $("[id = react-select-4-input]").setValue("d").pressEnter();
        $("#submit").click();

//        AssertEqual
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Daniil Shilintsev"),
                text("Dan4ikzel99@gmail.com"),
                text("Male"),
                text("1234567890"),
                text("12 June,1999"),
                text("Hindi, " + "English"),
                text("Sports"),
                text("test_img.jpg"),
                text("Lenina Street"),
                text("NCR" + " " + "Delhi")
        );
    }
}