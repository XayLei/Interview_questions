/*
题目描述
You class are planning for a spring outing. N people are voting for a destination out of K candidate places.
The voting progress is below:
First the class vote for the first candidate place. If more than half of the class agreed on the place, 
the place is selected. The voting ends.
Otherwise they vote for the second candidate place. If more than half of the class agreed on the place,
the place is selected. The voting ends.
Otherwise they vote for the third candidate place in the same way and go on.
If no place is selected at last there will be no spring outing and everybody stays at home.
Before the voting, the Chief Entertainment Officer did a survey, found out every one's preference which can be represented as a 
permutation of 0, 1, ... K. (0 is for staying at home.) For example, when K=3, preference "1, 0, 2, 3" means that the first place 
is his first choice, staying at home is the second choice, the second place is the third choice and the third place is the last choice.
The Chief Entertainment Officer sends the survey results to the class. So everybody knows the others' preferences.
Everybody wants his more prefered place to be selected. And they are very smart, they always choose the optimal strategy
in the voting progress to achieve his goal.
Can you predict which place will be selected?

输入描述:
The first line contains two integers, N and K, the number of people in your class and the number of candidate places.
The next N lines each contain a permutation of 0~K, representing someone's preference.
For 40% of the data, 1 <= N, K <= 10
For 100% of the data, 1 <= N, K <= 1000


输出描述:
Output the selected place. Or "otaku" without quotes if no place is selected.

In the sample case, if the second peoson vote against the first place, no place would be selected finally because the 
first person must vote against the second place for his own interest. Considering staying at home is a worse choice than
the first place, the second person's optimal strategy is voting for the first place. So the first place will be selected

输入例子:
2 2
1 0 2
2 1 0

输出例子:
1
*/

import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
      //handle the input
      BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
      String str = stdin.readLine();
      while(str != null && str.length() > 0){
          String[] ss = str.split(" ");
          int N = Integer.parseInt(ss[0]);
          int K = Integer.parseInt(ss[1]);
          int[][] favor = new int[N][K+1];
          for(int i=0; i<N; i++){
             str = stdin.readLine();
             ss = str.split(" ");
             //favor[i][j]表示第i個人对第j个景点的喜欢程度，值越小表示越喜欢
             for(int j =0; j<=K; j++){
                 favor[i][Integer.parseInt(ss[j])] = j;
             }
          }
          
          //选出最终目的地
          //定义投票计数和选择两个临时变量
          int vote = 0;
          //将被选地初始化为家
          int finalchoice = 0;
          //遍历每一个目的地，从后往前遍历（就是从最后一列开始，一列一列的向前比较，第一列（家）不用比较）
          for(int j = K; j > 0; j--){
               vote = 0;
               //遍历每一个学生，比较对个目的地的喜爱程度
               for(int i = 0 ; i<N; i++){
                   //如果学生I对地点J的喜爱程度小于地点FINALCHOICE的喜爱程度，则对地点J的投票数加1（favor[i][j]越小，就表示越喜爱）
                   if(favor[i][j] < favor[i][finalchoice]){
                       vote++;
                   }
               }
               //如果地点J的票数超过了总人数的一半，则将地点J更新为被选目的地
               if(vote > N-vote){
                  finalchoice = j;
               }
          }
          
          //最终比较完后，如果被选地是0的话，就输出otaku
          if(finalchoice == 0){
             System.out.println("otaku");
          }else{
             System.out.println(finalchoice);
          }
          
          str = stdin.readLine();
      }
   }
}
