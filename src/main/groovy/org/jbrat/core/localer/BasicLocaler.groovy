package org.jbrat.core.localer

import groovy.io.FileType
import groovy.transform.CompileStatic
import org.jbrat.core.data.Bean
import org.jbrat.core.data.BeanFactory
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.tool.PropertiesBuilder
import org.jbrat.exceptions.IncorrectFormatException

import java.util.regex.Matcher

@CompileStatic
class BasicLocaler implements Localer{

    private Bean langText
    private BeanContainer beanContainer

    def BasicLocaler(BeanContainer beanContainer){
        this.beanContainer = beanContainer
        this.langText = BeanFactory.createEmpty()
        this.readLocaleFiles()
    }

    private void readLocaleFiles(){
        new File(beanContainer.getLayout().localesLocation+"").eachFileRecurse(FileType.FILES) {File file->
            readFileForLocale(file)
        }
    }

    private void readFileForLocale(File file){
        String locale   = getLocaleFromString(file.getName())
        Properties prop = new PropertiesBuilder().fromFile(file.getPath()).build()

        if(langText.getProperty(locale) == null){
            langText.setProperty( locale, BeanFactory.createEmpty())
        }

        prop.each { String key, String value->
            ( (Bean) langText.getProperty(locale) ) .setProperty( key, value )
        }
    }

    private static String getLocaleFromString(String s){
        Matcher matcher = s =~ /(\w+)_[0-9a-zA-Z_.]+/
        if(matcher.matches()){
            return  matcher.group(1)
        }else{
            throw new IncorrectFormatException("Locale file doesn't specify the locale:"+s)
        }
    }

    @Override
    String localeText(String name){
        ((Bean)langText.getProperty(beanContainer.getLocale())).getProperty(name)
    }
}
