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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @Type : Class
 * @Dependencies : JsonSerializer [i] , JsonDeserializer [i]
 * @Data : N/A
 * @Description : N/A
 */
public class DateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

    @Override
    public JsonElement serialize(Date t, Type type, JsonSerializationContext jsc) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //======== Creating a JsonObject and Assigning the date value=======
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("date", sdf.format(t));
        //==================================================================
        return jsonObject;

    }

    @Override
    public Date deserialize(JsonElement json, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(json.getAsString());
        } catch (ParseException ex) {
            System.out.println("Exception : " + ex.getMessage());
            return null;
        }
    }
}
