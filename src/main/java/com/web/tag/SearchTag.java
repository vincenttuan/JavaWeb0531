package com.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;

/*
<my:search key="s">
    she sell sea shell on the sea shore
</my:search>
會將 key 的內容也就是 "s" 會變為 紅字
she sell sea shell on the sea shore
^   ^    ^   ^            ^   ^
紅  紅   紅   紅           紅   紅 
*/
public class SearchTag implements BodyTag {
    private PageContext pageContext;
    private BodyContent bodyContent;
    private Tag parentTag;
    private String key;

    @Override
    public void setBodyContent(BodyContent b) {
        bodyContent = b;
    }

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

    public void setKey(String key) {
        this.key = key;
    }
    
    @Override
    public int doStartTag() throws JspException {
        return BodyTag.EVAL_BODY_BUFFERED;
    }
    
    @Override
    public void doInitBody() throws JspException {
    
    }

    @Override
    public int doAfterBody() throws JspException {
        // 取得標籤內的資料
        String content = bodyContent.getString();
        String html = String.format("<font color='%s'>%s</font>", "red", key);
        String new_content = content.replaceAll(key, html);
        JspWriter out = bodyContent.getEnclosingWriter(); // 重要 !!
        try {
            out.print(new_content);
        } catch (Exception e) {
        }
        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
    
    }
    
}
