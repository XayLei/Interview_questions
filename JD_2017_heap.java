/*
题目描述
									
小明得到了n个石头，他想把这些石头分成若干堆，每堆至少有一个石头。他把这些石堆排在一条直线上，他希望任意相邻两堆的石头数都不一样。
小明最后的得分为石头数大于等于k的石堆数，问他最多能得多少分。
严格地，小明把n个石头分成了m堆，每堆个数依次为a1，a2.....，am。要求满足：
1、ai≥1（1≤i≤m）
2、ai≠ai+1（1≤i＜m）
3、a1+a2+...+am＝n
小明想知道中大于等于的数最多能有多少个？

输入
输入两个数n, k。
样例输入
5 1
输出
输出最大的得分
样例输出
3
*/


import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int score;
		
		score = n/(2*k+1);
		score *= 2;
		if(n%(2*k+1) >= k)
			score++;
		System.out.println(score);
	}
}

/*
题解：
http://exercise.acmcoder.com/online/online_judge_answer_pdf?ques_id=4410&konwledgeId=41
*/
