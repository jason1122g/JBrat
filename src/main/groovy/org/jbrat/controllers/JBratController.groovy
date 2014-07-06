package org.jbrat.controllers

import org.jbrat.abilities.Actionable
import org.jbrat.core.JBratRouter


abstract class JBratController implements Controller{

    @Override
    abstract void prepare(Object bean);

    static void invokeAction(Object path) {
        JBratRouter.getInstance().route(path);
    }

}
