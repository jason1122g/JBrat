package org.jbrat.views


public interface View {
    void enter();
    void beforeRender();
    void render(bean);
    void afterRender();
    void exit();
}