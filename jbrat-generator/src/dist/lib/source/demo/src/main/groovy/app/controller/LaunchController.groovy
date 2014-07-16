package app.controller

import org.jbrat.controllers.JBratController
import org.jbrat.core.data.abstracts.Bean

class LaunchController extends JBratController{
    @Override
    void prepare(Bean bean) {
        bean.fromController = this.getClass().getSimpleName()
    }
}
