/*
小易有一个长度为n序列，小易想移除掉里面的重复元素，但是小易想是对于每种元素保留最后出现的那个。小易遇到了困难,希望你来帮助他。
*/

import java.util.Scanner;
import java.util.ArrayList;

//利用数组链表

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = sc.nextInt();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = n-1;i>=0;i--){
            if(!list.contains(array[i])){
                list.add(array[i]);
            }
        }
        for(int i=list.size()-1; i>=0; i--){
            System.out.print(list.get(i));
            if(i!=0){
                System.out.print(" ");
            }
        }
    }
}