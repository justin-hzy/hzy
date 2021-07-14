package com.hzy.demo.json;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonDemo {

    public static void main(String[] args) {

        String json = "{'name':'reiz'}";
        JSONObject jsonObj = new JSONObject(json);


        String name = jsonObj.getString("name");

        System.out.println("jsonObj="+jsonObj.toString());
        System.out.println(name);

        /*jsonObj.put("initial", name.substring(0, 1).toUpperCase());

        String[] likes = new String[] { "JavaScript", "Skiing", "Apple Pie" };
        jsonObj.put("likes", likes);

        System.out.println(jsonObj);

        JSONObject jsonObj1 = new JSONObject();
        Map<String, String> ingredients = new HashMap<String, String>();
        ingredients.put("apples", "3kg");
        ingredients.put("sugar", "1kg");
        ingredients.put("pastry", "2.4kg");
        ingredients.put("bestEaten", "outdoors");
        jsonObj1.put("ingredients", ingredients);
        System.out.println(jsonObj1);*/
    }
}
