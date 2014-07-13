package org.jbrat.core.tool

import groovy.transform.CompileStatic


@CompileStatic
class PropertiesBuilder {

    private Properties property = new Properties()

    PropertiesBuilder fromFilePath(String path,String encode="UTF-8"){
        new File(path).withInputStream { InputStream stream ->
            property.load(new InputStreamReader(stream, encode))
        }
        return this
    }

    Properties build(){
        return property
    }
}
