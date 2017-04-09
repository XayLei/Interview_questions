//题目链接：http://exercise.acmcoder.com/online/online_judge_ques?ques_id=4378&konwledgeId=169

import java.util.Scanner;

public class Main{
   static int minLen = Integer.MAX_VALUE;
   
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      String start;
      String end;
      String list;
      String[] words;
      while(sc.hasNext()){
         start = sc.nextLine();
         end = sc.nextLine();
         list = sc.nextLine();
         words = list.split(" ");
         
         minLen = Integer.MAX_VALUE;
         int[] record = new int[words.length];
         
         process(1, start, words, end, record);
         System.out.println(minLen);
      }
      sc.close();
   }
   
   private static void process(int len, String curr, String[] words, String dest, int[] record){
      if(dest.equals(curr)){
         minLen = Math.min(len , minLen);
      }
      
      for(int i=0; i<words.length; i++){
         int currDiffNum = diffNum(curr, words[i]);
         if(record[i] != 1 && currDiffNum == 1){
            record[i] = 1;
            process(len+1, words[i], words, dest, record);
            record[i] = 0;
         }
      }
   }
   
   private static int diffNum(String word1, String word2){
        int num = 0;
        for(int i =0; i < word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                num++;
            }
        }
        return num;
   }
}
