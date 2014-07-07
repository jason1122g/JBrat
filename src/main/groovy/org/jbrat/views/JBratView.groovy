package org.jbrat.views


abstract class JBratView extends JBratViewHelper implements View{
    @Override
    void enter() {

    }

    @Override
    void beforeRender() {

    }

    @Override
    abstract void render(Object bean);

    @Override
    void afterRender() {

    }

    @Override
    void exit() {

    }

}
