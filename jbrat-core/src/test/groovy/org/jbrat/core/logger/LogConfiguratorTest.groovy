package org.jbrat.core.logger

import org.apache.logging.log4j.LogManager
import org.jbrat.core.data.BeanBuilder
import org.jbrat.core.data.BeanContainer
import spock.lang.Specification

class LogConfiguratorTest extends Specification {
    def "if log4j is in classpath then will init it"(){
        given:
            def beanContainer = new BeanContainer(new BeanBuilder().build())
            def logDir  = beanContainer.getLayout().getLogLocation()
            def logName = logDir + LogTest.logFileName
            def file    = new File( logName )
        when:
            LogConfigurator.configure(beanContainer)
        and:
            LogManager.getLogger(this.getClass()).error("123")
        then:
            file.exists()
        then:
            file.deleteOnExit()
    }
}
