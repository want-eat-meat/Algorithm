//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
//
//
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。
//
// 示例:
//
// 输入: 3
//输出: [1,3,3,1]
//
//
// 进阶：
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？
// Related Topics 数组
// 👍 168 👎 0
package 算法集合101_150;

import java.util.ArrayList;
import java.util.List;

/**
 * 1ms
 * 37.2MB
 */
public class _119_杨辉三角II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int j = 2; j <= rowIndex + 1; j++) {
            int before = 1;
            for (int i = 2; i <= j; i++) {
                if (i > list.size()) {
                    list.add(1);
                } else {
                    int temp = list.get(i - 1);
                    list.set(i - 1, temp + before);
                    before = temp;
                }
            }
        }
        return list;
    }
}
