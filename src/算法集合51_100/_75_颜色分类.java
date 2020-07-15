//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
// 注意:
//不能使用代码库中的排序函数来解决这道题。
//
// 示例:
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2]
//
// 进阶：
//
//
// 一个直观的解决方案是使用计数排序的两趟扫描算法。
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
// 你能想出一个仅使用常数空间的一趟扫描算法吗？
//
// Related Topics 排序 数组 双指针

package 算法集合51_100;

public class _75_颜色分类 {
    /**
     *三路快排
     * 0ms
     * 38.2MB
     */
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                swap(nums, left++, i--);
            }else if(nums[i] == 1){
                swap(nums, right--, i--);
            }
        }
    }
    /**
     * 双指针
     * 自己的
     * 0ms
     * 38.1MB
     */
    /*
    public void sortColors(int[] nums) {
        int index0 = 0;
        int index1 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if(index0 != i) {
                    swap(nums, index0, i);
                    i--;
                }
                if(index0 == index1){
                    index1++;
                }
                index0++;
            } else if (nums[i] == 1) {
                swap(nums, index1, i);
                index1++;
            }
        }
    }
    */

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

