package lesson34;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty
    public String username;

    @JsonProperty
    public String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
