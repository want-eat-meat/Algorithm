import java.util.*;
public class sort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = {4, 12, 8, 32, 24, 5, 9, 7, 7, 3};
        display(a);
        //冒泡排序
        //bubbleSort(a);
        //选择排序
        //chooseSort(a);
        //归并排序
        //mergeSort(a, 0, a.length-1);
        //插入排序
        //insertSort(a);
        //希尔排序
        //shellSort(a);
        //快速排序
        //quickSort(a, 0, a.length-1);
        //堆排序
        //heapSort(a);
        /*桶排序
        ArrayList<Integer> arr = new ArrayList<>(a.length);
        for(int i : a){
            arr.add(i);
        }
        arr = bucketSort(arr, 4);
        for(int i=0; i<arr.size(); i++)
            a[i] = arr.get(i);
        */
        //基数排序
        //计数排序
        display(a);
    }

    public static void display(int a[]){
        for(int i : a){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }

    /**
     * 冒泡排序
     * @param a
     */
    public static void bubbleSort(int a[]){
        for(int i=a.length-1; i>1; i--){
            for(int j=0; j<i; j++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * @param a
     */
    public static void chooseSort(int a[]){
        for(int i=0; i<a.length-1; i++){
            int min = a[i];
            int at = i;
            for(int j=i+1; j<a.length; j++){
                if(a[j] < min){
                    min = a[j];
                    at = j;
                }
            }
            a[at] = a[i];
            a[i] = min;
        }
    }

    /**
     * 归并排序
     * @param a
     * @param start
     * @param end
     */
    public static void mergeSort(int a[], int start, int end){
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
    private static void merge(int[] a, int start, int end) {
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

    /**
     * 插入排序
     * @param a
     */
    public static void insertSort(int a[]){
        for(int i=1; i<a.length; i++){
            int now = a[i];
            for(int j=i-1; j>=0; j--){
                if(now < a[j]){
                    a[j+1] = a[j];
                    a[j] = now;
                } else{
                   a[j+1] = now;
                   break;
                }
            }

        }
    }

    /**
     * 希尔排序
     * @param a
     */
    public static void shellSort(int a[]){
        int len = a.length;
        int step = len / 2;
        int temp;
        while(step > 0){
            for(int i=step; i<len; i++ ){
                temp = a[i];
                int preNum = i - step;
                while(preNum >0 && a[preNum] > temp){
                    a[preNum+step] = a[preNum];
                    preNum -= step;
                }
                a[preNum+step] = temp;
            }
            step = step/2;
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int a[], int start, int end){
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
    public static int patition(int a[], int start, int end){
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

    /**
     * 堆排序
     */
    public static void heapSort(int a[]){
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
    private static void AdjustHeap(int a[], int heapSize) {
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

    /**
     * 桶排序
     */
    public static ArrayList<Integer> bucketSort(ArrayList<Integer> arr, int bucketSize){
        if(arr==null || arr.size()<2)
            return arr;
        int max = arr.get(0);
        int min = arr.get(0);
        //获取数列中最大和最小的数
        for(int i=0; i<arr.size(); i++){
            if(max < arr.get(i)){
                max = arr.get(i);
            }
            if(min > arr.get(i)){
                min = arr.get(i);
            }
        }
        int bucketCount = (max - min)/bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for(int i=0; i<bucketCount; i++){
            bucketArr.add(new ArrayList<Integer>());
        }
        for(int i=0; i<arr.size(); i++){
            bucketArr.get((arr.get(i) - min)/bucketSize).add(arr.get(i));
        }
        for(int i=0; i<bucketCount; i++){
            if(bucketSize == 1){
                for(int j=0; j<bucketArr.get(i).size(); j++)
                    resultArr.add(bucketArr.get(i).get(j));
            }else{
                if(bucketCount == 1)
                    bucketSize--;
                ArrayList<Integer> temp = bucketSort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++)
                    resultArr.add(temp.get(j));
            }
        }
        return resultArr;
    }

}
