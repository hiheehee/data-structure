package algorithm.recursive;

public class Factorial {

	// 시간 / 공간 복잡도 O(n)
	public int factorialFunc(int n) {
		if(n > 1) {
			return n * this.factorialFunc(n-1);
		}else {
			return 1;
		}
	}
	
	public static void main(String[] args) {
		Factorial f = new Factorial();
		System.out.println(f.factorialFunc(5));

	}

}
