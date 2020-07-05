//给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
//
//
// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
//
//
// 给定 n 和 k，返回第 k 个排列。
//
// 说明：
//
//
// 给定 n 的范围是 [1, 9]。
// 给定 k 的范围是[1, n!]。
//
//
// 示例 1:
//
// 输入: n = 3, k = 3
//输出: "213"
//
//
// 示例 2:
//
// 输入: n = 4, k = 9
//输出: "2314"
//
// Related Topics 数学 回溯算法
package 算法集合51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 2ms
 * 37.5MB
 */
public class _60_第k个排列 {
    public static void main(String[] args) {
        getPermutation(1, 1);
    }
    public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder(n);
        if(n == 1 && k == 1) return String.valueOf(n);
        int[] product  = new int[n + 1];
        List<Integer> nums = new ArrayList<>(n);
        for(int i = 0; i < n; i++) nums.add(i + 1);
        product[1] = 1;
        for(int i = 2; i <= n; i++) product[i] = product[i - 1] * i;

        int mol = n - 1;
        while(k > 0 && !nums.isEmpty()){
            for(int i = mol; i > 0; i--){
                System.out.println(k + "-" + product[i]);
                if(!nums.isEmpty()) {
                    int index = (k - 1) / product[i];
                    sb.append(nums.get(index));
                    nums.remove(index);
                    k -= index * product[i];
                }
            }
        }
        return sb.toString();
    }
}
