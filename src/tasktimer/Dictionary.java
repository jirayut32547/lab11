package tasktimer;

import java.io.InputStream;
/**
 * Dictionary create the InputStream to read the wordlist.txt
 * @author Jirayut Leeupathumvong 5810546617
 *
 */
public class Dictionary {
	private static String DICTIONARY = "wordlist.txt";
	/**
	 * Return InputStream read the wordlist.txt.
	 * @return Return InputStream read the wordlist.txt.
	 */
	public static InputStream getWordsAsStream(){
		return TaskTimer.class.getClassLoader().getResourceAsStream(DICTIONARY);
	}

}
