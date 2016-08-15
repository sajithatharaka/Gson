package gson.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @Type : Class
 * @Dependencies : JsonSerializer [i]
 * @Data : N/A
 * @Description : N/A
 */
public class DateSerializerAdapter implements JsonSerializer<Date> {

    @Override
    public JsonElement serialize(Date t, Type type, JsonSerializationContext jsc) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //======== Creating a JsonObject and Assigning the date value=======
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("date", sdf.format(t));
        //==================================================================
        return jsonObject;

    }
}
