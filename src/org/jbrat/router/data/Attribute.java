package org.jbrat.router.data;


import org.jbrat.router.data.abstracts.JAttribute;
import org.jbrat.router.data.abstracts.JViewAttribute;

import java.util.HashMap;
import java.util.Map;

public class Attribute implements JAttribute {
    private Map<String, JViewAttribute> viewMap = new HashMap<String, JViewAttribute>();

    @Override
    public void setViewAttribute(String name,JViewAttribute viewAttribute){
        viewMap.put(name,viewAttribute);
    }
    @Override
    public JViewAttribute getViewAttribute(String name){
        return viewMap.get(name);
    }
}
