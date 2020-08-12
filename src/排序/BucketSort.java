package 排序;

import java.util.ArrayList;
import java.util.List;

public class BucketSort implements Sort {
    @Override
    public int[] sort(int[] num) {
        List<Integer> arr = new ArrayList<>(num.length);
        for(Integer i : num){
            arr.add(i);
        }
        bucketSort(arr, 4);
        num = arr.stream().mapToInt(Integer::valueOf).toArray();
        return num;
    }

    /**
     * 桶排序
     */
    private List<Integer> bucketSort(List<Integer> arr, int bucketSize){
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
        List<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        List<Integer> resultArr = new ArrayList<>();
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
                List<Integer> temp = bucketSort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++)
                    resultArr.add(temp.get(j));
            }
        }
        return resultArr;
    }
}
