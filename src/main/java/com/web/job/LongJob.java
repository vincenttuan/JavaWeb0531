package com.web.job;

import java.util.Date;

public class LongJob implements Runnable {

    @Override
    public void run() {
        try {
            for(int i=1;i<=10;i++) {
                Thread.sleep(1000);
                System.out.println(i + ". 很長的工作做完了 " + new Date());
            }
        } catch (Exception e) {
        }
        
    }
    
    
}
