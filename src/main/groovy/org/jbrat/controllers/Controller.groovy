package org.jbrat.controllers

import groovy.transform.CompileStatic
import org.jbrat.core.data.abstracts.Bindable

@CompileStatic
public interface Controller {
    void prepare(Bindable bean);
}