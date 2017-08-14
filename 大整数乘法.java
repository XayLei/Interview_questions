import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String num1 = sc.next();
		String num2 = sc.next();
		System.out.println(bignum(num1,num2));
	}
	
	public static String bignum(String num1, String num2){
		num1 = new StringBuilder(num1).reverse().toString();
		num2 = new StringBuilder(num2).reverse().toString();
		int[] d = new int[num1.length()+num2.length()];
		
		for(int i=0; i < num1.length; i++){
			int a = num1.charAt(i) - '0';
			for(int j =0; j<num2.length; j++){
				int b = num2.charAt(j) - '0';
				d[i+j] += a*b;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < d.length; i++){
			int digit = d[i]%10;
			int carry = d[i]/10;
			sb.insert(0,digit);
			if(i<d.length-1){
				d[i+1] += carry;
			}
		}
		
		while(sb.length() > 0 && sb.charAt(0)=='0'){
			sb.deleteCharAt(0);
		}
		
		return sb.length()==0 ? "0" : sb.toString();
	}
}