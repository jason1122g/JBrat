package org.jbrat.controllers

import groovy.transform.CompileStatic
import org.jbrat.core.data.abstracts.Bean

@CompileStatic
public interface Controller {
    void prepare(Bean bean);
}