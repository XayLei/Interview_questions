import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner  sc=new Scanner(System.in);
        int n=sc.nextInt(); //���Ӹ���
        int m=sc.nextInt(); //��������
        int[] table= new int[n];  //�������飬ÿ��Ԫ�ش���ÿ�����������ɵ��������
        for(int i=0;i<n;i++){
            table[i] = sc.nextInt();
        }
        Arrays.sort(table);

        PriorityQueue<Customer> pq=new PriorityQueue<Customer>();
        for(int i=0;i<m;i++){
            int person=sc.nextInt();
            int money=sc.nextInt();
            if(person<=table[n-1]){  //������������ӿ�������ʱ�����ͻ��������
                pq.offer(new Customer(person, money));
            }
        }
        long sum=0; //��int�����
        int count=0; //���ڼ��㱻ռ�õ����Ӹ���
        int[] visited = new int[n]; //��table[]һһ��Ӧ,Ĭ��ȫ��0��Ϊ1��ʾ�����Ѿ���ռ��
        for(int i=0;!pq.isEmpty();i++){
            //����Ѷ����еİ�����
            //�����ж��еĶ����ʸ�ԣ�������ǰ�ߵ������ʸ�Ӧ�ð��ţ�
			//���ȶ��еĵײ�ΪС���ѣ�Ϊ�˽����Ϊ�󶥶ѣ�������ǰ��������ѽ��ߵģ�����ʵ��comparable�Ƚ�ʱ��Ҫ������
            //���ŵ�ʱ��ע���ȴ�С���Ӱ��ţ������ٻ�������
            Customer c=pq.poll();
            for(int j=0;j<n;j++){ //��������
                if(table[j] >= c.person && visited[j]==0 ){ //�������²�������û�б�ռ��
                    sum+=c.money;                   
                    visited[j]=1;//j�������п���
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
		ע��һ�¹���PriorityQueueʱ�õ���Comparator���������и��Ƚ�tricky�ĵط���
		��Ϊ���뱾������ʵ��һ���󶥶��������topNС�����⣬
		��PriorityQueue�����ȼ�������Ԫ��ԽС���ȼ�Խ�ߣ��������ǵ������෴��
		���������Ҫ�Զ���PriorityQueue��Comparator����תԪ�ش�С�Ķ��壬
		�������ܱ�֤������λ��Ԫ���ǵ�ǰ���������ġ����ڱȽ���Ԫ�غͶ�����λԪ�صĴ�Сʱ��
		���ǰ���������Ԫ�ش�С�������Ƚϡ�
		*/
        @Override
        public int compareTo(Customer o) { //��Ǯ��С����         
            if(this.money < o.money){
                return 1;
            }else if(this.money > o.money){
                return -1;
            }
            return 0;
        }

    } 
}