# Gson
Generic Json Parser To Read Json Context

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
