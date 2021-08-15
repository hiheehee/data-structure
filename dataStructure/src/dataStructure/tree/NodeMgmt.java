package dataStructure.tree;

public class NodeMgmt {

	Node head = null;
	
	public class Node {
		Node left;
		Node right;
		int value;
		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	public boolean insertNode(int data) {
		if(this.head == null) { // CASE 1 : Node가 하나도 없을 경우
			this.head = new Node(data);
		}else { // CASE 2 : Node가 하나 이상 들어가 있을때
			Node findNode = this.head;
			while(true) {
				if(data < findNode.value){ // CASE 2-1 : 현재 Node의 왼쪽에 Node가 들어가야 할 때
					if(findNode.left != null) {  // CASE 2-1-1 : 현재 Node의 왼쪽 자식이 있는 경우
						findNode = findNode.left;
					}else { // CASE 2-1-2 : 현재 Node의 왼쪽자식이 없는 경우
						findNode.left = new Node(data);
						break;
					}
				}else { // CASE 2-2 : 현재 Node의 오른쪽에 Node가 들어가야 할 때
					if(findNode.right != null) { // CASE 2-2-1 : 현재 Node의 오른쪽 자식이 있는 경우
						findNode = findNode.right;
					}else { // CASE 2-2-1 : 현재 Node의 오른쪽 자식이 없는 경우
						findNode.right = new Node(data);
						break;
					}
				}
			}
		}
		return true;
	}
	
	public Node search(int data) {
		if(this.head == null) { // CASE 1 : Node가 하나도 없을때
			return null;
		}else { // CASE 2 : Node가 하나라도 있을때
			Node findNode = this.head;
			while(findNode != null) {
				if(findNode.value == data) { // CASE 2-1 : Node가 찾던 노드일 경우
					return findNode;
				}else if(data < findNode.value) { // CASE 2-2 : 찾는 값이 현재 Node보다 작은 경우
					findNode = findNode.left;
				}else { // CASE 2-3 : 찾는 값이 현재 Node보다 큰 경우
					findNode = findNode.right;
				}
			}
		}
		return null;
		
	}
	
