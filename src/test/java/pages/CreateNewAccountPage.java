package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class CreateNewAccountPage {

    public static CreateNewAccountPage openNifflerPage() {
        open("https://auth.niffler.qa.guru");
        return new CreateNewAccountPage();
    }

    private final SelenideElement userName = $x("//div//input[@name='username']"),
            userPassword = $x("//div//input[@name='password']"),
            SubmitPassword = $x("//div//input[@name='passwordSubmit']"),
            submitButton = $x("//div//button[@type='submit']"),
            newAccountButton = $x("//*[@class='form__register']"),
            registrationForm = $x("//div[@class='form']");

    public CreateNewAccountPage userLogIn(String value) {
        userName.setValue(value);
        return this;
    }

    public CreateNewAccountPage userPassword(String value) {
        userPassword.setValue(value);
        return this;
    }

    public CreateNewAccountPage submitPassword(String value) {
        SubmitPassword.setValue(value);
        return this;
    }

    public CreateNewAccountPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public CreateNewAccountPage clickRegistrationButton() {
        newAccountButton.click();
        return this;
    }

    public void messageRegistrationForm(String value) {
        registrationForm.should(text(value));
    }
}

