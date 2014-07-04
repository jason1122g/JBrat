package org.jbrat.controllers

import org.jbrat.abilities.Actionable
import org.jbrat.core.JBratRouter


abstract class JBratController implements Controller,Actionable{

    @Override
    abstract void prepare(Object bean);

    @Override
    void invokeAction(Object path) {
        JBratRouter.getInstance().route(path);
    }

}
