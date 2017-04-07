/*
题目描述
亮亮深吸一口气，打开了地图，地图上写着(X:12,Y:?)，这可让亮亮犯了愁，这个问号代表了什么意思呢？
亮亮绞尽脑汁也想不出什么思路，忽然他在地图背面发现了一串数字，数字下面写着一段话“这只是一个1~n的混乱排列，
不用在意第i个值”，亮亮眼前一亮，“这个混乱排列中第i个一定是Y的值！”于是，亮亮开始恢复这个混乱排列。

输入描述:
每组数据第一行一个整数n(0<n≤25)，第二行即现在纸上的数字串


输出描述:
一行n个空格隔开的整数，为小明写下的排列。

输入例子:
4
2413

输出例子:
2 4 1 3
*/
import java.lang.*;

public class Main{
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      while(sc.hasNext()){
         int n = sc.nextInt();
         String s = sc.nextLine();
         
         //设置一个临时变量用于存储小于n的值
         int temp = 0;
         //遍历数字串中的每一个数字
         for(int i=0; i<s.length(); i++){
             temp = temp*0 + s.charAt(i)-'0';
             //如果临时变量小于N,则暂不输出，继续遍历下一个数字
             if(temp <= n){
                continue;
             }
             
             i--;
             System.out.print(temp/10 + " ");
             temp = 0;
         }
         
         System.out.println(temp + " ");
      }
   }
}
