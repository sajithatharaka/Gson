package gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @Type : Class
 * @Dependencies : JsonDeserializer [i]
 * @Data : N/A
 * @Description : N/A
 */
public class DateDeserializerAdapter implements JsonDeserializer<Date> {

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
