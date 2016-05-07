package tasktimer;
/**
 * StopWatch compute elapsed time.
 * @author Jirayut Leeupathumvong 5810546617
 *
 */
public class StopWatch {
	private long startTime;
	private long stopTime;
	private boolean running;
	/**
	 * start the stopwatch.
	 */
	public void start(){
		if ( !running ){
			startTime = System.nanoTime();
			running = true;
		}
	}
	/**
	 * stop the stopwatch.
	 */
	public void stop(){
		if ( running ){
			stopTime = System.nanoTime();
			running = false;
		}
	}
	/**
	 * compute elapsed time.
	 * @return return elapsed time.
	 */
	public double getElapsed(){
		return (stopTime - startTime)*1.0E-9 ;
	}
}
