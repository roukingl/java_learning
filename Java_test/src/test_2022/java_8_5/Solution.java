package test_2022.java_8_5;

import java.util.HashMap;
import java.util.Map;

class Solution {
    /*
    public boolean isIsomorphic(String s, String t) {
        Set<Character> setS = new HashSet<>();
        Set<Character> setT = new HashSet<>();
        int sSub = 0; // 字符串s的'下标'
        int tSub = 0; // 字符串t的'下标'
        int lenS = s.length();
        int lenT = t.length();
        while (sSub < lenS && tSub < lenT) {
            char chS = s.charAt(sSub);
            char chT = t.charAt(tSub);
            setS.add(chS);
            setT.add(chT);
            if (!setS.contains(chS) && !setT.contains(chT) || setS.contains(chS) && setT.contains(chT)) {
                sSub++;
                tSub++;
            } else {
                return false;
            }
        }
        if (sSub == lenS && tSub == lenT) {
            return true;
        }
        return false;
    }
    */

    /*public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char chS = s.charAt(i);
            char chT = s.charAt(i);
            if (map.containsKey(chS)) {
                if (map.get(chS) != chT) {
                    return false;
                }
            } else {
                map.put(chS, chT);
            }
        }
        return true;
    }*/

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> smt = new HashMap<>();
        Map<Character, Character> tms = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);
            if (smt.containsKey(chS) && smt.get(chS) != chT || tms.containsKey(chT) && tms.get(chT) != chS) {
                return false;
            }
            smt.put(chS, chT);
            tms.put(chT, chS);
        }
        return true;
    }
}








