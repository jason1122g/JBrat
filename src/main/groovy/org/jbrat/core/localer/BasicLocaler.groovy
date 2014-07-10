package org.jbrat.core.localer

import groovy.io.FileType
import org.jbrat.core.data.BeanFactory
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.tool.PropertiesBuilder
import org.jbrat.exceptions.IncorrectFormatException


class BasicLocaler implements Localer{

    private def langText

    private BeanContainer beanContainer

    def BasicLocaler( beanContainer){
        this.beanContainer = beanContainer
        this.langText = BeanFactory.createEmpty()
        this.readLocaleFiles()
    }

    private def readLocaleFiles(){
        new File(beanContainer.getLayout().localesPosition+"").eachFileRecurse(FileType.FILES) { file->
            readFileForLocale(file)
        }
    }

    private def readFileForLocale(File file){
        def locale     = getLocaleFromString(file.getName())
        def properties = new PropertiesBuilder().fromFile(file.getPath()).build()

        if(langText."$locale" == null){
            langText."$locale" = BeanFactory.createEmpty()
        }

        properties.keys().each { key->
            langText."$locale"."$key" = properties."$key"
        }
    }

    private static def getLocaleFromString(String s){
        def matcher = s =~ /(\w+)_[0-9a-zA-Z_.]+/
        if(matcher.matches()){
            return  matcher.group(1)
        }else{
            throw new IncorrectFormatException("Locale file doesn't specify the locale:"+s)
        }
    }

    @Override
    def localeText(name){
        langText."${beanContainer.getLocale()}"."$name"
    }
}
