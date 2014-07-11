package org.jbrat.core

import spock.lang.Shared
import spock.lang.Specification

class JBratTest extends Specification {

    @Shared JBrat jBrat = JBrat.getInstance()

    def "route test via redirect"(){
        when:
            def resultBean = jBrat.route("root")
        then:
            resultBean.className == "System1View"
    }

    def "route test directly"(){
        when:
            def resultBean = jBrat.route("System1")
        then:
            resultBean.className == "System1View"
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

}
