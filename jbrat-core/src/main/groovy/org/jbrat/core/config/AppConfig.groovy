package org.jbrat.core.config

import groovy.transform.CompileStatic
import org.jbrat.core.config.abstracts.ConfigReader
import org.jbrat.core.data.BeanBuilder
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.data.Layout
import org.jbrat.core.data.abstracts.Bean

import java.util.regex.Matcher

@CompileStatic
class AppConfig {

    private Bean configBean

    AppConfig(ConfigReader reader){
        this.configBean = parseProperties(reader.read())
    }

    private static Bean parseProperties(Properties property){

        BeanBuilder    beanBuilder   = new BeanBuilder()
        Layout.Builder layoutBuilder = new Layout.Builder()

        property.each { String key, String value->
            switch(key){
                case ~/^locale$/:
                    beanBuilder.setLocale(value)
                    break
                case ~/^layout\.(\w+)/:
                    String positionName = Matcher.lastMatcher.group(1)
                    if(value.contains("\${resource}")){
                        value = Layout.getResourceBase() + value.replaceFirst(/\$\{resource}/,"")
                    }
                    layoutBuilder.setProperty(positionName,value)
                    break
            }
        }

        return beanBuilder.setLayout(layoutBuilder.build()).build()
    }

    BeanContainer asBeanContainer(){
        return new BeanContainer(configBean)
    }
}
