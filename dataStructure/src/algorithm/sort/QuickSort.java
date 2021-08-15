package algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;

// ���� ���� ���
// �ð� ���⵵ O(N log N) : �Ϲ���
// O(n^2) : ���� ���ĵ� �����Ϳ��� ���
public class QuickSort {
	
	public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
		if(dataList.size() <= 1) {
			return dataList;
		}
		int pivot = dataList.get(0);
		ArrayList<Integer> leftList = new ArrayList<Integer>();
		ArrayList<Integer> rightList = new ArrayList<Integer>();
		
		for(int i = 1; i < dataList.size(); i++) {
			if(dataList.get(i) < pivot) {
				leftList.add(dataList.get(i));
			}else {
				rightList.add(dataList.get(i));
			}
		}
		
		ArrayList<Integer> mergedList = new ArrayList<Integer>();
		mergedList.addAll(sort(leftList));
		mergedList.addAll(Arrays.asList(pivot));
		mergedList.addAll(sort(rightList));
		
		return mergedList;
	}

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		ArrayList<Integer> test = new ArrayList<>();
		for(int i = 0; i < 100; i++) {
			test.add((int)(Math.random()*100));
		}

		System.out.println(qs.sort(test));
	}

}
