package org.jbrat.models;

public class EventModel extends CacheModel<Runnable> {
    public void trigger(String name){
        this.get(name).run();
    }
}
