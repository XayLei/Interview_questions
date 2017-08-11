import java.util.Scanner;

/*
输入描述:
输入数据包括n+1行：
第一行为一个整数n(1 ≤ n ≤ 50),即棋盘的大小
接下来的n行每行一个字符串表示第i行棋盘的颜色，'W'表示白色，'B'表示黑色

输出描述:
输出小易会涂画的区域大小

输入

3
BWW
BBB
BWB
输出

3

其实就是求每一列的相同字符子串的最大长度
*/

public class Main_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] array = new String[n];
		for(int i=0;i<n;i++){
			array[i] = sc.next();
		}
		int maxCellNum = 0;
		for(int i = 0; i<n; i++){
			int temp = 1;
			for(int j=0;j<n-1;j++){
				if(array[j].charAt(i)==array[j+1].charAt(i)){
					temp++;
					maxCellNum = Math.max(temp, maxCellNum);
				}else{
					temp = 1;
				}
			}
		}
		System.out.println(maxCellNum);
	}
}