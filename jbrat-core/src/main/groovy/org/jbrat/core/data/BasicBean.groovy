package org.jbrat.core.data

import org.jbrat.core.data.abstracts.Bean


class BasicBean implements Bean {

    private Map<String,Object> storage = [:]
    private Map<String,List>   events  = [:]

    @Override
    def getProperty(String name) {
        storage[name]
    }

    @Override
    void setProperty(String name, value) {
        storage[name] = value

        events[name]?.each { Closure event->
            event.call(value)
        }
    }

    @Override
    void bind(String name, Closure event) {
        if(events[name] == null){
            events[name] = []
        }
        events[name] << event
    }

    @Override
    void unbind(String name, Closure event) {
        def eventList = events[name]
        if( eventList != null){
            eventList.remove(event)
            if(eventList.size() == 0){
                events[name] = null
            }
        }
    }

}
