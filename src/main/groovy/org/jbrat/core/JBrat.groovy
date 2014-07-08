package org.jbrat.core

import org.jbrat.core.data.Layout
import org.jbrat.core.router.ControllerRouter
import org.jbrat.core.router.ViewRouter
import org.jbrat.core.localer.BasicLocaler
import org.jbrat.core.router.BasicSystemRouter


class JBrat {

    private static def layout  = new Layout.Builder().build()

    private static def configBean = 1;

    private static def viewInitor    = new ViewRouter      (configBean)
    private static def controlInitor = new ControllerRouter(configBean)
    private static def localer       = new BasicLocaler      (configBean)

    private static def router = new BasicSystemRouter(viewInitor,controlInitor)

    static{
        configBean.layout = layout
        //read application.properties to set all config ready
        //use default layout for the position which is not setted
    }

    static void route(path){
        router.route(path)
    }

    static void start(){
        route("root")
    }

    static void render(name,bean){
        viewInitor.route(name,bean)
    }

    static def localeText(name){
        return localer.localeText(name)
    }
}
