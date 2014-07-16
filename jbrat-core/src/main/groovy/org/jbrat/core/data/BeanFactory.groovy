package org.jbrat.core.data

import groovy.transform.CompileStatic
import org.jbrat.core.data.abstracts.Bean

@CompileStatic
class BeanFactory {
    static Bean createEmpty(){
        return new BasicBean()
    }
}
