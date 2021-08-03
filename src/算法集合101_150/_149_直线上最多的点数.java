//给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
//
//
//
// 示例 1：
//
//
//输入：points = [[1,1],[2,2],[3,3]]
//输出：3
//
//
// 示例 2：
//
//
//输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出：4
//
//
//
//
// 提示：
//
//
// 1 <= points.length <= 300
// points[i].length == 2
// -104 <= xi, yi <= 104
// points 中的所有点 互不相同
//
// Related Topics 几何 哈希表 数学
package 算法集合101_150;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表
 * 9ms
 * 37.8Mb
 */
public class _149_直线上最多的点数 {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n <= 2) return n;

        int result = 0;

        for(int i = 0; i < n - 1; i++){
            Map<Integer, Integer> kMap = new HashMap<>();
            for(int j = i + 1; j < n; j++){
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if(y == 0){
                    x = 1;
                }else if(x == 0){
                    y = 1;
                }else{
                    if(y < 0){
                        x = -x;
                        y = -y;
                    }
                    int gbs = gbs(x, y);
                    x /= gbs;
                    y /= gbs;
                }
                int k = y + 20001 * x;
                kMap.put(k, kMap.getOrDefault(k, 0) + 1);
            }
            int maxNum = 0;
            for(Map.Entry<Integer, Integer> ertry : kMap.entrySet()){
                maxNum = Math.max(maxNum,ertry.getValue());
            }
            result = Math.max(maxNum, result);
        }
        return result;
    }

    private int gbs(int x, int y) {
        return y == 0 ? x : gbs(y, x % y);
    }
}
