package app.view

import org.jbrat.views.JBratView


class renderTestView extends JBratView{
    @Override
    void render(bean) {
        bean.renderTest = bean.var1
    }
}
