/*
小易最近在数学课上学习到了集合的概念,集合有三个特征：1.确定性 2.互异性 3.无序性.
小易的老师给了小易这样一个集合：
S = { p/q | w ≤ p ≤ x, y ≤ q ≤ z }
需要根据给定的w，x，y，z,求出集合中一共有多少个元素。小易才学习了集合还解决不了这个复杂的问题,需要你来帮助他。 
输入描述:

输入包括一行：
一共4个整数分别是w(1 ≤ w ≤ x)，x(1 ≤ x ≤ 100)，y(1 ≤ y ≤ z)，z(1 ≤ z ≤ 100).以空格分隔

输出描述:

输出集合中元素的个数
示例1
输入

1 10 1 1
输出

10
*/

import java.util.Scanner;
import java.util.TreeSet;

public class Main_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt(), x = sc.nextInt();
		int y = sc.nextInt(), z = sc.nextInt();
		TreeSet<Double> set = new TreeSet<>();
		for(int p = w; p<=x;p++){
			for(int q=y; q<=z; q++){
				double f = p*1.0000/q; //分数判重，需要给分子乘1.0000
				set.add(f);
			}
		}
		System.out.println(set.size());
	}
}
