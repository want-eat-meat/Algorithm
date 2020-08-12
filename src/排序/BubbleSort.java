package 排序;

/**
 * 冒泡排序
 */
public class BubbleSort implements Sort {
    @Override
    public int[] sort(int[] num) {
        for(int i=num.length-1; i>1; i--){
            for(int j=0; j<i; j++){
                if(num[j] > num[j+1]){
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }
        return num;
    }
}
