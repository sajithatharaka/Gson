package sample.pojo;
/*
 * @Type : Class
 * @Dependencies : Module [i]
 * @Data : N/A
 * @Description : N/A
 */
public class ModuleImplimentation implements Module {

    private String id;
    private String name;

    public ModuleImplimentation() {
    }

    public ModuleImplimentation(String id, String name) {
        super();
        this.id = id;
        this.name = name;

    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

}