	public boolean delete(int data) {
		boolean searched = false;
		Node curParentNode = this.head; // 부모노드
		Node curNode = this.head; // 삭제할 노드
		
		if(this.head == null) { // CASE 1 : Node가 하나도 없을때
			return false;
		}else { // CASE 2 : Node가 하나라도 있을때
			if(this.head.value == data && this.head.left == null && this.head.right == null) { // CASE 2-1 : Node가 하나인데 해당 노드가 삭제할 노드일때
				this.head = null;
				return true;
			}
			
			while(curNode != null) { // 삭제할 Node 찾기
				if(curNode.value == data) {
					searched = true;
					break;
				}else if(data < curNode.value) {
					curParentNode = curNode;
					curNode = curNode.left;
				}else {
					curParentNode = curNode;
					curNode = curNode.right;
				}
			}
			
			if(!searched) { // 삭제할 노드를 찾지 못한 경우
				return false;
			}
		}
		
		// CASE 3 : 삭제할 Node가 존재하는 경우
		if(curNode.left == null && curNode.right == null) { // CASE 3-1 : 삭제할 Node가 leaf node인 경우
			if(data < curParentNode.value) { // cur이 부모의 왼쪽 자식인 경우
				curParentNode.left = null;
				curNode = null;
			}else { // cur이 부모의 오른쪽 자식인 경우
				curParentNode.right = null;
				curNode = null;
			}
			return true;
		}else if(curNode.left != null && curNode.right == null) { // CASE 3-2 : 삭제할 Node의 자식이 왼쪽에만 있다면
			if(data < curParentNode.value) { // cur이 부모의 왼쪽 자식인 경우
				curParentNode.left = curNode.left;
				curNode = null;
			}else { // cur이 부모의 오른쪽 자식인 경우
				curParentNode.right = curNode.left;
				curNode = null;
			}
			return true;
		}else if(curNode.left == null && curNode.right != null) { // CASE 3-2 : 삭제할 Node의 자식이 오른쪽에만 있다면
			if(data < curParentNode.value) { // cur이 부모의 왼쪽 자식인 경우
				curParentNode.left = curNode.right;
				curNode = null;
			}else { // cur이 부모의 오른쪽 자식인 경우
				curParentNode.right = curNode.right;
				curNode = null;
			}
			return true;
		}else { // CASE 3-3 : 삭제할 Node의 자식이 왼쪽 오른쪽 둘다 있다면
			if(data < curParentNode.value) { // cur이 부모의 왼쪽 자식인 경우 => cur의 오른쪽 자식 중 가장 왼쪽 자식을 찾는다.
				Node changeNode = curNode.right;
				Node changeParentNode = curNode.right;
				while(changeNode.left != null){
					changeParentNode = changeNode;
					changeNode = changeNode.left;
				}
				
				if(changeNode.right != null) { // cur의 오른쪽 자식 중 가장 왼쪽 자식이 오른쪽 자식을 가진 경우
					changeParentNode.left = changeNode.right;
				}else { // cur의 오른쪽 자식 중 가장 왼쪽 자식 leaf Node인 경우
					changeParentNode.left = null;
				}
				
				curParentNode.left = changeNode; // 삭제할 부모 Node의 왼쪽 노드를 바꿀 Node로 변경
				changeNode.left = curNode.left; // 삭제할 Node의 왼쪽을 바꿀 Node의 왼쪽으로 바꿈
				changeNode.right = curNode.right; // 삭제할 Node의 오른쪽을 바꿀 Node의 오른쪽으로 바꿈
				curNode = null;
			}else { // cur이 부모의 오른쪽 자식인 경우 => cur의 왼쪽 자식 중 가장 오른쪽 자식을 찾는다.
				Node changeNode = curNode.right;
				Node changeParentNode = curNode.right;
				while(changeNode.left != null){
					changeParentNode = changeNode;
					changeNode = changeNode.left;
				}
				
				if(changeNode.right != null) { // cur의 오른쪽 자식 중 가장 왼쪽 자식이 오른쪽 자식을 가진 경우
					changeParentNode.left = changeNode.right;
				}else { // cur의 오른쪽 자식 중 가장 왼쪽 자식 leaf Node인 경우
					changeParentNode.left = null;
				}
				curParentNode.right = changeNode; // 삭제할 부모 Node의 오른쪽 노드를 바꿀 Node로 변경
				changeNode.right = curNode.right; // 삭제할 Node의 오른쪽을 바꿀 Node의 오른쪽으로 바꿈
				changeNode.left = curNode.left; // 삭제할 Node의 왼쪽을 바꿀 Node의 왼쪽으로 바꿈
				curNode = null;
			}
			return true;
		}
		
	}
	
	public static void main(String[] args)  {
		
		NodeMgmt myTree = new NodeMgmt();
		myTree.insertNode(10);
		myTree.insertNode(15);
		myTree.insertNode(13);
		myTree.insertNode(11);
		myTree.insertNode(14);
		myTree.insertNode(18);
		myTree.insertNode(16);
		myTree.insertNode(19);
		myTree.insertNode(17);
		myTree.insertNode(7);
		myTree.insertNode(8);  
		myTree.insertNode(6);
		    
		System.out.println(myTree.delete(15));  
		System.out.println(myTree.head.value);
		System.out.println(myTree.head.left.value);
		System.out.println(myTree.head.left.left.value);
		System.out.println(myTree.head.left.right.value);
		
		System.out.println(myTree.head.right.value);  
		System.out.println(myTree.head.right.left.value);
		System.out.println(myTree.head.right.right.value);
		
		System.out.println(myTree.head.right.right.left.value);
		System.out.println(myTree.head.right.right.right.value);

	}
}
