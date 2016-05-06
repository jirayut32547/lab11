package tasktimer;

public class StopWatch {
	private long startTime;
	private long stopTime;
	private boolean running;

	public void start(){
		if ( !running ){
			startTime = System.nanoTime();
			running = true;
		}
	}
	public void stop(){
		if ( running ){
			stopTime = System.nanoTime();
			running = false;
		}
	}
	public double getElapsed(){
		return (stopTime - startTime)*1.0E-9 ;
	}
}
