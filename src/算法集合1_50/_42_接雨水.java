//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。
//
// 示例:
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6
// Related Topics 栈 数组 双指针
package 算法集合1_50;

import java.util.Stack;

/**
 * 单调栈
 * 3ms
 * 39.9MB
 */
public class _42_接雨水 {
    public static int trap(int[] height) {
        if(height.length < 3){
            return 0;
        }
        int result = 0;
        Stack<Integer> stack= new Stack<>();
        for(int i = 0; i < height.length; i++){
            while(!stack.empty() && height[stack.peek()] < height[i]){
                int curIndex = stack.pop();
                while(!stack.empty() && height[stack.peek()] == height[curIndex]){
                    stack.pop();
                }
                if(!stack.empty()){
                    int top = stack.peek();
                    result += (Math.min(height[top], height[i]) - height[curIndex]) * (i - top - 1);
                }
            }
            stack.push(i);
        }
        return result;
    }
}
