package config;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;

import io.restassured.specification.RequestSpecification;

import static config.BaseConfig.BASE_URL;

public class ApiConfig  {

    private static final ThreadLocal<RequestSpecification> spec = new ThreadLocal<>();

    public static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addFilter(new AllureRestAssured())
                .build();
    }

}
