package algorithm.backtracking;

import java.util.ArrayList;

public class NQueen {

	public void dfsFunc(Integer n, Integer curRow, ArrayList<Integer> curCandidate) {
		
		if(curRow == n) {
			System.out.println(curCandidate);
			return;
		}
		for(int i = 0; i < n; i++) {
			if(this.isAvailable(curCandidate, i)) {
				curCandidate.add(i);
				this.dfsFunc(n, curRow+1, curCandidate);
				curCandidate.remove(curCandidate.size()-1);
			}
		}
	}
	
	public boolean isAvailable(ArrayList<Integer> candidate, int curCol) {
		Integer curRow = candidate.size();
		
		for(int i = 0; i < curRow; i++) {
			if((candidate.get(i)) == curCol || (Math.abs(candidate.get(i) - curCol)) == (Math.abs(i - curRow))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		NQueen nObject = new NQueen();
		nObject.dfsFunc(4, 0, new ArrayList<Integer>());

	}

}
