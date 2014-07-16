package org.jbrat.views

import groovy.transform.CompileStatic
import org.jbrat.core.data.abstracts.Bean

@CompileStatic
abstract class JBratView extends JBratViewHelper implements View{
    @Override
    void enter() {

    }

    @Override
    void beforeRender() {

    }

    @Override
    abstract void render(Bean bean);

    @Override
    void afterRender() {

    }

    @Override
    void exit() {

    }

}
