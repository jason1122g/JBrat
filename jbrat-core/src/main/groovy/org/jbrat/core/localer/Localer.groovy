package org.jbrat.core.localer

import groovy.transform.CompileStatic

@CompileStatic
public interface Localer {
    String localeText(String name);
}