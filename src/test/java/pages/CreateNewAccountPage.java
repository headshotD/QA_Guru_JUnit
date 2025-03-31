package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CreateNewAccountPage {
    public static CreateNewAccountPage openNifflerPage(){
        open("https://auth.niffler.qa.guru");
        return new CreateNewAccountPage();
    }

    private final SelenideElement userName = $x("//div//input[@name='username']"),
    userPassword = $x("//div//input[@name='password']"),
    SubmitPassword = $x("//div//input[@name='passwordSubmit']"),
    submitButton = $x("//div//button[@type='submit']"),
    newAccountButton = $x("//*[@class='form__register']");

    public CreateNewAccountPage userLogIn(String value){
        userName.setValue(value);
        return this;
    }
    public CreateNewAccountPage userPassword(String value){
        userPassword.setValue(value);
        return this;
    }
    public CreateNewAccountPage submitPassword(String value){
        SubmitPassword.setValue(value);
        return this;
    }
    public void clickSubmitButton(){
        submitButton.click();
    }
    public CreateNewAccountPage clickRegistrationButton(){
        newAccountButton.click();
        return this;
    }
}

