package org.jbrat.views

import groovy.transform.CompileStatic
import org.jbrat.core.data.Bean

@CompileStatic
public interface View {
    void enter();
    void beforeRender();
    void render(Bean bean);
    void afterRender();
    void exit();
}