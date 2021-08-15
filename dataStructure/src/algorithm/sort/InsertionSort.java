package algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {

	// O(n^2)
	public ArrayList<Integer> sort(ArrayList<Integer> dataList){
		for(int i = 0; i < dataList.size()-1; i++) {
			for(int j = i+1; 0 < j; j--) {
				if(dataList.get(j) <dataList.get(j-1)) {
					Collections.swap(dataList, j, j-1);
				}else {
					break;
				}
			}
		}
		return dataList;
	}
	
	public static void main(String[] args) {
		InsertionSort  iSort = new InsertionSort ();
		ArrayList<Integer> test = new ArrayList<Integer>();
		for(int i = 0; i < 100; i++) {
			test.add((int)(Math.random()*100));
		}
		System.out.println(iSort.sort(test));
	}

}
