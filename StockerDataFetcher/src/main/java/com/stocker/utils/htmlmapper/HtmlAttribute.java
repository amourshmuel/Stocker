package com.stocker.utils.htmlmapper;

/**
 * Created by AmourWin7 on 12/19/2016.
 */
public class HtmlAttribute {

    private  String attributeName;
    private String attributeValue;

    public HtmlAttribute() {
    }

    public HtmlAttribute(String attributeName, String attributeValue) {
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }
}
