import java.lang.*;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item> {
	private Node<Item> first; //top od queue
	private Node<Item> last; // button of queue
	private int N; //size of a deque
	
	
	private class Node<Item> { //Node class
		Item item;
		Node<Item> next;
		Node<Item> former;
		
	}
	
	public Deque() {
		first = last = null;
		N = 0;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void addFirst(Item item) {
		if (item == null) throw new java.lang.NullPointerException("Null in item");
		Node<Item> oldFirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldFirst;
		first.former = null;
		if (isEmpty()) last = first;
		else {
			oldFirst.former = first;
		}
		N++;
		
	}
	
	public void addLast(Item item) {
		if (item == null) throw new java.lang.NullPointerException("Null in item");
		Node<Item> node = new Node<Item>();
		node.item = item;
		node.next = null;
		if (isEmpty()) first = last = node; //add first element
		else {
			node.former = last;
			last.next = node;
			last = last.next;
		}
		
		N++;
	}
	
	public Item removeFirst() {
		if (isEmpty()) throw new java.util.NoSuchElementException("The deque is empty!");
		Node<Item> node = first;
		if (size() == 1) first = last = null;
		else {	
			first.next.former = null;
			first = first.next;
		}
		N--;
		return node.item;
	}
	
	public Item removeLast() {
		if (isEmpty())  throw new java.util.NoSuchElementException("The deque is empty!");
		Node<Item> node = last;
		if (size() == 1) first = last = null;
		
		else {
			last.former.next = null;
			last = last.former;
		}
		N--;
		return node.item;
		
	}
	
	public Iterator<Item> iterator() {
	        return new ListIterator<Item>(first);  
	}

	    // an iterator, doesn't implement remove() since it's optional
	    private class ListIterator<Item> implements Iterator<Item> {
	        private Node<Item> current;

	        public ListIterator(Node<Item> first) {
	            current = first;
	        }

	        public boolean hasNext()  { return current != null;                     }
	        public void remove()      { throw new UnsupportedOperationException();  }

	        public Item next() {
	            if (!hasNext()) throw new NoSuchElementException();
	            Item item = current.item;
	            current = current.next; 
	            return item;
	        }
	    }
	    public static void main(String[] args) {
	    	Deque<Integer> deque = new Deque<Integer>();
	    	   deque.addFirst(0);
	           deque.addFirst(1);
	           deque.addFirst(2);
	           deque.isEmpty();
	           deque.addFirst(4);
	           deque.addFirst(5);
	           deque.addFirst(6);
	           deque.isEmpty();
	           deque.isEmpty();
	           deque.removeLast();
	    	
	    	Iterator<Integer> iter = deque.iterator();
	    	while (iter.hasNext()) {
	    		System.out.println(iter.next());
	    	}
	    	
	    	
	    	
	    }

	}
	

