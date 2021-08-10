package dataStructure;

public class SingleLinkedList<T> {

	public Node<T> head = null;
	
	public class Node<T> {
		T data;
		Node<T> next = null;
		
		public Node(T data){
			this.data = data;
		}
	}
	
	public void addNode(T data) { // 노트 추가
		if(head == null) {
			head = new Node<T>(data);
		}else {
			Node<T> node = this.head;
			while(node.next != null) {
				node = node.next;
			}
			node.next = new Node<>(data);
		}
	}
	
	
	public void printAll() { // print
		if(head != null) {
			Node<T> node = this.head;
			System.out.println(node.data);
			while(node.next != null) {
				node = node.next;
				System.out.println(node.data);
			}
		}
	}
	
	public Node<T> search(T data){
		if(this.head == null) {
			return null;
		}else {
			Node<T> node = this.head;
			while(node != null) {
				if(node.data == data) {
					return node;
				}else {
					node = node.next;
				}
			}
		}
		return null;
	}
	
	public void addNodeInside(T data, T isData) {
		Node<T> searchNode = this.search(isData);
		
		if(searchNode == null) {
			this.addNode(data);
		}else {
			Node<T> nextNode = searchNode.next;
			searchNode.next = new Node<T>(data);
			searchNode.next.next = nextNode;
		}
	}
	
	public boolean delNode(T isData) {
		if(this.head == null) {
			return false;
		}else {
			Node<T> node = this.head;
			if(node.data == isData) {
				this.head = this.head.next;
				return true;
			}
			while(node.next != null) {
				if(node.next.data == isData) {
					node.next = node.next.next;
					return true;
				}
				node = node.next;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		SingleLinkedList<Integer> myLinkedList = new SingleLinkedList<Integer>();
		
		System.out.println("data 추가");
		myLinkedList.addNode(1);
		myLinkedList.addNode(2);
		myLinkedList.addNode(3);
		myLinkedList.addNode(4);
		myLinkedList.addNode(5);
		myLinkedList.printAll();
		System.out.println("--------");
		
		System.out.println("2 뒤에  data 추가");
		myLinkedList.addNodeInside(8, 2);
		myLinkedList.printAll();
		System.out.println("--------");
		
		System.out.println("5 데이터 삭제");
		myLinkedList.delNode(5);
		myLinkedList.printAll();
		System.out.println("--------");

	}

}