import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner  sc=new Scanner(System.in);
        int n=sc.nextInt(); //桌子个数
        int m=sc.nextInt(); //客人批数
        int[] table= new int[n];  //桌子数组，每个元素代表每个桌子能容纳的最多人数
        for(int i=0;i<n;i++){
            table[i] = sc.nextInt();
        }
        Arrays.sort(table);

        PriorityQueue<Customer> pq=new PriorityQueue<Customer>();
        for(int i=0;i<m;i++){
            int person=sc.nextInt();
            int money=sc.nextInt();
            if(person<=table[n-1]){  //最大容量的桌子可以坐下时，将客户加入队列
                pq.offer(new Customer(person, money));
            }
        }
        long sum=0; //用int会出错
        int count=0; //用于计算被占用的桌子个数
        int[] visited = new int[n]; //和table[]一一对应,默认全是0，为1表示此桌已经被占用
        for(int i=0;!pq.isEmpty();i++){
            //顶多把队列中的安排完
            //由于列队中的都有资格吃，且排在前边的最有资格，应该安排；
			//优先队列的底层为小顶堆，为了将其变为大顶堆，即排在前面的是消费金额高的，则在实现comparable比较时需要反着来
            //安排的时候注意先从小桌子安排，不行再换大桌子
            Customer c=pq.poll();
            for(int j=0;j<n;j++){ //遍历桌子
                if(table[j] >= c.person && visited[j]==0 ){ //可以坐下并且桌子没有被占用
                    sum+=c.money;                   
                    visited[j]=1;//j号桌已有客人
                    count++;
                    break;
                }
            }
            if(count==n){
                break;
            }
        }       
        System.out.println(sum);
    }
    static class Customer implements Comparable<Customer>{
        int person;
        int money;
        public Customer(){}
        public Customer(int person,int money){
            this.person=person;
            this.money=money;
        }
		
		/*
		注意一下构造PriorityQueue时用到的Comparator，这里面有个比较tricky的地方，
		因为代码本身是想实现一个大顶堆来解决求topN小的问题，
		而PriorityQueue的优先级定义是元素越小优先级越高，这与我们的期望相反，
		因此我们需要自定义PriorityQueue的Comparator，反转元素大小的定义，
		这样就能保证队列首位的元素是当前队列中最大的。而在比较新元素和队列首位元素的大小时，
		则是按照正常的元素大小定义做比较。
		*/
        @Override
        public int compareTo(Customer o) { //按钱大小排序         
            if(this.money < o.money){
                return 1;
            }else if(this.money > o.money){
                return -1;
            }
            return 0;
        }

    } 
}