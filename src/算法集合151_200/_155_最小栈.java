//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//
// push(x) —— 将元素 x 推入栈中。
// pop() —— 删除栈顶的元素。
// top() —— 获取栈顶元素。
// getMin() —— 检索栈中的最小元素。
//
//
//
//
// 示例:
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
//
//
//
//
// 提示：
//
//
// pop、top 和 getMin 操作总是在 非空栈 上调用。
//
// Related Topics 栈 设计
package 算法集合151_200;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 4ms
 * 40.1Mb
 */
public class _155_最小栈 {

    private Deque<Integer> myStack;
    private Deque<Integer> minStack;

    public _155_最小栈(){
        myStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        myStack.push(val);

        minStack.push(Math.min(minStack.peek(),val));
    }

    public void pop() {
        myStack.pop();
        minStack.pop();
    }

    public int top() {
        return myStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
