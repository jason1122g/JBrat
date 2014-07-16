package org.jbrat.core.tool

import groovy.transform.CompileStatic


@CompileStatic
class PropertiesBuilder {

    private Properties property = new Properties()

    PropertiesBuilder fromResource(String path,String encode="UTF-8"){
        def uri = this.getClass().getResource(path).toURI()
        new File(uri).withInputStream { InputStream stream ->
            property.load(new InputStreamReader(stream, encode))
        }
        return this
    }

    Properties build(){
        return property
    }
}
