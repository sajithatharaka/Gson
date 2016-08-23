package gson.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import java.util.Map;
import sample.pojo.Student;

/*
 * @Type : Class
 * @Dependencies : N/A
 * @Data : N/A
 * @Description : N/A
 */
public class GsonSerilaizeManager {

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
