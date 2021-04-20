package utilities;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;

public class Basic {

    public static final String baseURI = new StringBuilder()
            .append(Const.PROTOCOL)
            .append("://")
            .append(Const.OPEN_BREWERY_HOST)
            .toString();

    protected static void setUp() {
        RestAssured.config = new RestAssuredConfig()
                .encoderConfig(EncoderConfig.encoderConfig()
                        .defaultContentCharset("UTF-8"));
        RestAssured.baseURI = baseURI;
    }
}
