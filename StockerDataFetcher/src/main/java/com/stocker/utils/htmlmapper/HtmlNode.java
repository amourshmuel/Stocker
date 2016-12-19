package com.stocker.utils.htmlmapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AmourWin7 on 12/19/2016.
 */
public class HtmlNode {

    private List<HtmlAttribute> attributes;

    private List<HtmlNode> children;

    private String text;

    private HtmlNode parent;

    private String name;

    public HtmlNode(String name){

        this.name=name;
        children=new ArrayList<>();
        attributes=new ArrayList<>();
    }

    public HtmlNode (HtmlNode parent, String name){

        this(name);
        this.parent=parent;
    }

    public List<HtmlAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<HtmlAttribute> attributes) {
        this.attributes = attributes;
    }

    public List<HtmlNode> getChildren() {
        return children;
    }

    public void setChildren(List<HtmlNode> children) {
        this.children = children;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public HtmlNode getParent() {
        return parent;
    }

    public void setParent(HtmlNode parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }
}
