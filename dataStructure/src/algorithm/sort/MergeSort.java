package algorithm.sort;

import java.util.ArrayList;

// ���� ���� ���
// �ð� ���⵵ O(N log N)
public class MergeSort {
	
	// ����
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
		
		// case 1 : left, right List �Ѵ� ������
		while(leftPoint < leftList.size() && rightPoint < rightList.size()) {
			if(leftList.get(leftPoint) < rightList.get(rightPoint)) {
				mergedList.add(leftList.get(leftPoint));
				leftPoint++;
			}else {
				mergedList.add(rightList.get(rightPoint));
				rightPoint++;
			}
		}
		
		// case 2 : ���� �����͸� ���� ���
		while(leftPoint < leftList.size()) { 
			mergedList.add(leftList.get(leftPoint));
			leftPoint++;
		}
		
		// case 3 : ������ �����͸� ���� ���
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
