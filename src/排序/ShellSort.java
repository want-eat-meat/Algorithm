package 排序;

/**
 * 希尔排序
 */
public class ShellSort implements Sort{
    @Override
    public int[] sort(int[] num) {
        int len = num.length;
        int step = len / 2;
        int temp;
        while(step > 0){
            for(int i=step; i<len; i++ ){
                temp = num[i];
                int preNum = i - step;
                while(preNum >0 && num[preNum] > temp){
                    num[preNum+step] = num[preNum];
                    preNum -= step;
                }
                num[preNum+step] = temp;
            }
            step = step/2;
        }
        return num;
    }
}
