package common;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import requestSpecification.GetRequestSpecification;

public class BaseTest {
    public static RequestSpecification requestSpecification;

    @BeforeClass
    public static void setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        requestSpecification = GetRequestSpecification.getRequestSpecification();

    }
}
