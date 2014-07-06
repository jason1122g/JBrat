package org.jbrat.views



abstract class JBratView implements View{
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

    static void invokeRender(Class viewClass, bean) {
        
    }

    static void localeText(stringName){

    }
}
