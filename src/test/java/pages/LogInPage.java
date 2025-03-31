package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LogInPage {
    public static LogInPage openNifflerPage(){
        open("https://auth.niffler.qa.guru");
        return new LogInPage();
    }

    private final SelenideElement userName = $x("//div//input[@name='username']"),
    userPassword = $x("//div//input[@name='password']"),
    submitButton = $x("//div//button[@type='submit']"),
    newAccountButton = $x("//*[@class='form__register']");

    public LogInPage userLogIn(String value){
        userName.setValue(value);
        return this;
    }
    public LogInPage userPassword(String value){
        userPassword.setValue(value);
        return this;
    }
    public void clickSubmitButton(){
        submitButton.click();
    }
    public void clickRegistrationButton(){
        newAccountButton.click();
    }
}

