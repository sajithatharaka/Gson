package gson.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import sample.pojo.Module;
import sample.pojo.Modules;

/*
 * @Type : Class
 * @Dependencies : JsonDeserializer [i]
 * @Data : N/A
 * @Description : N/A
 */

public class ModuleDeserializerAdapter implements JsonDeserializer<Module> {

    @Override
    public Module deserialize(JsonElement json, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        Module module = Modules.create(jsonObject.get("id").getAsString(), jsonObject.get("name").getAsString());
        return module;
    }
}
