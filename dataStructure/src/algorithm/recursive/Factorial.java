package algorithm.recursive;

import java.util.ArrayList;

public class Factorial {

	// 시간 / 공간 복잡도 O(n)
	// 방법 1
	public int factorialFunc1(int n) {
		if(n > 1) {
			return n * this.factorialFunc1(n-1);
		}else {
			return 1;
		}
	}
	
	// 시간 / 공간 복잡도 O(n)
	// 방법 2
	public int factorialFunc2(int n) {
		if(n <= 1) {
			return 1;
		}else {
			return n * this.factorialFunc2(n-1);
		}
	}
	
	// 시간 / 공간 복잡도 O(n)
	// 방법 3
	public int factorialFunc3(ArrayList<Integer> dataList) {
		if(dataList.size() <= 0) {
			return 1;
		}else {
			return dataList.get(0) * this.factorialFunc3(new ArrayList<Integer>(dataList.subList(1, dataList.size())));
		}
	}
	
	public static void main(String[] args) {
		Factorial f = new Factorial();
		ArrayList<Integer> test = new ArrayList<Integer>();
		for(int i = 1; i < 6; i++) {
			test.add(i);
		}
		System.out.println(f.factorialFunc1(5));
		System.out.println(f.factorialFunc2(5));
		System.out.println(f.factorialFunc3(test));
	}

}
