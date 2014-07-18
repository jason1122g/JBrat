package app.controller

import org.jbrat.core.data.abstracts.Bean

class LaunchController extends ApplicationController{
    @Override
    void prepare(Bean bean) {
        bean.fromController = this.getClass().getSimpleName()
    }
}
