package algorithm.sort;

import java.util.ArrayList;

// 분할 정복 방법
// 시간 복잡도 O(N log N)
public class MergeSort {
	
	// 분할
	public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList) {
		if(dataList.size() <= 1) return dataList;
		int midIdx = dataList.size() / 2;
		ArrayList<Integer> left = mergeSplitFunc(new ArrayList<Integer>(dataList.subList(0, midIdx)));
		ArrayList<Integer> right = mergeSplitFunc(new ArrayList<Integer>(dataList.subList(midIdx, dataList.size())));
		return mergeFunc(left, right);
	}
	
	private ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
		ArrayList<Integer> mergedList = new ArrayList<Integer>();
		int leftPoint = 0;
		int rightPoint = 0;
		
		// case 1 : left, right List 둘다 있을때
		while(leftPoint < leftList.size() && rightPoint < rightList.size()) {
			if(leftList.get(leftPoint) < rightList.get(rightPoint)) {
				mergedList.add(leftList.get(leftPoint));
				leftPoint++;
			}else {
				mergedList.add(rightList.get(rightPoint));
				rightPoint++;
			}
		}
		
		// case 2 : 왼쪽 데이터만 남은 경우
		while(leftPoint < leftList.size()) { 
			mergedList.add(leftList.get(leftPoint));
			leftPoint++;
		}
		
		// case 3 : 오른쪽 데이터만 남은 경우
		while(rightPoint < rightList.size()) {
			mergedList.add(rightList.get(rightPoint));
			rightPoint++;
		}
		return mergedList;
	}

	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		ArrayList<Integer> test = new ArrayList<>();
		
		for(int i = 0; i < 100; i++) {
			test.add((int)(Math.random()*100));
		}

		System.out.println(ms.mergeSplitFunc(test));
	}

}
