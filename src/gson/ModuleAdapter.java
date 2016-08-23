/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import sample.pojo.Module;
import sample.pojo.Modules;

/*
 * @Type : Class
 * @Dependencies : JsonSerializer [i] , JsonDeserializer[i]
 * @Data : N/A
 * @Description : N/A
 */
public class ModuleAdapter implements JsonSerializer<Module>, JsonDeserializer<Module> {

    @Override
    public Module deserialize(JsonElement json, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        Module module = Modules.create(jsonObject.get("id").getAsString(), jsonObject.get("name").getAsString());
        return module;
    }

    @Override
    public JsonElement serialize(Module t, Type type, JsonSerializationContext jsc) {
        //======== Creating a JsonObject and Assigning the Module values =======
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", t.getId());
        jsonObject.addProperty("name", t.getName());
        //======================================================================
        return jsonObject;
    }
}
