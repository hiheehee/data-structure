package algorithm.recursive;

public class Fibonacci {

	// �ð� / ���� ���⵵ O(n)
	public int fibonacci(int n) {
		if(n == 0) {
			return 0;
		}else if (n == 1){
			return 1;
		}else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		System.out.print(f.fibonacci(10));

	}

}
