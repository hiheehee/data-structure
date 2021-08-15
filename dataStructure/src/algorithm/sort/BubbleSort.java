package algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {

	// O(n^2)
	// 완전 정렬 되어있는 경우 : O(n)
	public ArrayList<Integer> sort(ArrayList<Integer> dataList){
		for(int i = 0; i < dataList.size()-1; i++) {
			boolean swap = false;
			for(int j = 0; j < dataList.size() - i - 1; j++) {
				if(dataList.get(j) > dataList.get(j+1)) {
					Collections.swap(dataList, j, j+1);
					swap = true;
				}
			}
			if(!swap) break; 
		}
		return dataList;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> test = new ArrayList<>();
		for(int i = 0; i < 100; i++) {
			test.add((int)(Math.random() * 100));
		}
		BubbleSort bsort = new BubbleSort();
		System.out.print(bsort.sort(test));
	}

}
