package com.web.service;

public class CalaAreaService {
    
    public double getAreaResult(int type, int r) {
        double area = 0;
        
        switch(type) {
            case 1: // 圓面積
                area = Math.pow(r, 2) * Math.PI;
                break;
            case 2: // 球體積
                area = Math.pow(r, 3) * Math.PI * 4/3;
                break;
            default:
                area = -1;
        }
        
        return area;
    }
}
