package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.TestBase;
import utils.TestDate;

public class CreateNewUserOnNifflerTests extends TestBase {

    TestDate testDate = new TestDate();

    @Tag("UI")
    @DisplayName("Создание нового юзера")
    @Test
    void registrationNewUserTest() {
        pages.CreateNewAccountPage.openNifflerPage()
                .clickRegistrationButton()
                .userLogIn(testDate.username)
                .userPassword(testDate.userPassword)
                .submitPassword(testDate.userPassword)
                .clickSubmitButton()
                .messageRegistrationForm("Congratulations! You've registered!");
    }
}
