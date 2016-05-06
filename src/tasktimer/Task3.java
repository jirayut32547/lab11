package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.IntConsumer;

import tasktimer.TaskTimer.IntCounter;

public class Task3 implements Runnable{

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
	
	public String toString(){
		return "Starting task: read words using BufferedReader and Stream";
	}

}
