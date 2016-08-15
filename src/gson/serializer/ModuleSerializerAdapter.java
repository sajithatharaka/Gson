/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gson.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import sample.pojo.Module;

/*
 * @Type : Class
 * @Dependencies : JsonSerializer [i]
 * @Data : N/A
 * @Description : N/A
 */

public class ModuleSerializerAdapter implements JsonSerializer<Module> {

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
