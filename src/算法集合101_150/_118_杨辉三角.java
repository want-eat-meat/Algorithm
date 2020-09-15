//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//
//
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。
//
// 示例:
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
// Related Topics 数组
// 👍 337 👎 0

package 算法集合101_150;

import java.util.ArrayList;
import java.util.List;

/**
 * 1ms
 * 37MB
 */
public class _118_杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int j = 1; j <= numRows; j++) {
            int before = 0;
            for (int i = 1; i <= j; i++) {
                //第一个
                if (list.size() == 0) {
                    list.add(1);
                } else {
                    if (i > list.size()) {
                        list.add(1);
                    } else {
                        int temp = list.get(i - 1);
                        list.set(i - 1, temp + before);
                        before = temp;
                    }
                }
            }
            result.add(new ArrayList<>(list));
        }
        return result;
    }
}
