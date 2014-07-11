package org.jbrat.core.ability

import groovy.transform.CompileStatic

@CompileStatic
class TransferAbility {

    def Object nextTarget

    def rightShift(Object target){
        nextTarget = target
    }

}
