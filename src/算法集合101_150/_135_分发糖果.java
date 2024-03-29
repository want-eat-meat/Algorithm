//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果：
//
//
// 每个孩子至少分配到 1 个糖果。
// 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
//
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？
//
//
//
// 示例 1：
//
//
//输入：[1,0,2]
//输出：5
//解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
//
//
// 示例 2：
//
//
//输入：[1,2,2]
//输出：4
//解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
// Related Topics 贪心算法
package 算法集合101_150;

/**
 *两次循环
 * 2ms
 * 40Mb
 */
public class _135_分发糖果 {
    public int candy(int[] ratings) {
        int result = 0;
        int len = ratings.length;
        if(len == 0){
            return len;
        }
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        right[len - 1] = 1;
        for(int i = 1; i < len; i++){
                left[i] = ratings[i] > ratings[i - 1] ? left[i - 1] + 1 : 1;
        }
        for(int i = len - 2; i >= 0; i--){
                right[i] = ratings[i] > ratings[i + 1] ? right[i + 1] + 1 : 1;
        }

        for(int i = 0; i < len; i++){
            result += Math.max(left[i], right[i]);
        }
        return result;
    }
}
