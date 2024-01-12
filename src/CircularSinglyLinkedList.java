
public class CircularSinglyLinkedList<T extends Comparable<T>> {

	private Node<T> head;

	public CircularSinglyLinkedList() {
		this.head = null;
	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	
	public void insertSorted(T data) { // O(n)
		Node<T> newNode = new Node<>(data);

		if (head == null) { // If the list is empty.
			head = newNode;
			head.setNext(head); // make it circular.
		} 
		// If the data is greater than or equal to the head, insert it at the beginning
			// of the list.
		else if (head.getData().compareTo(data) >= 0) {
			newNode.setNext(head);
			Node<T> curr = head;
			while (curr.getNext() != head) { // Traverse the list to find the last node and
				curr = curr.getNext(); 
			}
			curr.setNext(newNode);  // update its next reference to the new node.
			head = newNode;        // Update the head to the new node.

		} else {
			Node<T> curr = head;
			while (curr.getNext() != head && curr.getNext().getData().compareTo(data) < 0) {
				curr = curr.getNext();
			}
	        // Insert the new node in the middle or at the end of the list.
			newNode.setNext(curr.getNext());
			curr.setNext(newNode);
		}
	}

	
	public Node<T> search(T data) { // O(n).
		if (head == null) { // If the list is empty ( return null )
			return null;
		}

		Node<T> curr = head;
		do {
			// Check if the current node's data matches the target data.
			if (curr.getData().compareTo(data) == 0) {
				return curr;
			}
			curr = curr.getNext();
		} while (curr != head && curr.getData().compareTo(data) <= 0);

		// If no match is found, return null.
		return null;
	}

	
	public void delete(T data) { // O(n).
		if (head == null) {
			return;
		}

		// Check if the element to delete is the head of the list.
		if (head.getData().compareTo(data) == 0) {
			// If the element to delete is the head
			Node<T> curr = head;
			while (curr.getNext() != head) { // Traverse the list to find the last node.
				curr = curr.getNext();
			}
			if (head == head.getNext()) {
				// Only one element in the list
				head = null;
			} else {
				head = head.getNext();
				curr.setNext(head);
			}
		} else {
			// If the element to delete is not the head
			Node<T> curr = head;
			Node<T> prev = null;

			// Traverse the list to find the node to delete.
			do {
				// Check if the current node's data matches the target data.
				if (curr.getData().compareTo(data) == 0) {
					prev.setNext(curr.getNext()); // Remove the current node
					return; // by updating the previous node's next reference.
				}
	            // Move to the next node in the list.
				prev = curr;
				curr = curr.getNext();
			} while (curr != head);
		}
	}

	
	public void printList() {  //O(n).
		if (head == null) {
			System.out.println("Empty List");
			return;
		}

		Node<T> curr = head;
		do {
			System.out.print(curr.getData() + " ");
			curr = curr.getNext();
		} while (curr != head);
		System.out.println();
	}

	public void reverse() {
		if (head == null || head.getNext() == head) {
			// If the list is empty or has only one element.
			return;
		}

		Node<T> prev = null;
		Node<T> curr = head;
		Node<T> next;

		do {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		} while (curr != head);

		head.setNext(prev);
		head = prev;
	}
}