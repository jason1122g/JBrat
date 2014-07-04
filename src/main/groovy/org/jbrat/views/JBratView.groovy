package org.jbrat.views

import org.jbrat.abilities.Renderable


abstract class JBratView implements View,Renderable{
    @Override
    void enter() {}

    @Override
    void beforeRender() {}

    @Override
    abstract void render(Object bean);

    @Override
    void afterRender() {}

    @Override
    void exit() {}

    @Override
    void invokeRender(Object name, Object bean) {
        
    }
}
