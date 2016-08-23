package projectgson;

import gson.serializer.DateSerializerAdapter;
import gson.serializer.GsonSerilaizeManager;
import gson.serializer.ModuleSerializerAdapter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sample.pojo.Module;
import sample.pojo.Modules;
import sample.pojo.Student;

/*
 * @Type : Class
 * @Dependencies : N/A
 * @Data : N/A
 * @Description : N/A
 */
public class WritingToJson {

    public static void main(String[] args) {
        //============= Map of Composite Objects ============================================================
        Map<Type, Object> compositeObjectAdapterMap = new HashMap<Type, Object>();
        compositeObjectAdapterMap.put(Date.class, new DateSerializerAdapter());
        compositeObjectAdapterMap.put(Module.class, new ModuleSerializerAdapter());

        //============= Data for POJOs =========================================
        Module m = Modules.create("MD00-CS", "Secure Systems");
        List<String> subjects = new ArrayList<>();
        subjects.add("English");
        subjects.add("Maths");

        Student s = new Student();
        s.setAge(24);
        s.setDate(new Date());
        s.setId("001");
        s.setName("Sajitha");
        s.setModule(m);
        s.setSubjects(subjects);

        String student = GsonSerilaizeManager.getJsonString(compositeObjectAdapterMap, s,true);
        System.out.println(student);

    }

}
