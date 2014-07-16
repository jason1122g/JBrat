package org.jbrat.core.logger

import org.apache.logging.log4j.LogManager
import org.jbrat.core.data.BeanBuilder
import org.jbrat.core.data.BeanContainer
import spock.lang.Specification

class Log4jConfiguratorTest extends Specification {
    def "be able to use custom logger after configure"(){
        given:
            def beanContainer = new BeanContainer(new BeanBuilder().build())
            def logDir  = beanContainer.getLayout().getLogLocation()
            def logName = logDir + LogTest.logFileName
            def file    = new File( logName )
        when:
            Log4jConfigurator.configure(beanContainer)
        and:
            LogManager.getLogger(this.getClass()).error("321")
        then:
            file.exists()
        then:
            file.deleteOnExit()
    }
}
