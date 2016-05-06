package tasktimer;

import java.io.InputStream;

public class Dictionary {
	private static String DICTIONARY = "wordlist.txt";
	public static InputStream getWordsAsStream(){
		return TaskTimer.class.getClassLoader().getResourceAsStream(DICTIONARY);
	}

}
