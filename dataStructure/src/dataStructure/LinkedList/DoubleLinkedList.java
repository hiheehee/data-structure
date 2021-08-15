package dataStructure.LinkedList;

public class DoubleLinkedList<T> {
	
	public Node<T> head = null;
	public Node<T> tail = null;
	
	public class Node<T> {
		T data;
		Node<T> prev = null;
		Node<T> next = null;
		
		public Node(T data){
			this.data = data;
		}
	}
	
	public void addNode(T data) {
		if(this.head == null) {
			this.head = new Node<T>(data);
			this.tail = this.head;
		}else {
			Node<T> node = this.head;
			while(node.next != null) {
				node = node.next;
			}
			node.next = new Node<T>(data);
			node.next.prev = node;
			this.tail = node.next;
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
	
	public T searchFromHead(T isData) {
		if(this.head == null) {
			return null;
		}else {
			Node<T> node = this.head;
		while(node.next != null) {
				if(node.data == isData) {
					return node.data;
				}else {
					node = node.next;
				}
			}
		}
		return null;
	}
	
	public T searchFromTail(T isData) {
		if(this.head == null) {
			return null;
		}else {
			Node<T> node = this.tail;
		while(node.prev != null) {
				if(node.data == isData) {
					return node.data;
				}else {
					node = node.prev;
				}
			}
		}
		return null;
	}
	
	public boolean insertToFront(T existedData, T addData) {
		if(this.head == null) {
			this.head = new Node<T>(addData);
			this.tail = this.head;
		}else if(this.head.data == existedData){
			Node<T> newHead = new Node<>(addData);
			newHead.next = this.head;
			this.head = newHead;
		}else {
			Node<T> node = this.head;
			while(node != null) {
				Node<T> nodePrev = node.prev;
				
				nodePrev.next = new Node<>(addData);
				nodePrev.next.next = node;
				nodePrev.next.prev = nodePrev;
				node.prev = nodePrev.next;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		DoubleLinkedList<Integer> myLinkedList = new DoubleLinkedList<>();
		
		System.out.println("data 추가");
		myLinkedList.addNode(1);
		myLinkedList.addNode(2);
		myLinkedList.addNode(3);
		myLinkedList.addNode(4);
		myLinkedList.addNode(5);
		myLinkedList.printAll();
		System.out.println("--------");
		
		System.out.println("Head에서 data 찾기 추가");
		System.out.println(myLinkedList.searchFromHead(2));
		System.out.println("--------");
		
		System.out.println("Tail에서 data 찾기 추가");
		System.out.println(myLinkedList.searchFromTail(5));
		System.out.println("--------");
		
		
		System.out.println("1 인덱스 앞에 data 추가");
		myLinkedList.insertToFront(1, 0);
		myLinkedList.printAll();
		System.out.println("--------");

	}

}