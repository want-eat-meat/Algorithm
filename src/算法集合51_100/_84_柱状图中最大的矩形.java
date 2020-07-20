//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//
//
//
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
//
//
//
//
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
//
//
//
// 示例:
//
// 输入: [2,1,5,6,2,3]
//输出: 10
// Related Topics 栈 数组
package 算法集合51_100;

import java.util.Stack;

/**
 * 单调栈
 * 14ms
 * 40.8MB
 */
public class _84_柱状图中最大的矩形 {

    public int largestRectangleArea(int[] heights) {
        int result = 0;
        int len = heights.length;
        if(len == 0) return result;
        Stack<Integer> stack= new Stack<>();
        for(int i = 0; i < len; i++){
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                int preIndex = stack.peek();
                //不满足单调增
                if(heights[preIndex] > heights[i]){
                    while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                        int index = stack.pop();
                        int area;
                        if (stack.isEmpty()) {
                            area = heights[index] * i;
                        } else {
                            area = heights[index] * (i - stack.peek() - 1);
                        }
                        result = area > result ? area : result;
                    }
                    stack.push(i);
                }else{
                    stack.push(i);
                }
            }
        }
        while(!stack.isEmpty()){
            int index = stack.pop();
            int area;
            if(stack.isEmpty()){
                area = heights[index] * (len);
            }else{
                area = heights[index] * (len - 1 -stack.peek());
            }
            result = area > result ? area : result;
        }
        return result;
    }
}
