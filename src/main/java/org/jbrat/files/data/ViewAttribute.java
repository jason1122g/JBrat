package org.jbrat.files.data;



import org.jbrat.files.data.abstracts.JViewAttribute;

public final class ViewAttribute implements JViewAttribute {
    private String viewName="";
    private String viewPackage="";
    private String combinerName="";

    @Override
    public String getName() {
        return viewName;
    }

    @Override
    public String getPackage() {
        return viewPackage;
    }

    @Override
    public String getCombinerName() {
        return combinerName;
    }

    @Override
    public void setName(String viewName) {
        this.viewName = viewName;
    }

    @Override
    public void setPackage(String viewPackage) {
        this.viewPackage = viewPackage;
    }

    @Override
    public void setCombinerName(String combinerName) {
        this.combinerName = combinerName;
    }
}
