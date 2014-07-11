package org.jbrat.core.tool

import groovy.transform.CompileStatic
import org.jbrat.core.data.Bean
import org.jbrat.core.data.BeanBuilder
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.data.Layout

import java.util.regex.Matcher

@CompileStatic
class AppConfigReader {

    private String appConfigPath
    private String resourceBase

    AppConfigReader(){
        Layout layout      = new Layout.Builder().build()
        String appPosition = layout.getApplicationSettingPosition()
        appConfigPath = appPosition + "/application.properties"
        resourceBase  = Layout.Builder.getResourceBase()
    }

    BeanContainer asBeanContainer(){

        BeanBuilder    beanBuilder   = new BeanBuilder()
        Layout.Builder layoutBuilder = new Layout.Builder()

        Properties properties = new PropertiesBuilder().fromFile(appConfigPath).build()
        properties.each { String key, String value->
            switch(key){
                case ~/^locale$/:
                    beanBuilder.setLocale(value)
                    break
                case ~/^layout\.(\w+)/:
                    String positionName = Matcher.lastMatcher.group(1)
                    if(value.contains(":resource")){
                        value = resourceBase + value.replaceFirst(/^:resource/,"")
                    }
                    layoutBuilder.setProperty(positionName,value)
                    break
            }
        }

        Bean bean = beanBuilder.setLayout(layoutBuilder.build()).build()
        return new BeanContainer(bean)

    }
}
