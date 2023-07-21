package config;

import org.aeonbits.owner.Config;
import static org.aeonbits.owner.ConfigFactory.*;

@Config.Sources({"classpath:${env}.properties"})
public interface WebConfig extends Config{

    WebConfig BASE_CONFIG = create(WebConfig.class, System.getenv(), System.getProperties());

    @Key("BASE_URL")
    String getBaseUrl();

    @Key("USER_NAME")
    String getLogin();

    @Key("USER_PASS")
    String getPassword();

    @Key("DB_URL")
    String getDBUrl();

    @Key("DB_USER_NAME")
    String getDBLogin();

    @Key("DB_USER_PASS")
    String geDBtPassword();

}
