package org.jbrat.core.router.filter

import org.jbrat.core.ability.TransferAbility
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.router.abstracts.Router


class ControllerFilter extends TransferAbility implements Router{
    @Override
    def route(uri,otherBean) {

        BeanContainer bean = new BeanContainer(otherBean)
        bean.setConfig(null)
        bean.setComponent(null)
        bean.setParam(null)

        if(nextTarget == null){
            return otherBean
        }else{
            return nextTarget.route(uri,otherBean)
        }
    }
}
