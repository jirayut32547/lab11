package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.IntConsumer;

/**
 * Process all the words in a file (one word per line) using BufferedReader
 * and the lines() method which creates a Stream of Strings (one item per line).  
 * Then use the stream to compute summary statistics.
 * In a lambda you cannot access a local variable unless it is final,
 * so (as a cludge) we use an attribute for the count.
 * When this method is rewritten as a Runnable, it can be a non-static attribute
 * of the runnable.
 * Display summary statistics.
 * @author Jirayut Leeupathumvong 5810546617
 */
public class Task3 implements Runnable{
	/**
	 * Performs the task.
	 */
	@Override
	public void run() {
		InputStream instream = Dictionary.getWordsAsStream();
		BufferedReader br = null;
		try {
			br = new BufferedReader( new InputStreamReader(instream) );
		} catch (Exception ex) {
			out.println("Could not open dictionary: "+ex.getMessage());
			return;
		}
		IntCounter counter = new IntCounter();
		br.lines().mapToInt( word -> word.length() ).forEach( counter );
		try {
			br.close();
		} catch(IOException ex) { /* ignore it */ }
		out.printf("Average length of %,d words is %.2f\n",
				counter.getCount(), counter.average() );

	}

	/** 
	 * Define a customer Consumer class that computes <b>both</b> the average 
	 * and count of values.
	 * An IntConsumer is a special Consumer interface the has an 'int' parameter 
	 * in accept().
	 */
	static class IntCounter implements IntConsumer {
		// count the values
		public int count = 0;
		// total of the values
		private long total = 0;
		/** accept consumes an int. In this method, count the value and add it to total. */
		public void accept(int value) { count++; total += value; }
		/** Get the average of all the values consumed. */
		public double average() { 
			return (count>0) ? ((double)total)/count : 0.0;
		}
		public int getCount() { return count; }
	}
	/**
	 * @return description of task.
	 */
	public String toString(){
		return "Starting task: read words using BufferedReader and Stream";
	}

}
