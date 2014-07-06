package app.view

import org.jbrat.core.JBratRouterTest
import org.jbrat.views.JBratView


class orderTestView extends JBratView{
    @Override
    void enter() {
        JBratRouterTest.list1 << "enter"
    }

    @Override
    void beforeRender() {
        JBratRouterTest.list1 << "beforeRender"
    }

    @Override
    void render(bean) {
        JBratRouterTest.list1 << "render"
    }

    @Override
    void afterRender() {
        JBratRouterTest.list1 << "afterRender"
    }

    @Override
    void exit() {
        JBratRouterTest.list1 << "exit"
    }


}
