package gson.deserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import java.util.Map;

/*
 * @Type : Class
 * @Dependencies : N/A
 * @Data : N/A
 * @Description : N/A
 */
public class GsonDeserilaizeManager {

    public static Gson createGsonBuilder(Map<Type, Object> compositeObjectAdapterMap) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        // =============Adding Composite Objects to the Gson Builder=================
        compositeObjectAdapterMap.forEach((Type t, Object object) -> gsonBuilder.registerTypeAdapter(t, object));
        // =============Java 8 -> Lambda Expressions have been used==================
        Gson gson = gsonBuilder.create();
        return gson;
    }

    public static Object getContext(Map<Type, Object> compositeObjectAdapterMap, String jsonFilePath, Type type) {
        Gson gson = createGsonBuilder(compositeObjectAdapterMap);
        return gson.fromJson(jsonFilePath, type);
    }
}
