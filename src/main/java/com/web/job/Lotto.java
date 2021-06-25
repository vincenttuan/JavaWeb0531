package com.web.job;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Lotto {
    public Set<Integer> get539() {
        Set<Integer> nums = new LinkedHashSet<>();
        while (nums.size() < 5) {            
            nums.add(new Random().nextInt(39) + 1);
        }
        return nums;
    }
}
