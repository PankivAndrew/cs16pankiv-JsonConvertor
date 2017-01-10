package domain;

import json.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    Tuple<String, Integer>[] exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        this.exams = exams;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObject json = new JsonObject();

        json.add(new JsonPair("name",new JsonString(name)));
        json.add(new JsonPair("surname",new JsonString(surname)));
        json.add(new JsonPair("year",new JsonNumber(year)));
        json.add(new JsonPair("exam",new JsonArray()));
        return json;
    }
}