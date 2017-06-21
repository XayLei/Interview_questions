/*
输入一个日期，计算是这一年的第几天
*/

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int year=0,mon=1,day=1,today=0;
		int[] month = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 定义数组，并固定每个月的天数
		
		for (;;) { // 进行输入年  
            System.out.print("请输入年：");  
            year = sc.nextInt();//读取标准输入流不输入的数据  
            if (year < 0) { // 判断输入年份是否有效  
                System.out.println("年份应大于0，请重新输入！");  
                continue;  
            } else {  
                break;  
            }  
        }
		
		for (;;) { // 进行输入月  
            System.out.print("请输入月：");  
            mon = sc.nextInt();//读取标准输入流不输入的数据  
            if (mon < 1 || mon > 12) { // 判断输入年份是否有效  
                System.out.println("月份无效，请重新输入！");  
                continue;  
            } else {  
                break;  
            }  
        }
		
		for(::){
			System.out.println("请输入日：")；
			day = sc.nextInt();
			if(year % 400 == 0 || year % 100 == 0 || year % 4 == 0){ //判断是否是润年
				month[2] = 29;
			}
			if(day > month[mon]){
				System.out.println("日期无效，请重新输入！")；
				continue;
			}else{
				if(mon == 1){
					today = day;
				}else{
					for(int i =0;i<mon;i++){
						today += a[i];
					}
					today += day;
				}
				System.out.println("该天是该年的第"+day+"天");
				break；
			}
		}
	}
}