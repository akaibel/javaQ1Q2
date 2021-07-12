package _test.datenbanken.chat;

public class Timer extends Thread{
	private int wartezeit;
	private TimerListener listener;
	
	public Timer(int pWartezeit, TimerListener pTimerListener){
		this.wartezeit = pWartezeit;
		listener = pTimerListener;
		this.start();
	}
	
	public void run(){
		while(true){
			if(listener != null){
				listener.timerSignal();
			}
			else{
				System.err.println("Timer.run(): listener is NULL");
			}
			try {
				sleep(wartezeit);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
