import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

/*
输入数据包括三行：

第一行为两个整数n(1 ≤ n ≤ 50)和m(1 ≤ m ≤ 50)。以空格分隔

第二行为n个字符串，表示小易能记住的单词，以空格分隔，每个单词的长度小于等于50。

第三行为m个字符串，系统提供的单词，以空格分隔，每个单词的长度小于等于50。

输出描述:

输出一个整数表示小易能获得的分数

输入
3 4
apple orange strawberry
strawberry orange grapefruit watermelon

输出
136

*/

public class Main_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		TreeSet<String> set = new TreeSet<>();
		LinkedList<String> li = new LinkedList<>();
		for(int i =0; i<n;i++){
			set.add(sc.next());
		}
		for(int i = 0; i<m;i++){
			li.add(sc.next());
		}
		int result = 0;
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()){
			String word = iter.next();
			if(li.contains(word)){
				result += word.length()*word.length();
			}
		}
		System.out.println(result);
	}
}