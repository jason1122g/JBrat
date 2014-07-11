package org.jbrat.core.data

import groovy.transform.CompileStatic

@CompileStatic
class BeanFactory {
    static Bean createEmpty(){
        return new Bean()
    }
}
