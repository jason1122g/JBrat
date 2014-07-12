package app.controller.inner

import org.jbrat.controllers.JBratController
import org.jbrat.core.data.abstracts.Bindable

class System1Controller extends JBratController{
    @Override
    void prepare(Bindable bean) {
        if(bean.className == null){
            bean.className = this.getClass().getSimpleName()
        }else{
            bean.className += this.getClass().getSimpleName()
        }
    }
}
