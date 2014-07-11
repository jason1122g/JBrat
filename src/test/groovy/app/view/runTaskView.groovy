package app.view

import org.jbrat.views.View

class runTaskView implements View{
    @Override
    void enter() {

    }

    @Override
    void beforeRender() {

    }

    @Override
    void afterRender() {

    }

    @Override
    void exit() {

    }

    @Override
    void render(Object bean) {
        bean?.test?.call(bean)
        bean.className = this.getClass().getSimpleName()
    }
}
