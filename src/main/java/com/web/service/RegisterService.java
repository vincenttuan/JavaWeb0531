package com.web.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;

public class RegisterService {
    private static Map<Integer, String> timeNames;
    static {
        timeNames = new LinkedHashMap<>();
        timeNames.put(1, "上午");
        timeNames.put(2, "下午");
        timeNames.put(3, "晚上");
        
    }
    
    public List<String> getTimeNamesById(List<Integer> time) {
        if (time.size() == 0) return null;
        // {1, 3} -> {"上午", "晚上"}
        return time.stream()
                .map(t -> timeNames.get(t))
                .collect(toList());
    }
    
}
