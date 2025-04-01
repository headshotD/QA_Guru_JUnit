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
            textWithTheAuthorizationError = $x("//div[2]//p[@class='form__error']"),
            nameInputOnProfile = $x("//input[@id='name']"),
            valueNameOnProfile = $x("//div[2]//input[@value]"),
            saveChanges = $x("//button[@id=':r5:']");


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

    public LogInPage setNameInputInProfile(String value) {
        nameInputOnProfile.setValue(value);
        return this;
    }

    public LogInPage checkNameInputInProfile(String value) {
        nameInputOnProfile.shouldBe(text(value));
        return this;
    }
    public LogInPage checkValueInInputName(String value) {
        valueNameOnProfile.shouldBe(value(value));
        return this;
    }

    public LogInPage buttonSaveChanges() {
        saveChanges.click();
        return this;
    }

    public LogInPage checkUserNameOnProfile(String value) {
        userNameInputOnProfile.shouldHave(value(value));
        return this;
    }

    public void checkErrorText(String value) {
        textWithTheAuthorizationError.shouldHave(text(value));
    }
}

