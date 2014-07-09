package org.jbrat.core

import spock.lang.IgnoreRest
import spock.lang.Specification


class RegxTest extends Specification{


    @IgnoreRest
    def skipAll(){
        expect:true
    }

    def "test 1"(){
        given:
            def regx = /(.+)\??(.+)?/
            def string = "hello?var1=1,var2=2"
            def result = []
        when:
            def matcher = string =~ regx
            if(matcher.matches()){
               result =  matcher[0]
            }
        then:
            result[1] == "hello"
            result[2] == "var1=1,var2=2"
    }

    def "test 2"(){
        given:
            def regx = /(.+=.+),(.+=.+)*/
            def string = "var1=1 , var2= 2,var3  = 3"
            def result = []
        when:
            def matcher = string =~ regx
            if(matcher.matches()){
                result =  matcher[0]
            }
        then:
            result[1] == "var1=1 "
            result[2] == " var2= 2"
            result[3] == "var3  = 3"
    }
}
