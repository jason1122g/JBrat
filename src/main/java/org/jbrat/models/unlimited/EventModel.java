package org.jbrat.models.unlimited;

import org.jbrat.models.limited.LEventModel;

public class EventModel extends CacheModel<Runnable> implements LEventModel{
    public void trigger(String name){
        this.get(name).run();
    }
}
