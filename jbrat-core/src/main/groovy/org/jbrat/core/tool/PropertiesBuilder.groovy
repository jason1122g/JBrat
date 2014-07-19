package org.jbrat.core.tool

import groovy.transform.CompileStatic

@CompileStatic
class PropertiesBuilder {

    private Properties property = new Properties()

    PropertiesBuilder fromResource(String path, String encode="UTF-8"){
        def uri = Resourcer.getResourceURI(path)
        loadFromFile(new File(uri),encode)
    }

    PropertiesBuilder fromFile    (String path, String encode="UTF-8"){
        def file = new File(path)
        if(file.exists()){
            loadFromFile(file,encode)
        }else{
            throw new FileNotFoundException()
        }
    }

    private PropertiesBuilder loadFromFile(File file, String encode){
        file.withInputStream { InputStream stream ->
            property.load(new InputStreamReader(stream, encode))
        }
        return this
    }

    Properties build(){
        return property
    }
}
