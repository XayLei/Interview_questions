import java.util.Scanner;
/*
小易拥有一个拥有魔力的手环上面有n个数字(构成一个环),当这个魔力手环每次使用魔力的时候就会发生一种奇特的变化：
每个数字会变成自己跟后面一个数字的和(最后一个数字的后面一个数字是第一个),
一旦某个位置的数字大于等于100就马上对100取模(比如某个位置变为103,就会自动变为3).
现在给出这个魔力手环的构成，请你计算出使用k次魔力之后魔力手环的状态。 

超时，只通过60%
*/
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        for(int i =0; i<k; i++){
            int temp = arr[0];
            for(int j=0;j<n-1;j++){
                arr[j] += arr[j+1];
                if(arr[j]>=100)
                    arr[j] %= 100;
            }
            arr[n-1] += temp;
            if(arr[n-1]>=100)
                arr[n-1] %= 100;
        }
        
        for(int i =0; i<n; i++){
            System.out.print(arr[i]);
            if(i!=n-1)
                System.out.print(" ");
        }
    }
}

//利用矩阵快速幂
//http://blog.csdn.net/zheng548/article/details/71075163