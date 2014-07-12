package org.jbrat.core

import org.jbrat.core.data.Layout
import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification

class JBratTest extends Specification {

    @Shared JBrat jBrat = JBrat.getInstance()

    def "route test via redirect"(){
        when:
            def resultBean = jBrat.route("root")
        then:
            resultBean.className == "System1ControllerSystem1View"
    }

    def "route test directly"(){
        when:
            def resultBean = jBrat.route("System1")
        then:
            resultBean.className == "System1ControllerSystem1View"
    }

    def "locale text test"(){
        expect:
            jBrat.localeText("msg1") == "哈囉世界!"
    }

    def "render test"(){
        when:
            def resultBean = jBrat.render("System1",null)
        then:
            resultBean.className == "System1View"
    }

    def "logger test"(){
        given:
            String path = new Layout.Builder().build().getLogLocation() + "/inner/jbrat.log"
            File   file = new File( path )
        when:
            jBrat.route("Logger1")
        then:
            file.exists()
        then:
            file.deleteOnExit()
    }

}
