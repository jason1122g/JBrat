package org.jbrat.core

import org.jbrat.core.data.Layout
import org.jbrat.core.data.container.BeanContainer
import org.jbrat.core.router.filter.ControllerFilter
import org.jbrat.core.router.ControllerRouter
import org.jbrat.core.router.ViewRouter
import org.jbrat.core.localer.BasicLocaler
import org.jbrat.core.router.BasicSystemRouter


class JBrat {

    private static def layout  = new Layout.Builder().build()

    private static def configBean = 1;
    private static def beanContainer = new BeanContainer(1)

    private static def localer       = new BasicLocaler    (beanContainer)
    private static def viewRouter    = new ViewRouter      (beanContainer)
    private static def controlRouter = new ControllerRouter(beanContainer)

    private static def router = new BasicSystemRouter() >> controlRouter >> new ControllerFilter() >> viewRouter

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
        viewRouter.route(name,bean)
    }

    static def localeText(name){
        return localer.localeText(name)
    }
}
