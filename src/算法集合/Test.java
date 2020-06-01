package 算法集合;

import java.util.*;

public class Test {

}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 建立收集下标的散列表
        Map<Integer, List<List<Integer>>> map = new HashMap();
        // 返回答案
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;
        Arrays.sort(nums);
        // 建立去重的容器
        Set<List<Integer>> result_set = new TreeSet<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                for (int i = 0; i < o1.size(); i++) {
                    if (!o1.get(i).equals(o2.get(i))) return o1.get(i) - o2.get(i);
                }
                return 0;
            }
        });
        // 将nums的两键相加添加到散列表
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = nums[i] + nums[j];
                // 在这里将结果添加到result
                if (map.containsKey(target - key)) {
                    for (List<Integer> tuple : map.get(target - key)) {
                        // 下标去重
                        if (tuple.get(1) < i) {
                            List<Integer> res = new ArrayList<>();
                            res.add(nums[tuple.get(0)]);
                            res.add(nums[tuple.get(1)]);
                            res.add(nums[i]);
                            res.add(nums[j]);
                            result_set.add(res);
                        }
                    }
                }
                // key若不在散列表则赋予新的空间
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                List<Integer> e = new ArrayList<>(2); // 数组容量为2
                e.add(i);
                e.add(j);
                map.get(key).add(e);
            }
        }
        result.addAll(result_set);
        return result;
    }
}
