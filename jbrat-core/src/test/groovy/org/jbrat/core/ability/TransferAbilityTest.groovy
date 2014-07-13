package org.jbrat.core.ability

import spock.lang.Specification


class TransferAbilityTest extends Specification {

    def "test transfer to another class"(){
        given:
            def transfer1 = new TransferAbility()
            def transfer2 = new TransferAbility()
        when:
            transfer1 >> transfer2
        then:
            transfer1.getNextTarget() == transfer2
    }
}
