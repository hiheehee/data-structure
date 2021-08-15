package algorithm.search;

import java.util.ArrayList;
import java.util.Collections;

// �����Ͱ� �ϴ� ���ĵǾ� �־�� ��� �����ϴ�.
public class BinarySearch {
	
	// �ð����⵵ : O(log n)
	public boolean searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
		if(dataList.size() == 0) {
			return false;
		}
		if(dataList.size() == 1 && dataList.get(0) == searchItem) {
			return true;
		}
		if(dataList.size() == 1 && dataList.get(0) != searchItem) {
			return false;
		}
		
		int midInd = dataList.size()/2;
		
		if(dataList.get(midInd) == searchItem) {
			return true;
		}else {
			if(dataList.get(midInd) < searchItem) {
				return searchFunc(new ArrayList<Integer>(dataList.subList(0, midInd)), searchItem); 
			}else {
				return searchFunc(new ArrayList<Integer>(dataList.subList(midInd, dataList.size())), searchItem); 
			}
		}
	}
		
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		ArrayList<Integer> test = new ArrayList<>();
			
		for(int i = 0; i < 100; i++) {
			test.add((int)(Math.random()*100));
		}

		Collections.sort(test);
		System.out.println(bs.searchFunc(test, 55));
		System.out.println(bs.searchFunc(test, -1));
	}

}
