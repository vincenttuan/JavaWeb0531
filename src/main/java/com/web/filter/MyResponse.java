package com.web.filter;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyResponse extends HttpServletResponseWrapper {
    private PrintWriter out;
    private CharArrayWriter bufferedWriter;
    public MyResponse(HttpServletResponse response) {
        super(response);
        bufferedWriter = new CharArrayWriter();
        out = new PrintWriter(bufferedWriter);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return out;
    }
    
    public String getHTMLString() {
        return bufferedWriter.toString();
    }
    
}
