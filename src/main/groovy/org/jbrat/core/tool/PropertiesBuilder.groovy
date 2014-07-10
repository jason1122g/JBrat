package org.jbrat.core.tool


class PropertiesBuilder {

    private Properties property = new Properties()

    def  fromFile(String path,String encode="UTF-8"){
        new File(path).withInputStream {
            property.load(new InputStreamReader(it, encode))
        }
        return this
    }

    def build(){
        return property
    }
}
