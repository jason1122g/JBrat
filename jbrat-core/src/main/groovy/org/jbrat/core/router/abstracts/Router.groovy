package org.jbrat.core.router.abstracts

import groovy.transform.CompileStatic
import org.jbrat.core.data.abstracts.Bean

@CompileStatic
public interface Router {
    Bean route(String path, Bean bean);
}