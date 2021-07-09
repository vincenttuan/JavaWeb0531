package com.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/*
Tag:
  <my:welcome username="John">
     現在時刻：<%=new Date() >
  </my:welcome>
OUTPUT:
  歡迎 John 的光臨
  現在時刻：2021/7/9 18:46:25
*/
public class WelcomeTag implements Tag {
    private PageContext pageContext ;
    private Tag parentTag;
    private String username; // 自訂屬性
    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag t) {
        parentTag = t;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    @Override
    public int doStartTag() throws JspException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int doEndTag() throws JspException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void release() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
