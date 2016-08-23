package projectgson;

import gson.deserializer.DateDeserializerAdapter;
import gson.deserializer.GsonDeserilaizeManager;
import gson.deserializer.ModuleDeserializerAdapter;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import sample.pojo.Module;
import sample.pojo.Student;

/*
 * @Type : Class
 * @Dependencies : N/A
 * @Data : N/A
 * @Description : N/A
 */
public class ReadingFromJson {

    public static void main(String[] args) {
        //============= Map of Composite Objects ============================================================
        Map<Type, Object> compositeObjectAdapterMap = new HashMap<Type, Object>();
        compositeObjectAdapterMap.put(Date.class, new DateDeserializerAdapter());
        compositeObjectAdapterMap.put(Module.class, new ModuleDeserializerAdapter());

        //============= Instead of Json file, Json String is passed =========================================
        String s = "{name:'Sajitha',id:'ST-001',date:'2016-07-09',age:24,subjects:['Maths','English'],module:{id:'MD00-CS',name:'Secure Systems'}}";

        Student student = (Student) GsonDeserilaizeManager.getContext(compositeObjectAdapterMap, s, Student.class);
        //============= Used Reflection - Not Important
        printTheFields(student);
    }
    // As a good practise this should be moved to a seperate module
    private static void printTheFields(Student student) {
        try {
            Field[] fields = Student.class.getDeclaredFields();
            for (Field field : fields) {
                if (field.getName().equals("module")) {
                    field.setAccessible(true);
                    Object newObj = field.get(student);                    
                    Module module = (Module) newObj;
                    System.out.println(field.getName()+".id" + " :" + module.getId());
                    System.out.println(field.getName()+".name" + " :" + module.getName());
                } else {
                    field.setAccessible(true);
                    Object newObj = field.get(student);
                    System.out.println(field.getName() + " :" + newObj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception : " + e.getMessage());
        }
    }
}
