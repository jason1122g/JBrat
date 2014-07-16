package org.jbrat.core.logger

import groovy.transform.CompileStatic
import org.apache.logging.log4j.core.config.ConfigurationSource
import org.apache.logging.log4j.core.config.Configurator
import org.jbrat.core.data.BeanContainer

@CompileStatic
class Log4jConfigurator {

    static void configure(BeanContainer beanContainer){
        setEnvironmentVariables(beanContainer)
        configureLog4j( getConfigurationFile(beanContainer) )
    }

    private static void setEnvironmentVariables(BeanContainer beanContainer){
        System.setProperty("logLocation", beanContainer.getLayout().getLogLocation());
    }

    private static File getConfigurationFile(BeanContainer beanContainer){
        def configPath = beanContainer.getLayout().getConfigLocation()
        def log4jPath  = configPath + "/log4j2.xml"
        return new File(this.class.getResource(log4jPath).toURI())
    }

    private static void configureLog4j(File configFile){
        ConfigurationSource source = new ConfigurationSource(new FileInputStream(configFile));
        Configurator.initialize(null, source);
    }
}
