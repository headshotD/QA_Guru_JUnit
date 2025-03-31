package tests;

import org.junit.jupiter.api.Test;
import utils.TestDate;

public class CreateNewAccountTests extends TestBase {

    pages.CreateNewAccountPage nifflerLogInPage = new pages.CreateNewAccountPage();
    TestDate testDate = new TestDate();
    @Test
    void authTests() {
        pages.CreateNewAccountPage.openNifflerPage()
                .clickRegistrationButton()
                .userLogIn(testDate.username)
                .userPassword(testDate.userPassword)
                .submitPassword(testDate.userPassword)
                .clickSubmitButton();
//Дописать кнопку Sign in и авторизоваться с этими тестовыми данными
    }

}
