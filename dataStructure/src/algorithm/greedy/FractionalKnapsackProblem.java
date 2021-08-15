package algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsackProblem {
	
	public void knapsackFunc(Integer objectList[][], double capacity) {
		double totalValue = 0.0;
		double fraction = 0.0;
		
		Arrays.sort(objectList, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return (o2[1]/o2[0]) - (o1[1]/o1[0]);
			}
		});
		
		for(int i = 0; i < objectList.length; i++) {
			if(0 < (capacity - (double)objectList[i][0])) {
				capacity -= (double)objectList[i][0];
				totalValue += (double)objectList[i][1];
				System.out.println("���� : "+(double)objectList[i][0]+" ��ġ : "+(double)objectList[i][1]);
			}else {
				fraction = capacity/(double)objectList[i][0];
				totalValue += (double)objectList[i][1]*fraction;
				System.out.println("���� : "+(double)objectList[i][0]+" ��ġ : "+(double)objectList[i][1]+" ���� : "+fraction);
				break;
			}
		}
		System.out.println("�� ���� �� �ִ� ��ġ : "+totalValue);
	}

	public static void main(String[] args) {
		Integer objectList[][] = {{10,10},{15,12},{20,10},{25,8},{30,5}};
		FractionalKnapsackProblem fkp = new FractionalKnapsackProblem();
		fkp.knapsackFunc(objectList, 30);

	}

}
