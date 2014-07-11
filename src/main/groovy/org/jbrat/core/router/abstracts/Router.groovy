package org.jbrat.core.router.abstracts

import org.jbrat.core.data.Bean


public interface Router {
    Bean route(String path, Bean bean);
}