public class Node<T extends Comparable<T>> {
	private T data;
	Node<T> next;

	public Node(T data) {
		this.data = data;
	}
   
	public T getData() {
		return data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
}   
