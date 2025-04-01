package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestDate {
    private final Faker faker = new Faker(new Locale("eng"));
public String
    username = faker.name().firstName(),
    userPassword = faker.name().lastName();


}
