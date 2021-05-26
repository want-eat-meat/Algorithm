//给定一个未排序的整数数组，找出最长连续序列的长度。
//
// 要求算法的时间复杂度为 O(n)。
//
// 示例:
//
// 输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
// Related Topics 并查集 数组
// 👍 546 👎 0
package 算法集合101_150;

import java.util.HashSet;
import java.util.Set;

/**
 * 哈希表
 * 6ms
 * 39MB
 */
public class _128_最长连续序列 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(Integer num : nums){
            numSet.add(num);
        }
        int result = 0;
        for(Integer num : nums){
            if(!numSet.contains(num - 1)){
                int numNow = num;
                int curSize = 1;
                while(numSet.contains(numNow + 1)){
                    numNow++;
                    curSize++;
                }
                result = Math.max(result, curSize);
            }
        }
        return result;
    }
}
