# Gson
##Generic Json Parser To Read Json Context

This is to read json files and therefore have defined only DeserializerAdapter.

How to use

        //============= Map of Composite Objects ============================================================
        Map<Type, Object> compositeObjectAdapterMap = new HashMap<Type, Object>();
        compositeObjectAdapterMap.put(Date.class, new DateDeserializerAdapter());
        compositeObjectAdapterMap.put(Module.class, new ModuleDeserializerAdapter());

        //============= Instead of Json file, Json String is passed =========================================
        String s = "{name:'Sajitha',id:'ST-001',date:'2016-07-09',age:24,subjects:['Maths','English'],module:{id:'MD00-CS',name:'Secure Systems'}}";

        Student student = (Student) GsonManager.getContext(compositeObjectAdapterMap, s, Student.class);
        //============= Used Reflection - Not Important
        printTheFields(student);

##Generic Java Pojo Parser To Output Json String

This is to write json files and therefore have defined only SerializerAdapter.

How to use

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

        String student = GsonSerilaizeManager.getContext(compositeObjectAdapterMap, s,true);
        System.out.println(student);
        
###Dependencies : gson.jar (used version:2.2.2)
