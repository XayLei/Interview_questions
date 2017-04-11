import java.lang.Scanner;

public class Main{
   public static void main(String[] args){
       //处理数据输入
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       long[][] coins = new int[N][2];
       long sum = 0;
       for(int i =0; i<n; i++){
          int a = sc.nextInt();
          int b = sc.nextInt();
          sum += a+b;
          coins[i][0] = a;
          coins[i][1] = b;
       }
       sc.close();
       
       //平均每个格子的硬币数，记为标准数
       long mean = sum / 2 / n;
       //辅助数组，记录每行每格硬币与标准数的差值
       long[] dif = new long[2];
       //移动需要的时间计数，每移动一个硬币用时1秒
       long count;
       
       //遍历每行格子
       for(int i=0; i<n; i++){
          coins[i][0] += dif[0];
          coins[i][1] += dif[1];
          
          //判断是否需要在A[i]和B[i]之间移动
          int bigIndex = coins[i][0] >= coins[i][1] ? 0 : 1;
          int smallIndex = bigIndex == 0 ? 1 : 0;
          if(coins[i][bigIndex] > mean && coins[i][smallIndex] < mean){
              long abs = Math.min(coins[i][bigIndex]-mean , mean-coins[i][smallIndex]);
              count += abs;
              coins[i][bigIndex] -= abs;
              coins[i][smallIndex] += abs;
          }
          
          //更新差值
          dif[0] = coins[i][0]-mean;
          dif[1] = coins[i][1]-mean;
          count += (Math.abs(dif[0]) + Math.abs(dif[1]));
       }
       System.out.println(count);
   }
}
