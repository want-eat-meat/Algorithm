package 排序;

public class QuickSort implements Sort {
    @Override
    public int[] sort(int[] num) {
        quickSort(num, 0, num.length - 1);
        return num;
    }

    /**
     * 快速排序
     */
    private void quickSort(int a[], int start, int end){
        if(a.length<1 || start > end ||start < 0 || end >= a.length)
            return;
        int smallIndex = patition(a, start, end);
        if(smallIndex > start){
            quickSort(a, start, smallIndex-1);
        }
        if(smallIndex < end){
            quickSort(a, smallIndex+1, end);
        }

    }

    /**
     * 快速排序算法
     * @param a
     * @param start
     * @param end
     * @return
     */
    private int patition(int a[], int start, int end){
        int point = start;
        int lastMin =start+1;
        for(int i = start+1; i <= end ; i++){
            if(a[i]<a[point]){
                if(i != lastMin){
                    int temp = a[i];
                    a[i] = a[lastMin];
                    a[lastMin] = temp;
                }
                lastMin++;
            }
        }
        if(lastMin != point+1){
            int temp = a[point];
            a[point] = a[lastMin-1];
            a[lastMin-1] = temp;
            return lastMin-1;
        }
        return point;
    }
}
