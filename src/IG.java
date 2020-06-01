import java.util.*;

public class IG {
    public static void main(String[] args) {
        example1();
    }

    public static void example1(){
        System.out.println("货币选择");
        int[] money = {1, 5, 10, 50, 100};
        int[] number = {5, 2, 2, 3, 5};
        int[] used = {0, 0, 0, 0, 0};
        System.out.println("Please input how much money you should pay:");
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        int count = 0;
        for(int i = money.length-1; i>=0; i--){
            if(sum <= count)
                break;
            for(int j=1; j<=number[i]; j++){
                if(money[i] <= sum-count){
                    count += money[i];
                    used[i]++;
                }else{
                    break;
                }
            }
        }
        for(int i=0; i<money.length; i++)
            System.out.println("使用"+money[i]+"元"+used[i]+"张；");
        System.out.println("共使用"+count+"元");
    }
}
