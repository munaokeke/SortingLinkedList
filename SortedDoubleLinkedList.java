package cmsc204Assign3;

import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

	private final Comparator<T> comparator;

	
	SortedDoubleLinkedList(Comparator<T> comparator2) {
		comparator = comparator2;
	}

	
	public SortedDoubleLinkedList<T> add(T data) {
		Node<T> newNode = new Node<T>(data);

		if (isEmpty()) {
			head = tail = newNode;
		} else if (comparator.compare(data, head.data) <= -1) {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		} else if (comparator.compare(data, tail.data) >= 1) {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		} else {
			Node<T> current = head.next;
			while (current.next != null && comparator.compare(data, current.data) >= 1) {
				current = current.next;
			}
			newNode.next = current;
			newNode.prev = current.prev;
			current.prev.next = newNode;
			current.prev = newNode;
		}
		size++;
		return this;

	}

	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}

	@Override
	public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}

	@Override
	public ListIterator<T> iterator() {
		return super.iterator();
	}

	@Override
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
		return (SortedDoubleLinkedList<T>) super.remove(data, comparator);
	}
}
