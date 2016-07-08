package sample.pojo;
/*
 * @Type : Class
 * @Dependencies : N/A
 * @Data : N/A
 * @Description : N/A
 */
public class Modules {
    public static Module create(String id, String name) {
        return new ModuleImplimentation(id, name);
    }
}
