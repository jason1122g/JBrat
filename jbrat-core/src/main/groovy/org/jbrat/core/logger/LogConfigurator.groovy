package org.jbrat.core.logger

import groovy.transform.CompileStatic
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.tool.Classer

@CompileStatic
class LogConfigurator {

    static void configure(BeanContainer beanContainer){
        if(Classer.classExists("org.apache.logging.log4j.core.config.Configurator")){
            Log4jConfigurator.configure(beanContainer)
        }
    }

}
