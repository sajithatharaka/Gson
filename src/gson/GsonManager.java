/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import java.util.Map;
import sample.pojo.Student;

/**
 *
 * @author SPathirana
 */
public class GsonManager {

    public static Object getContext(Map<Type, Object> compositeObjectAdapterMap, String jsonFilePath, Type type) {
        Gson gson = createGsonBuilder(compositeObjectAdapterMap, false);
        return gson.fromJson(jsonFilePath, type);
    }

    public static Gson createGsonBuilder(Map<Type, Object> compositeObjectAdapterMap, boolean isPrettyPrinting) {
        GsonBuilder gsonBuilder = new GsonBuilder();

        if (isPrettyPrinting) {
            //===== Json Output is organized====
            gsonBuilder.setPrettyPrinting();
            //===================================
        }
        // =============Adding Composite Objects to the Gson Builder=================
        compositeObjectAdapterMap.forEach((Type t, Object object) -> gsonBuilder.registerTypeAdapter(t, object));
        // =============Java 8 -> Lambda Expressions have been used==================
        Gson gson = gsonBuilder.create();
        return gson;
    }

    public static String getJsonString(Map<Type, Object> compositeObjectAdapterMap, Student student, boolean isPrettyPrinting) {
        Gson gson = createGsonBuilder(compositeObjectAdapterMap, isPrettyPrinting);
        return gson.toJson(student);
    }
}
