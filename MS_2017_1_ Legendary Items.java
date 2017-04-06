/*
https://hihocoder.com/problemset/problem/1489  problem_source

题意：每次完成一个没有legendary item的quest，概率会上升Q%(直到获得legendary item)；完成legendary item的quest，概率重设为P/(2^I)%
反映到图中就是：每个节点的左节点为实心节点（完成legendary item的），右节点为空节点（未完成legendary item）。
每个空节点（假设概率x）的左节点为x+q，实心节点的左节点概率为P/(2^I)% ，（图中每个节点的左右节点之和为100%）
求为了得到n个legendary item，需要多少quest

以上图为例，从上往下看，p为50%，n为2时，最左边一直走，概率分别为：50%，25%（2个legendary item），则停止
将整个树看作n层，从底层开始计算。
下面开始计算：自底向上，从最左的25%节点开始，这一点为0.25*（0+1），此时不需往下走(因为已经拿到2个legendary item)
右节点为1-0.25=0.75（former），向下继续走概率为0.25+q=1（如果小于1，可以往下继续走），则概率为0.75*（0+2）。至此两点之和0.25+0.75*2=1.75
25%的父节点为50%，则50%这一点为0.5*（1.75+1），意思是这一点的子节点加上1个level再乘以0.5就是这一点值
再看另外50%（右节点），former为0.5，继续向下走为0.5*（1.75+2），至此两点之和3.25
*/

public class Main {  
    public static void main(String[] args) {  
        Scanner in = new Scanner(System.in);  
        int p = in.nextInt();  
        int q = in.nextInt();  
        int n = in.nextInt();  
        helper(p, q, n);  
    }  
    public static void helper(int p, int q, int n) {  
        List<Integer> list = new ArrayList<Integer>();  
        list.add(p);  
        double r = 0;  
        for (int i = 1; i < n; i++) {  
            list.add(list.get(i - 1) / 2);  
        }  
        for (int m = n - 1; m >= 0; m--) {  
            int tmp = list.get(m);  
            double one = 0, former = 1;  
            int level = 1;  
            for (int j = tmp; ; j+= q) {  
                if (j > 100) {  
                    j = 100;  
                }  
                one += former * ((double)j / 100)* (r + level) ;  
                former *= (1.0 - (double)j / 100.0);  
    
                level++;  
                if(j == 100) {  
                    break;  
                }  
            }  
            r = one;  
        }  
        System.out.print(r);  
    }  
} 
