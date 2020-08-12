package 排序;
/**
 * 堆排序
 */
public class HeapSort implements Sort {
    @Override
    public int[] sort(int[] num) {
        heapSort(num);
        return num;
    }

    public void heapSort(int a[]){
        int heapSize = a.length-1;
        while(heapSize>0){
            AdjustHeap(a, heapSize);
            int temp = a[0];
            a[0] = a[heapSize];
            a[heapSize] = temp;
            heapSize--;
        }
    }

    /**
     * 调整堆
     * @param a
     * @param heapSize
     */
    private void AdjustHeap(int a[], int heapSize) {
        for(int i=(heapSize-1)/2; i>=0; i--){
            if((i*2+1) <= heapSize){
                if(a[i] < a[i*2+1]){
                    int temp = a[i];
                    a[i] = a[i*2+1];
                    a[i*2+1] = temp;
                }
            }
            if((i*2+2) <= heapSize){
                if(a[i] < a[i*2+2]){
                    int temp = a[i];
                    a[i] = a[i*2+2];
                    a[i*2+2] = temp;
                }
            }
        }
    }
}
