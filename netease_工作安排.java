import java.util.HashSet;
import java.util.Scanner;

public class Main_01 {
	public static int cases;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			String[] ables = new String[n];
			for (int i = 0; i < n; i++)
				ables[i] = sc.next();

			backtrack(ables, 0, new HashSet<Integer>());

			System.out.println(cases);
		}
		sc.close();
	}

	private static void backtrack(String[] ables, int index, HashSet<Integer> hashSet) {
		if (index >= ables.length) {
			cases++;
			return;
		}

		String able = ables[index];// 第index个工人可以做的工作
		for (int i = 0; i < ables.length; i++) { // 第index个工人依次做自己可以做的工作
			int work = able.charAt(i) - '0';
			if (!hashSet.contains(work)) { // 当work这项工作还没有人做时
				hashSet.add(work);
				backtrack(ables, index + 1, hashSet); // 下一个工人开始挑选工作
				hashSet.remove(work);
			}
		}
	}
}