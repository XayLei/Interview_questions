import java.util.Scanner;
/*
常规的表达式求值，我们都会根据计算的优先级来计算。比如*的优先级就高于+-。
但是小易所生活的世界的表达式规则很简单，从左往右依次计算即可，而且小易所在的世界没有除法，
意味着表达式中没有/，只有(+, - 和 *)。现在给出一个表达式，需要你帮忙计算出小易所在的世界这个表达式的值为多少 

输入描述:

输入为一行字符串，即一个表达式。其中运算符只有-,+,*。参与计算的数字只有0~9.
保证表达式都是合法的，排列规则如样例所示。


输出描述:

输出一个数，即表达式的值
示例1
输入

3+5*7
输出

56
*/
public class Main_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] nums = s.split("[+|\\-|*]");
		int j = 1;
		int i = nums[0].length();
		int result = Integer.valueOf(nums[0]);
		while (i < s.length() && j<nums.length) {
			if(s.charAt(i)<'0' || s.charAt(i)>'9'){
				if (s.charAt(i) == '+') {
					result += Integer.valueOf(nums[j]);
				} else if (s.charAt(i) == '*') {
					result *= Integer.valueOf(nums[j]);
				} else {
					result -= Integer.valueOf(nums[j]);
				}
				j++;
			}
			i++;
		}
		System.out.println(result);
	}
}