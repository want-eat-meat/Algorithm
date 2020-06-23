//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
// 示例:
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// Related Topics 回溯算法
package 算法集合1_50;

import java.util.*;

public class _47_全排列II {
    /**
     * 17ms
     * 40.4MB
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> baseMap= new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            addMap(baseMap, nums[i]);
        }
        permuteUnique(result, nums, 0, new ArrayList<>(), new HashMap<>(), baseMap);
        System.out.println(result);
        return result;
    }



    private void permuteUnique(List<List<Integer>> result, int[] nums, int now, ArrayList<Integer> list, HashMap<Integer, Integer> map, HashMap<Integer, Integer> baseMap) {
        if(now == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(i - 1 >= 0 && nums[i] == nums[i - 1]){
                continue;
            }
            if(!(map.containsKey(nums[i]) && map.get(nums[i]).equals(baseMap.get(nums[i])))){
                addMap(map, nums[i]);
                list.add(nums[i]);
                permuteUnique(result, nums, now + 1, list, map, baseMap);
                list.remove(list.size() - 1);
                removeMap(map, nums[i]);
            }
        }
    }

    private void removeMap(HashMap<Integer, Integer> map, int num) {
        if(map.get(num) == 1){
            map.remove(num);
        }else{
            map.replace(num, map.get(num) - 1);
        }
    }

    private void addMap(HashMap<Integer, Integer> baseMap, int num) {
        if(baseMap.containsKey(num)){
            baseMap.replace(num, baseMap.get(num) + 1);
        }else{
            baseMap.put(num, 1);
        }
    }
}
