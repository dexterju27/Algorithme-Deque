
import java.util.Iterator;
import java.util.NoSuchElementException;

//import Deque.ListIterator;
//import Deque.Node;
import edu.princeton.cs.algs4.*;
public class RandomizedQueue<Item> implements Iterable<Item> {
	// has to be a resized array to deal with the random dequeue.
	
	private int N;
	private Item [] array;
	private StdRandom random;
	
	  public RandomizedQueue()      {
		  N = 0;
		  array = (Item[]) new Object[2];
	  }
	  // construct an empty randomized queue
	   public boolean isEmpty() {
		   // is the queue empty?
		  return N == 0;
	   }
	   
	   public int size() {
		   return 	N;
		   
	   }
	   
	   private void resize(int newsize) {
		   assert newsize > N;
		   Item[] temp = (Item[]) new Object[newsize];
		   for (int i = 0; i < N; i++) {
			   temp[i] = array[(i) % array.length];;
		   }
		   array = temp;
//		   for (int i = 0; i < N; i++ ){
//			   System.out.print("During the changing method: "+ array[i]);
//		   }
	   }
	   // return the number of items on the queue
	   
	   public void enqueue(Item item)    {
		   // add the item
		   if(item == null) throw new java.lang.NullPointerException("Item is not exsite");
		// check whether item == null
		   
		   //check the size of array
		   if (N == array.length) {
			   resize (2 * array.length);
		   }   
		   array[N++] = item;
		   return;
	   }
	   
	   public Item dequeue(){
		   // remove and return a random item
		   if (isEmpty()) throw new java.util.NoSuchElementException("The array is empty!");
		   int target = StdRandom.uniform(N);
		   Item temp = array[target];
		   array[target] = array[N - 1];
		   array[N - 1] = null;
		   N--;
		   //set to null
		   // when n = 0, shrink to 0, not good
		   if ( N < (1.0 / 4.0) * array.length && N > 2) resize(array.length / 2); // <= may be 0
		   return temp;	   
		   
	   }
	   
	   public Item sample() {
		   // return (but do not remove) a random item
		   if (isEmpty()) throw new java.util.NoSuchElementException("The array is empty!");
		   int target = StdRandom.uniform(N);
		   return array[target];
		   
	   }
	   
	   public Iterator<Item> iterator() {
		   StdRandom.shuffle(array, 0, N - 1); // random for each iterator
	        return new ArrayIterator();
	    }

	    // an iterator, doesn't implement remove() since it's optional
	    private class ArrayIterator implements Iterator<Item> {
	        private int i;
	        private int [] arrayIter;
	        ArrayIterator() {
	        	if (N == 0) throw new java.util.NoSuchElementException("The array is empty!");
	        	i = 0;
	        	arrayIter = new int[N];
	        	for (int j = 0; j < N; j++) {
	        		arrayIter[j] = j;
	        	}
	        	StdRandom.shuffle(arrayIter,0,N - 1);
	        	
	        }
	        public boolean hasNext()  { return i < N;                               }
	        public void remove()      { throw new UnsupportedOperationException();  }

	        public Item next() {
	            if (!hasNext()) throw new NoSuchElementException();
	            return array[arrayIter[i++]];
	        }
	    }
	   	   // return an independent iterator over items in random order
	    public static void main(String[] args) {
	    	System.out.println("hello!");
	    	RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
	    	rq.isEmpty();
	    	rq.enqueue(27);
	    	rq.size();       
	    	rq.dequeue();
	    	rq.enqueue(950);
	    	rq.size();        //==> 1
	    	rq.size(); //        ==> 1
	    	rq.dequeue();     //==> 950
	    	rq.enqueue(398);

	    	
	    	
  }
  // unit testing
	

}
