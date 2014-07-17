package org.jbrat.core.tool

import org.jbrat.exceptions.ResourceNotFoundError

class Resourcer {
    static URI getResourceURI(String path){
        try{
            return this.getClass().getResource(path).toURI()
        }catch (NullPointerException e){
            throw new ResourceNotFoundError("Not found in classPath:"+path,e)
        }
    }
}
