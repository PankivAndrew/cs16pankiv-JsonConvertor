package json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    HashMap<String,Json> objsJson;

    public JsonObject(JsonPair... jsonPairs) {
        HashMap<String,Json> jsonArr = new HashMap<>();
        if (jsonPairs == null){
            this.objsJson = jsonArr;
        }else {
            for (JsonPair objects : jsonPairs) {
                jsonArr.put(objects.getKey(), objects.getValue());
            }
            this.objsJson = jsonArr;
        }
    }

    @Override
    public String toJson() {
        if (objsJson.isEmpty()){
            return "{}";
        }
        String str = "{";
        Set<String> keys = objsJson.keySet();
        for (String s : keys) {
            str += s + " : " + objsJson.get(s).toString() + ",";
            }
        str = str.substring(0,str.length() - 1) + "}";
        return str;
    }

    public void add(JsonPair jsonPair) {
        objsJson.put(jsonPair.getKey(),jsonPair.getValue());
    }

    public Json find(String name) {
        return objsJson.get(name);
    }

    public JsonObject projection(String... names) {
        JsonObject json = new JsonObject();
        for (String name: names){
            if (objsJson.get(name) != null){
                json.add(new JsonPair(name,objsJson.get(name)));
            }
        }
        return json;
    }
    public boolean contains(String name){
        if (objsJson.get(name) != null){
            return true;
        }else{
            return false;
        }
    }


}
