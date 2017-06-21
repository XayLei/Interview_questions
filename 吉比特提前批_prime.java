public class Prime {
	public static int calculateNumber(int Nmax){
		boolean[] isPrime = new boolean[Nmax+1];
		for(int i = 3; i<=Nmax; i+=2){ //ѭ��3���ϵ���������
			isPrime[i] = true; //�����д���2С�ڵ��ڸ�������������Ϊtrue����Ϊ����
		}
		isPrime[2] = true; //2Ҳ������
		
		for(int i=3; i<Math.sqrt(Nmax);i+=2){ 
			if(isPrime[i] == true){ //�ų���������������
				for(int j =i*i;j<=Nmax;j+=2*i){
					isPrime[j] = false;
				}
			}
		}
		
		int PrimeNum = 0;
		for(int i=1;i<=Nmax;i++){ //ͳ����������
			if(isPrime[i]==true){
				PrimeNum++;
			}
		}
		return PrimeNum;
	}
	
	public static void main(String[] args) {
		final int num = 100000000;
		double startTime = System.currentTimeMillis();
		int primeNum = Prime.calculateNumber(num);
		double spentTime = (System.currentTimeMillis()-startTime)/1000;
		System.out.println(primeNum + " spentTime = " + spentTime);
	}
}