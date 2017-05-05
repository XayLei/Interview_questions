/*
  С������һ�첻С��������һ�������Թ�,С����ϣ�����Լ���ʣ������ֵP������������Թ���
  Ϊ���������,��������һ��n*m�ĸ����Թ�,�Թ�ÿ��λ��Ϊ0����1,0�������λ�����ϰ���,
  С���ܴﵽ�������λ��;1����С���ܿ��Դﵽ��λ�á�С���ܳ�ʼ��(0,0)λ��,
  �����Թ��ĳ�����(0,m-1)(��֤������λ�ö���1,���ұ�֤һ������㵽�յ�ɴ��·��),
  С�������Թ���ˮƽ�ƶ�һ����λ������Ҫ����1������ֵ,������һ����λ������Ҫ����3����λ������ֵ,
  �����ƶ�����������ֵ,��С���ܵ�����ֵ����0��ʱ��û�е������,С���ܽ��޷������Թ���
  ������Ҫ�����С���ܼ�����ܷ��ý�ʣ������ֵ�����Թ�(���ﵽ(0,m-1)λ��)��
����������
  
�������n+1��:

��һ��Ϊ��������n,m(3 <= m,n <= 10),P(1 <= P <= 100)

��������n��:

ÿ��m��0����1,�Կո�ָ�

���������
����������Թ�,�����һ������������С��·��,�����ʽ��������ʾ;������������Թ�,�����"Can not escape!"��
�������ݱ�֤��Ψһ

������ӣ�
[0,0],[1,0],[1,1],[2,1],[2,2],[2,3],[1,3],[0,3]
*/

import java.util.Scanner;

public class Main {  
    static int n,m,P;  
    static int map[][] = new int[11][11];  
    static int minPath[][] = new int[2][100]; //�����ĵ㳬����100�� 
    static int path[][] = new int[2][100];  
    static int move[][] = new int[][]{{-1,0,3},{0,1,1},{1,0,0},{0,-1,1}}; //�ֱ�����ϡ��ҡ��¡���
    static int loseEnergy = 0;  //��ʧ������ֵ
    static int minLoseEnergy = Integer.MAX_VALUE; //���·����ʧ������ֵ 
    static int minSteps = 0;  //���·�������ĵ���
    static int steps = 0; //��ʾ·��������steps����
	
	
    public static void dfs(int row,int col,int[][] map){  
        if(row == 0 && col == m - 1 && P >= loseEnergy){  
            if(minLoseEnergy > loseEnergy){  
                minLoseEnergy = loseEnergy;  
                for(int i = 0; i < 2; i++)  
                    for(int j = 0; j < steps; j++)  
                        minPath[i][j] = path[i][j];  
                minSteps = steps;  
            }  
        }
        //����ÿ�������������
        for(int i = 0; i < 4; i++){  
            int newRow = row + move[i][0];  //�µĺ�����
            int newCol = col + move[i][1];  //�µ�������
            //����µ������ڵ�ͼ����Χ�ڣ����Ҵ˵��ֵΪ1����ʧ������ֵС��P
            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && map[newRow][newCol] == 1 && P >= loseEnergy){  
                steps++;  
                path[0][steps] = newRow;  
                path[1][steps] = newCol;  
                map[newRow][newCol] = 0; //���´˵��ֵ�������ѷ��� 
                loseEnergy += move[i][2];  //������ʧ������ֵ
                dfs(newRow,newCol,map);  //dfs�ݹ����
                
                map[newRow][newCol] = 1;  //��ԭ
                steps--;  //��ԭ
                loseEnergy -= move[i][2];  //��ԭ
            }  
        }  
          
    }  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        Scanner cin = new Scanner(System.in);  
        n = cin.nextInt();  
        m = cin.nextInt();  
        P = cin.nextInt();  
        for(int i = 0; i < n; i++)  
            for(int j = 0; j < m; j++){  
                map[i][j] = cin.nextInt();  
            }  
        cin.close();  
        map[0][0] = 0;  //�������Ϊ�ѷ��ʹ�
        dfs(0,0,map);  
        if(minLoseEnergy == Integer.MAX_VALUE)  
            System.out.println("Can not escape!");  
        else{  
            for(int i = 0; i < minSteps; i++){  
                System.out.print("["+ minPath[0][i] +","+ minPath[1][i] +"],");  
            }  
            System.out.print("[0," + (m-1) + "]");  
        }  
    }  
}