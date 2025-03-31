package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;

public class SimpleTest {
@ValueSource(strings = {"One",
        "Two"
})
@CsvSource(value = {"One, Link", "TWO, LINK"})
    @ParameterizedTest(name = "NAME {0}")
//@Disabled("Lol")
    //@Test
@Tag("Web")
    //@DisplayName("Первый простой тест")
    void simpleTest(String another){
        open("https://www.ya.ru");


    }
}
