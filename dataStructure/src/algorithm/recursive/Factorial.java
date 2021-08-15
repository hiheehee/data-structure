package algorithm.recursive;

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
	
	public static void main(String[] args) {
		Factorial f = new Factorial();
		System.out.println(f.factorialFunc1(5));
		System.out.println(f.factorialFunc2(5));
	}

}
