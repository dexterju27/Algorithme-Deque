import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Subset {
	public static void main(String[] args) {
		//assume the input is legal
		int k = Integer.parseInt(args[0]);
		int i = 0;
		RandomizedQueue<String> queue = new RandomizedQueue<String>();
		
		while (StdIn.isEmpty() == false) {
			queue.enqueue(StdIn.readString());
		}
		
		while (i < k) {
			StdOut.println(queue.dequeue());
			i++;
		}
		
	}
}
