package 排序;
/**
 * 选择排序
 */
public class ChooseSort implements Sort {
    @Override
    public int[] sort(int[] num) {
        for(int i=0; i<num.length-1; i++){
            int min = num[i];
            int at = i;
            for(int j=i+1; j<num.length; j++){
                if(num[j] < min){
                    min = num[j];
                    at = j;
                }
            }
            num[at] = num[i];
            num[i] = min;
        }
        return num;
    }
}
