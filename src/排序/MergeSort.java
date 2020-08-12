package 排序;

public class MergeSort implements Sort {
    @Override
    public int[] sort(int[] num) {
        mergeSort(num, 0, num.length - 1);
        return num;
    }
    /**
     * 归并排序
     * @param a
     * @param start
     * @param end
     */
    private void mergeSort(int a[], int start, int end){
        if(start == end)
            return;
        int mid = (start + end)/2;
        mergeSort(a,start, mid);
        mergeSort(a, mid+1, end);
        merge(a, start, end);

    }

    /**
     * 归并排序算法
     * @param a
     * @param start
     * @param end
     */
    private void merge(int[] a, int start, int end) {
        int i = start;
        int mid = (start+end)/2 +1;
        int j = mid;
        int k =0;
        int[] b = new int[end-start+1];
        while(i < mid && j <= end){
            if ((a[i] > a[j])) {
                b[k++] = a[j++];
            } else {
                b[k++] = a[i++];
            }
        }

        while(i<mid) {
            b[k++] = a[i++];
        }
        while(j<=end) {
            b[k++] = a[j++];
        }
        for(int m=0; m<k; m++){
            a[start++] = b[m];
        }
    }
}
