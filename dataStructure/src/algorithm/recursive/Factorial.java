package algorithm.recursive;

public class Factorial {

	// �ð� / ���� ���⵵ O(n)
	// ��� 1
	public int factorialFunc1(int n) {
		if(n > 1) {
			return n * this.factorialFunc1(n-1);
		}else {
			return 1;
		}
	}
	
	// �ð� / ���� ���⵵ O(n)
	// ��� 2
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
