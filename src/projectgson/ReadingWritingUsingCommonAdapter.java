/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgson;

import gson.DateAdapter;
import gson.ModuleAdapter;
import gson.deserializer.GsonDeserilaizeManager;
import gson.serializer.GsonSerilaizeManager;
import java.lang.reflect.Field;
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

public class ReadingWritingUsingCommonAdapter {

    public static void main(String[] args) {
        //============= Map of Composite Objects ============================================================
        Map<Type, Object> compositeObjectAdapterMap = new HashMap<Type, Object>();
        compositeObjectAdapterMap.put(Date.class, new DateAdapter());
        compositeObjectAdapterMap.put(Module.class, new ModuleAdapter());

        //============= Instead of Json file, Json String is passed =========================================
        String s = "{name:'Sajitha',id:'ST-001',date:'2016-07-09',age:24,subjects:['Maths','English'],module:{id:'MD00-CS',name:'Secure Systems'}}";

        Student student = (Student) GsonDeserilaizeManager.getContext(compositeObjectAdapterMap, s, Student.class);
        //============= Used Reflection - Not Important
        System.out.println("Deserializing ... \n");
        printTheFields(student);

        //============= Data for POJOs =========================================
        Module m = Modules.create("MD00-CS", "Secure Systems");
        List<String> subjects = new ArrayList<>();
        subjects.add("English");
        subjects.add("Maths");

        student = new Student();
        student.setAge(24);
        student.setDate(new Date());
        student.setId("001");
        student.setName("Sajitha");
        student.setModule(m);
        student.setSubjects(subjects);

        s = GsonSerilaizeManager.getJsonString(compositeObjectAdapterMap, student, true);
        System.out.println("\nSerializing ... \n");
        System.out.println(s);
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
                    System.out.println(field.getName() + ".id" + " :" + module.getId());
                    System.out.println(field.getName() + ".name" + " :" + module.getName());
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
