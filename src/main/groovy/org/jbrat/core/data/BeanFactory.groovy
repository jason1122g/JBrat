package org.jbrat.core.data

import groovy.transform.CompileStatic
import org.jbrat.core.data.abstracts.Bindable

@CompileStatic
class BeanFactory {
    static Bindable createEmpty(){
        return new Bean()
    }
}
