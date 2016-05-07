package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/** 
* Append all the words from the dictionary to a String.
* This shows why you should be careful about using "string1"+"string2".
* @author Jirayut Leeupathumvong 5810546617
*/
public class Task5 implements Runnable{
	static final int MAXCOUNT = 50_000;
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

		String result = "";
		String word = null;
		int count = 0;
		try {
			while( (word=br.readLine()) != null && count < MAXCOUNT) {
				result = result + word;
				count++;
			}
		} catch(IOException ioe) { System.out.println( ioe.getMessage() ); }
		System.out.printf("Done appending %d words to string.\n", count);


	}
	/**
	 * @return description of task.
	 */
	public String toString(){
		return "Starting task: append "+MAXCOUNT+" words to a String using +";
	}

}
