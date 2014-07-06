package org.jbrat.views

import app.view.renderTestView
import spock.lang.Specification

class JBratViewTest extends Specification {

    def "render other Views"(){
        given:
            def view = Mock(JBratView)
            def bean = [var1 : new Random().nextInt()]
        when:
            view.invokeRender(renderTestView.class,bean)
        then:
            bean["renderTest"] == bean["var1"]
    }

    def "use localeText() to get locale string"(){
        expect:
            JBratView.localeText("msg") == "HelloWorld!"
    }
}
