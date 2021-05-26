//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
//
// 说明：
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
// 示例 1:
//
// 输入: [2,2,3,2]
//输出: 3
//
//
// 示例 2:
//
// 输入: [0,1,0,1,0,1,99]
//输出: 99
// Related Topics 位运算
// 👍 516 👎 0
package 算法集合101_150;

public class _137_只出现一次的数字II {

    /**
     *位运算
     * 2ms
     * 37.8MB
     */
    public int singleNumber(int[] nums) {
        int numOne = 0;
        int numTwo = 0;
        for(Integer i : nums){
            numOne = ~numTwo & (numOne ^ i);
            numTwo = ~numOne & (numTwo ^ i);
        }
        return numOne;
    }
}
