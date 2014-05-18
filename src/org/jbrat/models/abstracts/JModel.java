package org.jbrat.models.abstracts;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public abstract class JModel<Type> {
    private Map<String,LinkedList<DataHandler<Type>>> bindHandlerMap = new TreeMap<String, LinkedList<DataHandler<Type>>>();

    public Type get(String name){
        return getter(name);
    }

    public void set(String name, Type data){
        processRealSetterWithNameData(name, data);
        processBindEventsWithNameData(name,data);
    }
    private void processRealSetterWithNameData(String name,Type data){
        setter(name,data);
    }
    private void processBindEventsWithNameData(String name, Type data){
        LinkedList<DataHandler<Type>> list = bindHandlerMap.get(name);
        for(DataHandler<Type> handler:list){
            handler.handle(data);
        }
    }

    public void bind  (String name, DataHandler<Type> handler){
        if( bindHandlerMap.containsKey(name)){
            getExistListThenAddHandler(name,handler);
        }else{
            initANewListThenAddHandler(name,handler);
        }
    }
    private  void getExistListThenAddHandler(String name,DataHandler<Type> handler){
        LinkedList<DataHandler<Type>> list = bindHandlerMap.get(name);
        list.add(handler);
    }
    private  void initANewListThenAddHandler(String name,DataHandler<Type> handler){
        LinkedList<DataHandler<Type>> list = new LinkedList<DataHandler<Type>>();
        list.add(handler);
        bindHandlerMap.put(name,list);
    }

    public void unbind(String name, DataHandler<Type> handler){
        if(bindHandlerMap.containsKey(name)){
            LinkedList<DataHandler<Type>> list = bindHandlerMap.get(name);
            list.remove(handler);
        }
    }

    protected abstract Type getter(String name);
    protected abstract void setter(String name,Type data);
}
