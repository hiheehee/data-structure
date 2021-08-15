package algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
	
	// O(n^2)
	public ArrayList<Integer> sort(ArrayList<Integer> dataList){
		int lowest;
		for(int i = 0; i < dataList.size()-1; i++) {
			lowest = i;
			for(int j = i + 1; j < dataList.size(); j++) {
				if(dataList.get(j) < dataList.get(lowest)) {
					lowest = j;
				}
			}
			Collections.swap(dataList, i, lowest);
		}
		return dataList;
	}

	public static void main(String[] args) {
		SelectionSort sSort = new SelectionSort();
		ArrayList<Integer> test = new ArrayList<Integer>();
		for(int i = 0; i < 100; i++) {
			test.add((int)(Math.random()*100));
		}
		System.out.println(sSort.sort(test));

	}

}
