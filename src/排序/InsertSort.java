package 排序;

/**
 * 插入排序
 */
public class InsertSort implements Sort {
    @Override
    public int[] sort(int[] num) {
        for(int i=1; i<num.length; i++){
            int now = num[i];
            for(int j=i-1; j>=0; j--){
                if(now < num[j]){
                    num[j+1] = num[j];
                    num[j] = now;
                } else{
                    num[j+1] = now;
                    break;
                }
            }
        }
        return num;
    }
}
