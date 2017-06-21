public class Prime {
	public static int calculateNumber(int Nmax){
		boolean[] isPrime = new boolean[Nmax+1];
		for(int i = 3; i<=Nmax; i+=2){ //循环3以上的所有奇数
			isPrime[i] = true; //将所有大于2小于等于给定数的奇数标为true，即为素数
		}
		isPrime[2] = true; //2也是素数
		
		for(int i=3; i<Math.sqrt(Nmax);i+=2){ 
			if(isPrime[i] == true){ //排除不是素数的奇数
				for(int j =i*i;j<=Nmax;j+=2*i){
					isPrime[j] = false;
				}
			}
		}
		
		int PrimeNum = 0;
		for(int i=1;i<=Nmax;i++){ //统计素数个数
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