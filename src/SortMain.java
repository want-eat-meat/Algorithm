import 排序.*;

/**
 * 冒泡排序
 * BubbleSort
 * 选择排序
 * ChooseSort
 * 归并排序
 * MergeSort
 * 插入排序
 * InsertSort
 * 希尔排序
 * ShellSort
 * 快速排序
 * QuickSort
 * 堆排序
 * HeapSort
 * 桶排序
 * BucketSort
 * 基数排序
 * 计数排序
 *         */
public class SortMain {
    public static void main(String[] args) {
        int[] num = {4, 12, 8, 32, 24, 5, 9, 7, 7, 3};
        //获取排序类对象
        Sort sort = new BubbleSort();
        //调用排序接口
        int[] result = sort.sort(num);
        for(Integer i : result){
            System.out.print(i + " ");
        }
    }
}
