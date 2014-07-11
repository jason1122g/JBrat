package org.jbrat.core.ability

import groovy.transform.CompileStatic

@CompileStatic
class TransferAbility {

    def TransferAbility nextTarget

    TransferAbility rightShift(TransferAbility target){
        nextTarget = target
    }

}
