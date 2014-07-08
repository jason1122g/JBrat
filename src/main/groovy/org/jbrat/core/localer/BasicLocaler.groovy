package org.jbrat.core.localer

import groovy.io.FileType
import org.jbrat.core.data.JBratBean
import org.jbrat.exceptions.IncorrectFormatException


class BasicLocaler implements Localer{

    private def configBean
    private def langText = new JBratBean()

    def BasicLocaler(configBean){
        this.configBean = configBean
        readLocaleFiles()
    }

    private def readLocaleFiles(){
        new File(configBean.layout.localesPosition+"").eachFileRecurse(FileType.FILES) { file->
            readFileForLocale(file)
        }
    }

    private def readFileForLocale(File file){
        def locale     = getLocaleFromString(file.getName())
        def properties = getPropertiesFromFile(file)

        if(langText."$locale" == null){
            langText."$locale" = new JBratBean()
        }

        properties.keys().each { key->
            langText."$locale"."$key" = properties."$key"
        }
    }

    private static def getLocaleFromString(String s){
        def locale

        if(s.contains("_")){
            locale = s.split("_")[0]
        }else{
            throw new IncorrectFormatException("Locale file doesn't specify the locale:"+s)
        }

        return locale
    }

    private static def getPropertiesFromFile(File file){
        Properties properties = new Properties()
        file.withInputStream {
            properties.load(new InputStreamReader(it,"UTF-8"))
        }
        return properties
    }

    @Override
    def localeText(name){
        langText."$configBean.locale"."$name"
    }
}
