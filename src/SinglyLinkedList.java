public class SinglyLinkedList<E> {
	private Node<E> first;
	
	private static class Node<E> {
		Node<E> next;
		E element;
		Node(E element, Node<E> next) {
			this.next = next;
			this.element = element;
		}
	}
	public SinglyLinkedList() {
		first = new Node<>(null, null);
	}
	private void validateIndex(int index) {
		if(index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
	}
	private void linkAfter(Node<E> node, E element) {
		node.next = new Node<E>(element, node.next);
	}
	private void unlinkAfter(Node<E> node) {
		node.next = node.next.next;
	}
	private Node<E> nodeByIndex(int index) {
		validateIndex(index);
		Node<E> goal = first;
		for(int i = 0; i < index; i++) goal = goal.next;
		return goal;
	}
	public int size() {
		int size = 1;
		for(Node<E> n = first; n.next != null; n = n.next) size++;
		return size;
	}
	private void add(int index, E element) {
		validateIndex(index);
		if(index == 0 && first.element == null)
			first.element = element;
		else
			linkAfter(nodeByIndex(index), element);
	}
	public void add(E element) {
		add(size() - 1, element);
	}
	public void remove(int index) {
		validateIndex(index);
		if(index == 0)
			first = first.next;
		else
			unlinkAfter(nodeByIndex(index - 1));
	}
	public E get(int index) {
		validateIndex(index);
		return nodeByIndex(index).element;
	}
}
