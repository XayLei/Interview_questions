/*
����һ�����ڣ���������һ��ĵڼ���
*/

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int year=0,mon=1,day=1,today=0;
		int[] month = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // �������飬���̶�ÿ���µ�����
		
		for (;;) { // ����������  
            System.out.print("�������꣺");  
            year = sc.nextInt();//��ȡ��׼�����������������  
            if (year < 0) { // �ж���������Ƿ���Ч  
                System.out.println("���Ӧ����0�����������룡");  
                continue;  
            } else {  
                break;  
            }  
        }
		
		for (;;) { // ����������  
            System.out.print("�������£�");  
            mon = sc.nextInt();//��ȡ��׼�����������������  
            if (mon < 1 || mon > 12) { // �ж���������Ƿ���Ч  
                System.out.println("�·���Ч�����������룡");  
                continue;  
            } else {  
                break;  
            }  
        }
		
		for(::){
			System.out.println("�������գ�")��
			day = sc.nextInt();
			if(year % 400 == 0 || year % 100 == 0 || year % 4 == 0){ //�ж��Ƿ�������
				month[2] = 29;
			}
			if(day > month[mon]){
				System.out.println("������Ч�����������룡")��
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
				System.out.println("�����Ǹ���ĵ�"+day+"��");
				break��
			}
		}
	}
}