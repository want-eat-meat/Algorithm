//给定一个非负整数数组，你最初位于数组的第一个位置。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
// 示例:
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//
//
// 说明:
//
// 假设你总是可以到达数组的最后一个位置。
// Related Topics 贪心算法 数组
package 算法集合1_50;

public class _45_跳跃游戏II {
    /**
     * 贪心
     * 2ms
     * 41.7MB
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if(nums.length <= 1){
            return 0;
        }
        //下一次跳最迟位置
        int nextJump = 0;
        //下一次跳的最远距离
        int sumJump = nums[0];
        int step = 0;
        for(int i = 0; i < nums.length; i++){
            sumJump = Math.max(sumJump, i + nums[i]);
            //还没到达跳的位置，下一次跳已经能到终点
            if(sumJump >= nums.length - 1) return step + 1;
            //到达最迟跳的位置时还没到达终点，跳的次数加一
            if(i == nextJump){
                step++;
                nextJump = sumJump;
            }
        }
        return step;
    }
}
