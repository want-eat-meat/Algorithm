//给出一个区间的集合，请合并所有重叠的区间。
//
// 示例 1:
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2:
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
// Related Topics 排序 数组
package 算法集合51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 9ms
 * 42.9MB
 */
public class _56_合并区间 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2){
            return intervals;
        }
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        result.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] cur = intervals[i];
            int[] peek = result.get(result.size() - 1);
            if(cur[0] > peek[1]){
                result.add(cur);
            }else{
                peek[1] = Math.max(peek[1], cur[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
