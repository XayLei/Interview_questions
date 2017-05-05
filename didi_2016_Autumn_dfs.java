/*
  小青蛙有一天不小心落入了一个地下迷宫,小青蛙希望用自己仅剩的体力值P跳出这个地下迷宫。
  为了让问题简单,假设这是一个n*m的格子迷宫,迷宫每个位置为0或者1,0代表这个位置有障碍物,
  小青蛙达到不了这个位置;1代表小青蛙可以达到的位置。小青蛙初始在(0,0)位置,
  地下迷宫的出口在(0,m-1)(保证这两个位置都是1,并且保证一定有起点到终点可达的路径),
  小青蛙在迷宫中水平移动一个单位距离需要消耗1点体力值,向上爬一个单位距离需要消耗3个单位的体力值,
  向下移动不消耗体力值,当小青蛙的体力值等于0的时候还没有到达出口,小青蛙将无法逃离迷宫。
  现在需要你帮助小青蛙计算出能否用仅剩的体力值跳出迷宫(即达到(0,m-1)位置)。
输入描述：
  
输入包括n+1行:

第一行为三个整数n,m(3 <= m,n <= 10),P(1 <= P <= 100)

接下来的n行:

每行m个0或者1,以空格分隔

输出描述：
如果能逃离迷宫,则输出一行体力消耗最小的路径,输出格式见样例所示;如果不能逃离迷宫,则输出"Can not escape!"。
测试数据保证答案唯一

输出例子：
[0,0],[1,0],[1,1],[2,1],[2,2],[2,3],[1,3],[0,3]
*/

import java.util.Scanner;

public class Main {  
    static int n,m,P;  
    static int map[][] = new int[11][11];  
    static int minPath[][] = new int[2][100]; //经过的点超不过100个 
    static int path[][] = new int[2][100];  
    static int move[][] = new int[][]{{-1,0,3},{0,1,1},{1,0,0},{0,-1,1}}; //分别代表上、右、下、左
    static int loseEnergy = 0;  //损失的体力值
    static int minLoseEnergy = Integer.MAX_VALUE; //最短路径损失的体力值 
    static int minSteps = 0;  //最短路径经过的点数
    static int steps = 0; //表示路径经过了steps个点
	
	
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
        //遍历每个点的上下左右
        for(int i = 0; i < 4; i++){  
            int newRow = row + move[i][0];  //新的横坐标
            int newCol = col + move[i][1];  //新的纵坐标
            //如果新的坐标在地图矩阵范围内，并且此点的值为1，损失的体力值小于P
            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && map[newRow][newCol] == 1 && P >= loseEnergy){  
                steps++;  
                path[0][steps] = newRow;  
                path[1][steps] = newCol;  
                map[newRow][newCol] = 0; //更新此点的值，代表已访问 
                loseEnergy += move[i][2];  //更新损失的体力值
                dfs(newRow,newCol,map);  //dfs递归遍历
                
                map[newRow][newCol] = 1;  //还原
                steps--;  //还原
                loseEnergy -= move[i][2];  //还原
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
        map[0][0] = 0;  //将起点标记为已访问过
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