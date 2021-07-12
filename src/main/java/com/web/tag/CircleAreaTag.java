package com.web.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/*
<my:circleArea r=10 mode=1 /> 計算圓面積
<my:circleArea r=10 mode=2 /> 計算球體積
*/
public class CircleAreaTag extends SimpleTagSupport {
    private double r;
    private int mode = 1;

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        double result = 0.0;
        switch(mode) {
            case 1:
                result = Math.pow(r, 2) * Math.PI;
                break;
            case 2:
                result = 4/3 * (Math.pow(r, 3) * Math.PI);
                break;    
        }
        out.println(String.format("r= %.1f model= %d area= %.2f", r, mode, result));
    }
    
    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }
    
    
}
