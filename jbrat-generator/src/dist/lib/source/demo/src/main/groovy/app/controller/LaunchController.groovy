package app.controller

import org.jbrat.controllers.JBratController
import org.jbrat.core.data.abstracts.Bindable

class LaunchController extends JBratController{
    @Override
    void prepare(Bindable bean) {
        bean.fromController = this.getClass().getSimpleName()
    }
}
