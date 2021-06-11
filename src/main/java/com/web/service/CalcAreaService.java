package com.web.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CalcAreaService {
    
    private static Map<Integer, String> types;
    static {
        types = new LinkedHashMap<>();
        types.put(1, "圓面積");
        types.put(2, "球體積");
    }
    
    public String getNameByType(int type) {
        return types.get(type);
    }
    
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

    
    public List<Map> getAreaResults(String[] types, String[] rs) {
        // [{r=10, area=314, name="圓面積"}, ...]
        List<Map> list = new ArrayList<>();
        for(int i=0;i<types.length;i++) {
            if (rs[i] == null || rs[i].equals("")) {
                rs[i] = "0";
            }
            int type    = Integer.parseInt(types[i]);
            int r       = Integer.parseInt(rs[i]);
            String name = getNameByType(type);
            double result = getAreaResult(type, r);
            Map map = new LinkedHashMap();
            map.put("r", r);
            map.put("result", result);
            map.put("name", name);
            list.add(map);
        }
        return list;
    }
}
