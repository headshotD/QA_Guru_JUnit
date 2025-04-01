package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.LogInPage;
import utils.TestBase;


public class AuthenticatorInNifflerTests extends TestBase {

    @Tag("UI")
    @CsvSource(value = {
            "testoleg, testoleg",
            "testigor, testigor"
    })
    @ParameterizedTest(name = "Авторизация под юзером {0}")
    @DisplayName("Проверка авторизации")
    void authWithNewUserTest(String credentials) {
        LogInPage.openNifflerPage()
                .userLogIn(credentials)
                .userPassword(credentials)
                .clickSubmitButton()
                .avatarPersonClick()
                .checkUserNameOnProfile(credentials);
    }

    @Tag("UI")
    @ValueSource(strings = {"fakeUser", "ErrorUser"})
    @ParameterizedTest(name = "Авторизация под несуществующим юзером {0}")
    @DisplayName("Проверка авторизации под несуществующим юзером")
    void authWithFakeUserTest(String credentials) {
        LogInPage.openNifflerPage()
                .userLogIn(credentials)
                .userPassword(credentials)
                .clickSubmitButton()
                .checkErrorText("Неверные учетные данные пользователя");
    }

}
