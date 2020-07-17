package com.jeonhwan.exam.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Letter_Comb_17 {

    public Map<String,String> dial = new HashMap<String,String>(){{
        put("2","abc");
        put("3","def");
        put("4","ghi");
        put("5","jkl");
        put("6","mno");
        put("7","pqrs");
        put("8","tuv");
        put("9","wxyz");
    }};


    private List<String> combinations = new ArrayList<>();
    public List<String> getCombinations() {
        return this.combinations;
    }



    public void backtrack_(String path, String next) {
        // Exit point here
        if (next.isEmpty()) {
            //log.debug(path);
            combinations.add(path);
            return;
        }
        String alphabets =  dial.get(next.substring(0,1));
        // Try possible direction(which is selected alphabets only)
        for (char alphabet  : alphabets.toCharArray()) {
            // 1. sequently concat string
            path = path + alphabet;
            // 2. Call recursively for next digit
            backtrack_(path, next.substring(1));
            // 3. When the end of stack, remove last element
            path = path.substring(0, path.length() -1);
        }
    }

    public List<String> backtrack(String digits) {
        if (digits.length() != 0)
            backtrack_("", digits);
        return combinations;
    }
}
