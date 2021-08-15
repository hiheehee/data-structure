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
		if(this.head == null) { // CASE 1 : Node�� �ϳ��� ���� ���
			this.head = new Node(data);
		}else { // CASE 2 : Node�� �ϳ� �̻� �� ������
			Node findNode = this.head;
			while(true) {
				if(data < findNode.value){ // CASE 2-1 : ���� Node�� ���ʿ� Node�� ���� �� ��
					if(findNode.left != null) {  // CASE 2-1-1 : ���� Node�� ���� �ڽ��� �ִ� ���
						findNode = findNode.left;
					}else { // CASE 2-1-2 : ���� Node�� �����ڽ��� ���� ���
						findNode.left = new Node(data);
						break;
					}
				}else { // CASE 2-2 : ���� Node�� �����ʿ� Node�� ���� �� ��
					if(findNode.right != null) { // CASE 2-2-1 : ���� Node�� ������ �ڽ��� �ִ� ���
						findNode = findNode.right;
					}else { // CASE 2-2-1 : ���� Node�� ������ �ڽ��� ���� ���
						findNode.right = new Node(data);
						break;
					}
				}
			}
		}
		return true;
	}
	
	public Node search(int data) {
		if(this.head == null) { // CASE 1 : Node�� �ϳ��� ������
			return null;
		}else { // CASE 2 : Node�� �ϳ��� ������
			Node findNode = this.head;
			while(findNode != null) {
				if(findNode.value == data) { // CASE 2-1 : Node�� ã�� ����� ���
					return findNode;
				}else if(data < findNode.value) { // CASE 2-2 : ã�� ���� ���� Node���� ���� ���
					findNode = findNode.left;
				}else { // CASE 2-3 : ã�� ���� ���� Node���� ū ���
					findNode = findNode.right;
				}
			}
		}
		return null;
		
	}
	
	public boolean delete(int data) {
		boolean searched = false;
		Node curParentNode = this.head; // �θ���
		Node curNode = this.head; // ������ ���
		
		if(this.head == null) { // CASE 1 : Node�� �ϳ��� ������
			return false;
		}else { // CASE 2 : Node�� �ϳ��� ������
			if(this.head.value == data && this.head.left == null && this.head.right == null) { // CASE 2-1 : Node�� �ϳ��ε� �ش� ��尡 ������ ����϶�
				this.head = null;
				return true;
			}
			
			while(curNode != null) { // ������ Node ã��
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
			
			if(!searched) { // ������ ��带 ã�� ���� ���
				return false;
			}
		}
		
		// CASE 3 : ������ Node�� �����ϴ� ���
		if(curNode.left == null && curNode.right == null) { // CASE 3-1 : ������ Node�� leaf node�� ���
			if(data < curParentNode.value) { // cur�� �θ��� ���� �ڽ��� ���
				curParentNode.left = null;
				curNode = null;
			}else { // cur�� �θ��� ������ �ڽ��� ���
				curParentNode.right = null;
				curNode = null;
			}
			return true;
		}else if(curNode.left != null && curNode.right == null) { // CASE 3-2 : ������ Node�� �ڽ��� ���ʿ��� �ִٸ�
			if(data < curParentNode.value) { // cur�� �θ��� ���� �ڽ��� ���
				curParentNode.left = curNode.left;
				curNode = null;
			}else { // cur�� �θ��� ������ �ڽ��� ���
				curParentNode.right = curNode.left;
				curNode = null;
			}
			return true;
		}else if(curNode.left == null && curNode.right != null) { // CASE 3-2 : ������ Node�� �ڽ��� �����ʿ��� �ִٸ�
			if(data < curParentNode.value) { // cur�� �θ��� ���� �ڽ��� ���
				curParentNode.left = curNode.right;
				curNode = null;
			}else { // cur�� �θ��� ������ �ڽ��� ���
				curParentNode.right = curNode.right;
				curNode = null;
			}
			return true;
		}else { // CASE 3-3 : ������ Node�� �ڽ��� ���� ������ �Ѵ� �ִٸ�
			if(data < curParentNode.value) { // cur�� �θ��� ���� �ڽ��� ��� => cur�� ������ �ڽ� �� ���� ���� �ڽ��� ã�´�.
				Node changeNode = curNode.right;
				Node changeParentNode = curNode.right;
				while(changeNode.left != null){
					changeParentNode = changeNode;
					changeNode = changeNode.left;
				}
				
				if(changeNode.right != null) { // cur�� ������ �ڽ� �� ���� ���� �ڽ��� ������ �ڽ��� ���� ���
					changeParentNode.left = changeNode.right;
				}else { // cur�� ������ �ڽ� �� ���� ���� �ڽ� leaf Node�� ���
					changeParentNode.left = null;
				}
				
				curParentNode.left = changeNode; // ������ �θ� Node�� ���� ��带 �ٲ� Node�� ����
				changeNode.left = curNode.left; // ������ Node�� ������ �ٲ� Node�� �������� �ٲ�
				changeNode.right = curNode.right; // ������ Node�� �������� �ٲ� Node�� ���������� �ٲ�
				curNode = null;
			}else { // cur�� �θ��� ������ �ڽ��� ��� => cur�� ���� �ڽ� �� ���� ������ �ڽ��� ã�´�.
				Node changeNode = curNode.right;
				Node changeParentNode = curNode.right;
				while(changeNode.left != null){
					changeParentNode = changeNode;
					changeNode = changeNode.left;
				}
				
				if(changeNode.right != null) { // cur�� ������ �ڽ� �� ���� ���� �ڽ��� ������ �ڽ��� ���� ���
					changeParentNode.left = changeNode.right;
				}else { // cur�� ������ �ڽ� �� ���� ���� �ڽ� leaf Node�� ���
					changeParentNode.left = null;
				}
				curParentNode.right = changeNode; // ������ �θ� Node�� ������ ��带 �ٲ� Node�� ����
				changeNode.right = curNode.right; // ������ Node�� �������� �ٲ� Node�� ���������� �ٲ�
				changeNode.left = curNode.left; // ������ Node�� ������ �ٲ� Node�� �������� �ٲ�
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
