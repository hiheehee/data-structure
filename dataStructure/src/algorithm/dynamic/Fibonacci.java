package algorithm.dynamic;

public class Fibonacci {

	// 시간 / 공간 복잡도 O(n)
	public int fibonacci(int n) {
		Integer[] cache = new Integer[n+1];
		cache[0] = 0;
		cache[1] = 1;
		for(int i = 2; i < n+1; i++) {
			cache[i] = cache[i-1] + cache[i-2];
		}
		return cache[n];
	}
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		System.out.print(f.fibonacci(10));
	}

}
