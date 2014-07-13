package jbrat.generator

import org.jbrat.generator.test
import spock.lang.Specification


class testTest extends Specification{

    def "test1"(){
        given:
            def target = new test()
        expect:
            target.say() == "HelloWorld!"
    }

}
