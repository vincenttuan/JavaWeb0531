package com.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/*
Tag:
  1. <my:bmi h="170" w="60" />
  2. <my:bmi h="170" w="60" result="true" />   
OUTPUT:
  1. h=170 w=60 bmi=20.76
  2. h=170 w=60 bmi=20.76 result="正常" (ex:太瘦，太胖...)
*/
public class BMITag implements Tag {
    private PageContext pageContext;
    private Tag parentTag;
    private Double h, w;
    private Boolean result;
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

    public void setH(Double h) {
        this.h = h;
    }

    public void setW(Double w) {
        this.w = w;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    
    @Override
    public int doStartTag() throws JspException {
        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        double bmi = w / Math.pow(h/100, 2);
        try {
            JspWriter out = pageContext.getOut();
            out.print(String.format("h=%.1f w=%.1f bmi=%.2f ", h, w, bmi));
            if(result!=null && result) {
                out.print("result=");
                if(bmi <= 18) {
                    out.print("太瘦");
                } else if(bmi > 23) {
                    out.print("太胖");
                } else {
                    out.print("正常");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
    
    }
    
}
