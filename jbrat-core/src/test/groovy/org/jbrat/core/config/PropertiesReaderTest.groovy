package org.jbrat.core.config

import spock.lang.Specification

class PropertiesReaderTest extends Specification {
    def "read properties"(){
        expect:
            configReader.read().locale == localeText

        where:
        configReader                 ||localeText
        new ResourceConfigReader()   ||"zhTW"
        new FileConfigReader()       ||"zhTW"
    }
}
