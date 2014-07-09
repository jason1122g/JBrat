package org.jbrat.core.localer

import org.jbrat.core.data.Layout
import org.jbrat.core.data.container.BeanContainer
import org.jbrat.exceptions.IncorrectFormatException
import spock.lang.Shared
import spock.lang.Specification
import tools.ExpandableBean


class BasicLocalerTest extends Specification {

    @Shared BeanContainer beanContainer


    def setupSpec(){

        def configBean = new ExpandableBean();
        configBean.layout = new Layout.Builder().setLocalesPosition(getPosition()).build()
        configBean.locale = "enUS"

        def bean = new ExpandableBean();
        bean.config = configBean
        beanContainer = new BeanContainer(bean)
    }

    private static def getPosition(){
        new File(this.getClass().getResource("/jbrat").toURI()).toString()+"/config/locales"
    }

    def "fetch locale text from locale setting 1"(){
        given:
            def basicLocaler = new BasicLocaler(beanContainer);
        expect:
            basicLocaler.localeText("msg1") == "HelloWorld!"
            basicLocaler.localeText("msg2") == "You are good"
            basicLocaler.localeText("msg3") == "Other"
    }

    def "fetch locale text from locale setting 2"(){
        given:
            def basicLocaler = new BasicLocaler(beanContainer);
        when:
            beanContainer.setLocale("zhTW")
        then:
            basicLocaler.localeText("msg1") == "哈囉世界!"
            basicLocaler.localeText("msg2") == "你很好"
            basicLocaler.localeText("msg3") == "其他"
    }

    def "files must begin with locale prefix"(){
        given:
            new File(getPosition()+"/noPreFix.properties").createNewFile()
        when:
            new BasicLocaler(beanContainer);
        then:
            thrown(IncorrectFormatException)
        then:
            new File(getPosition()+"/noPreFix.properties").delete()
    }

    def "files not in format of .properties will do nothing"(){
        given:
            def file = new File(getPosition()+"/enUS_wrongFormat.properties")
            file.createNewFile()
        and:
            file.setText("{'key':'I am === json'}")
        when:
            new BasicLocaler(beanContainer);
        then:
            notThrown(Exception)
    }


}