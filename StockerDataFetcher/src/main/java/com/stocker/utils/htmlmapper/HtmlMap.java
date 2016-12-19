package com.stocker.utils.htmlmapper;

import org.apache.commons.lang.StringEscapeUtils;

import java.util.Stack;

/**
 * Created by AmourWin7 on 12/19/2016.
 */
public class HtmlMap {

    private HtmlNode root;

    public HtmlNode getRoot() {
        return root;
    }

    public void initFromText(String htmlText){

        Stack stack=new Stack();
        root=new HtmlNode("html");
        stack.push(root);
        char[] chars = htmlText.toCharArray();
        Integer textLength = chars.length;

        HtmlNode currentNode=root;

        Boolean inElementHead=true;
        Boolean inElement=true;

        Integer i =htmlText.indexOf("<html")+"<html".length();

        for (; i<textLength;i++){

            if(chars[i]=='<'){
                if(chars[i+1]=='/'){
                    //Close Element
                    i++;
                    i++;
                    String endNodeName="";
                    for (; i<textLength;i++){
                        if(chars[i]=='>'){
                            while (true) {
                                currentNode = (HtmlNode) stack.pop();
                                if (currentNode.getName().equalsIgnoreCase( endNodeName)) {
                                    break;
                                }
                            }
                            break;
                        }
                        else{
                            endNodeName+=chars[i];
                        }
                    }
                    currentNode=currentNode.getParent();
                    inElement=false;
                }else if(chars[i+1]=='!') {
                    //Comment
                    for (; i<textLength;i++){
                        if(chars[i]=='-' &&chars[i+1]=='-'&&chars[i+2]=='>'){
                           // currentNode=currentNode.getParent();
                            break;
                        }
                    }
                    i++;
                    i++;
                } else{
                    //New element
                    Integer pos=i+1;
                    String elemetType=getElementType(chars, pos);
                    HtmlNode newNode = new HtmlNode(currentNode,elemetType);
                    currentNode.getChildren().add(newNode);
                    stack.push(newNode);
                    currentNode= newNode;
                    i=pos+elemetType.length()-1;
                    inElementHead=true;
                    inElement=false;
                }

            }
            else if(chars[i]=='/' && chars[i+1]=='>'){
                i++;
                currentNode= (HtmlNode) stack.pop();
                currentNode=currentNode.getParent();
                inElement=false;
            }
            else if(chars[i]=='>'){
                inElementHead=false;
                inElement=true;
            }
            else if(chars[i]==' ' && inElementHead){
                i=getNodeAttributes(currentNode,chars,i);
                inElementHead=false;
            }
            else if(inElement){
                i=getNodeText(currentNode,chars,i)-1;
            }
        }
    }

    private Integer getNodeText(HtmlNode currentNode, char[] chars, Integer pos) {

        Integer poss=pos;
        String text="";
        for (;poss<chars.length;poss++) {
            if (chars[poss] == '<') {
                currentNode.setText(StringEscapeUtils.unescapeHtml(text.trim()));
                break;
            } else {
                text+=chars[poss];
            }
        }
        return poss;
    }

    private Integer getNodeAttributes(HtmlNode currentNode, char[] chars, Integer pos) {
        Integer poss = pos;
        String attributeName = "";
        String attributeValue = "";
        Boolean collectAttributeName = false;
//        Boolean collectAttributeValue = false;
        HtmlAttribute currentAttribute = new HtmlAttribute();
        for (; poss < chars.length; poss++) {
            if (chars[poss] == '>'  || (chars[poss] == '/' && chars[poss + 1] == '>')) {
                break;
            } else if (collectAttributeName) {
                if (chars[poss] == '=') {
                    currentAttribute.setAttributeName(attributeName.trim());
                    poss++;
                    collectAttributeName = false;
//                    collectAttributeValue = true;
                    for (; poss < chars.length; poss++) {
                        if (chars[poss] != ' ') {
                            break;
                        }
                    }
                    attributeValue = "";
                    Boolean betweenQuotationMark = false;
                    if (chars[poss] == '"') {
                        betweenQuotationMark = true;
                        attributeValue += chars[poss];
                        poss++;
                    }
                    for (; poss < chars.length; poss++) {
                        if ((betweenQuotationMark && chars[poss] == '"') ||
                                (!betweenQuotationMark && chars[poss] == ' ') ||
                                (chars[poss] == '/' && chars[poss + 1] == '>') ||
                                chars[poss] == '>') {
                            break;
                        } else {
                            attributeValue += chars[poss];
                        }
                    }
                    attributeValue = attributeValue.trim();
                    if (betweenQuotationMark) {
                        attributeValue = attributeValue.substring(1, attributeValue.length());
                    }
                    currentAttribute.setAttributeValue(attributeValue);
                    collectAttributeName = false;
                    currentNode.getAttributes().add(currentAttribute);
                    if (chars[poss] == '/' || chars[poss] == '>') {
                        poss--;
                    } else if (chars[poss] == ' ') {
                        poss--;
                    }
                } else {
                    attributeName += chars[poss];
                }
            } /*else if (collectAttributeValue) {
                if (chars[poss] == '"') {
                    attributeValue = attributeValue.trim();
                    currentAttribute.setAttributeValue(attributeValue);
                    collectAttributeName = false;
                    collectAttributeValue = false;
                    currentNode.getAttributes().add(currentAttribute);
                    if (chars[poss] == '/' || chars[poss] == '>') {
                        poss--;
                    }
                } else {
                    attributeValue += chars[poss];
                }
            }*/ else if (chars[poss] == ' ') {
                collectAttributeName = true;
                attributeName = "";
                currentAttribute = new HtmlAttribute();
            }
        }
        return poss;
    }

    private String getElementType(char[] chars, Integer pos) {
        String nodeType ="";
        for (;pos<chars.length;pos++){
            nodeType+=chars[pos];
            if(chars[pos+1]==' ' || chars[pos+1]=='/' || chars[pos+1]=='>'){
                break;
            }
        }
        return nodeType;
    }
}
