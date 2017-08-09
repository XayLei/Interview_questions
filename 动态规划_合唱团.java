import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stu = new int[n+1];
        for(int i=1;i<=n;i++){
            stu[i] = sc.nextInt();
        }
        int k=sc.nextInt();
        int d=sc.nextInt();//k代表需要选取的同学的数量，d代表相邻两同学序号间的最大差值
        
        long[][] fmMax = new long[k+1][n+1];// fmax[k][i]表示 : 当选中了k个学生，并且以第i个学生为结尾，所产生的最大乘积；
        long[][] fmMin = new long[k+1][n+1];// fmin[k][i]表示 : 当选中了k个学生，并且以第i个学生为结尾，所产生的最小乘积；
        
        long res = Integer.MIN_VALUE;
        
        for(int i=1;i<=n;i++){
            fmMax[1][i] = stu[i]; //初始化第一行
            fmMin[1][i] = stu[i];
            for(int j=2;j<=k;j++){
                for(int m=i-1;m>0&&i-m<=d;m--){
                    fmMax[j][i] = Math.max(fmMax[j][i],Math.max(fmMax[j-1][m]*stu[i],fmMin[j-1][m]*stu[i]));
                    fmMin[j][i] = Math.min(fmMin[j][i],Math.min(fmMax[j-1][m]*stu[i],fmMin[j-1][m]*stu[i]));
                }
            }
            res = Math.max(res,fmMax[k][i]);
        }
        System.out.println(res);
    }
}
