package algorithm.search;

import java.util.ArrayList;

public class SequentialSearch {

	// 시간복잡도 : O(n)
	public int searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
		for(int i = 0; i < dataList.size(); i++) {
			if(dataList.get(i) == searchItem) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		SequentialSearch ss = new SequentialSearch();
		ArrayList<Integer> test = new ArrayList<>();
		
		for(int i = 0; i < 100; i++) {
			test.add((int)(Math.random()*100));
		}

		System.out.println(ss.searchFunc(test, 36));
		System.out.println(ss.searchFunc(test, -1));
	}

}
