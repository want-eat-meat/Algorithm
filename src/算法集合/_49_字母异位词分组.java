package 算法集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 11ms
 * 42.7MB
 */
public class _49_字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return null;
        }
        HashMap<String, List> res = new HashMap<>();
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!res.containsKey(key)){
                res.put(key, new ArrayList());
            }
            res.get(key).add(str);
        }
        return new ArrayList(res.values());
    }
}
