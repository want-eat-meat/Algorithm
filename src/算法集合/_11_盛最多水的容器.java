package 算法集合;
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。
//
//
//
//
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
//
//
// 示例：
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49
// Related Topics 数组 双指针
public class _11_盛最多水的容器 {
    /**
     *双指针
     * 3ms
     * 40MB
     */
    public int maxArea(int[] height) {
        if(height.length < 2){return 0;}
        int start = 0;
        int end = height.length -1;
        int result = 0;
        while(end != start){
            int i = 1;
            result = Math.min(height[start], height[end]) * (end - start) > result ?
                    Math.min(height[start], height[end]) * (end - start):
                    result;
            System.out.println( start + " " + end + " " + result);
            if(height[start] < height[end]){
                while(start + i < end && height[start + i] < height[start]){
                    i++;
                }
                start += i;
            }else{
                while(end - i > start && height[end - i] < height[end]) {
                    i++;
                }
                end -= i;
            }
        }
        return result;
    }
    /**
     * 粗暴的解法
     * 466ms
     * 40.3MB
     * @param height
     * @return
     */
   /* public int maxArea(int[] height) {
        if(height.length < 2){return 0;}
        int result = 0;
        int maxLen = 0;
        int min = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = height.length - 1; j > i; j-- ){
                min = Math.min(height[i], height[j]);
                if(min > maxLen) {
                    if (min * (j - i) > result) {
                        maxLen = min;
                        result = min * (j - i);
                    }
                }
            }
        }
        return result;
    }
    */
}
