package org.jbrat.views

import groovy.transform.CompileStatic
import org.jbrat.core.data.abstracts.Bindable

@CompileStatic
public interface View {
    void enter();
    void beforeRender();
    void render(Bindable bean);
    void afterRender();
    void exit();
}