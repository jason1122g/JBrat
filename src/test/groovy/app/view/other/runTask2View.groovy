package app.view.other

import org.jbrat.views.JBratView


class runTask2View extends JBratView{
    @Override
    void render(bean) {
        bean?.test?.call(bean)
    }
}
