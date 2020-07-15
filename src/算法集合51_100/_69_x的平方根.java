//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
// 示例 1:
//
// 输入: 4
//输出: 2
//
//
// 示例 2:
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842...,
//     由于返回类型是整数，小数部分将被舍去。
//
// Related Topics 数学 二分查找
package 算法集合51_100;

public class _69_x的平方根 {
    /**
     * 牛顿法
     * 2ms
     * 36.8MB
     * @param i
     * @return
     */
    public int mySqrt(int i){
        if (i == 0) {
            return 0;
        }

        double C = i, x0 = i;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int)x0;
    }

    /**
     * 直接计算
     * 1ms
     * 36.9MB
     * @param i
     * @return
     */
    /*
    public static int mySqrt(int i) {
        if (i == 0) {
            return 0;
        }
        int ans = (int)Math.exp(0.5 * Math.log(i));
        return (long)(ans + 1) * (ans + 1) <= i ? ans + 1 : ans;
    }
    */
    /**
     * 二分法
     * 2ms
     * 36.9MB
     * @param i
     * @return
     */
    /*
    public static int mySqrt(int i) {
        int start = 1;
        int end = i / 2;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(mid  == i / mid){
                return mid;
            }else if(mid  > i / mid){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start > i / start ? start - 1 : start;
    }
    */
}
