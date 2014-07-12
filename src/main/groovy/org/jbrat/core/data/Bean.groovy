package org.jbrat.core.data

import org.jbrat.core.data.abstracts.Bindable


class Bean implements Bindable{

    private def storage = [:]
    private def events  = [:]

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
        if(events[name]==null){
            events[name] = []
        }
        events[name] << event
    }

    @Override
    void unbind(String name, Closure event) {
        if(events[name] != null){
            events[name].remove(event)
            if(events[name].size() == 0){
                events[name] = null
            }
        }
    }

}
