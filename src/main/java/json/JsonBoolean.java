package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */
public class JsonBoolean extends Json {
    private final Boolean bool;
    public JsonBoolean(Boolean bool) {
        this.bool = bool;

    }

    public String toString() {
        return bool.toString();
    }

    @Override
    public String toJson() {
        return bool.toString();
    }

}
