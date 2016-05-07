package tasktimer;

import static java.lang.System.out;

import java.util.Scanner;
/**
 * Process all the words in a file using Scanner to read and parse input.
 * Display summary statistics
 * @author Jirayut Leeupathumvong 5810546617
 */

public class Task1 implements Runnable{
	/**
	 * Performs the task.
	 */
	@Override
	public void run() {
		Scanner in = new Scanner(Dictionary.getWordsAsStream());
		int count = 0;
		long totalsize = 0;
		while(in.hasNext()) {
			String word = in.next();
			totalsize += word.length();
			count++;
		}
		double averageLength = ((double)totalsize)/(count>0 ? count : 1);
		out.printf("Average length of %,d words is %.2f\n", count, averageLength);
		in.close();
	}
	
	/**
	 * @return description of task.
	 */
	public String toString(){
		return "Starting task: read words using Scanner and a while loop";
	}

}
