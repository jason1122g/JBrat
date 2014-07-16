package org.jbrat.core

import groovy.transform.CompileStatic
import org.jbrat.core.config.AppConfig
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.data.abstracts.Bean
import org.jbrat.core.localer.BasicLocaler
import org.jbrat.core.localer.Localer
import org.jbrat.core.logger.LogConfigurator
import org.jbrat.core.router.ControllerRouter
import org.jbrat.core.router.ViewRouter
import org.jbrat.core.router.abstracts.RouterFilter
import org.jbrat.core.router.filter.ControllerFilter
import org.jbrat.core.router.filter.RedirectFilter

@CompileStatic
class JBrat {

    private static def JBrat self

    private Localer      localer
    private RouterFilter viewRouter
    private RouterFilter router

    private JBrat(){
        BeanContainer beanContainer = new AppConfig().asBeanContainer()
        configureLogger(beanContainer)
        configureRouter(beanContainer)
    }

    private static void configureLogger(BeanContainer beanContainer){
        LogConfigurator.configure(beanContainer)
    }

    private void configureRouter(BeanContainer beanContainer){
        RouterFilter controlRouter  = new ControllerRouter(beanContainer)
        RouterFilter controllFilter = new ControllerFilter()
        router     = new RedirectFilter  (beanContainer)
        viewRouter = new ViewRouter      (beanContainer)
        localer    = new BasicLocaler    (beanContainer)

        router >> controlRouter >> controllFilter >> viewRouter
    }

    Bean route(String path, Bean bean=null){
        router.route(path,bean)
    }

    Bean render(String name, Bean bean){
        viewRouter.route(name,bean)
    }

    String localeText(String name){
        return localer.localeText(name)
    }

    static JBrat getInstance(){
        if(self == null){
            self = new JBrat()
        }
        return self
    }

}
