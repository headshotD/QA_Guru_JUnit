package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.LogInPage;
import utils.TestBase;
import utils.TestDate;

import java.util.stream.Stream;


public class AuthenticatorInNifflerTests extends TestBase {
    TestDate testDate = new TestDate();

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

    static Stream<Arguments> checkInputNameInProfile() {
        return Stream.of(
                Arguments.of("testoleg", "testoleg"),
                Arguments.of("testigor", "testigor"),
                Arguments.of("testoleg1", "123456")
        );
    }

    @Tag("UI")
    @MethodSource("checkInputNameInProfile")
    @ParameterizedTest(name = "Проверка смена имени у юзера: {0} ")
    void checkInputNameInProfile(String login, String password) {
        LogInPage.openNifflerPage()
                .userLogIn(login)
                .userPassword(password)
                .clickSubmitButton()
                .avatarPersonClick()
                .checkUserNameOnProfile(login)
                .setNameInputInProfile(testDate.username)
                .buttonSaveChanges()
                .checkValueInInputName(testDate.username);

    }

}
