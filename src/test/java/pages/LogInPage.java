package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LogInPage {

    public static LogInPage openNifflerPage() {
        open("https://auth.niffler.qa.guru");
        return new LogInPage();
    }

    private final SelenideElement userName = $x("//div//input[@name='username']"),
            userPassword = $x("//div//input[@name='password']"),
            submitButton = $x("//div//button[@type='submit']"),
            newAccountButton = $x("//*[@class='form__register']"),
            historyOfSpendings = $x("//main//div[@id='spendings']"),
            avatarPerson = $x("//*[@data-testid='PersonIcon']"),
            userNameInputOnProfile = $x("//div//input[@value]"),
            textWithTheAuthorizationError = $x("//div[2]//p[@class='form__error']");

    public LogInPage userLogIn(String value) {
        userName.setValue(value);
        return this;
    }

    public LogInPage userPassword(String value) {
        userPassword.setValue(value);
        return this;
    }

    public LogInPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public void clickRegistrationButton() {
        newAccountButton.click();
    }

    public LogInPage textInHistoryOfSpendings() {
        historyOfSpendings.should(text("History of Spendings"));
        return this;
    }

    public LogInPage avatarPersonClick() {
        avatarPerson.click();
        $x("//*[@class='link nav-link'][1]").click();
        return this;
    }

    public void checkUserNameOnProfile(String value) {
        userNameInputOnProfile.shouldHave(value(value));
    }

    public void checkErrorText(String value) {
        textWithTheAuthorizationError.shouldHave(text(value));
    }
}

