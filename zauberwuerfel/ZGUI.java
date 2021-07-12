package zauberwuerfel;

public class ZGUI {
	private ZFrame zauberwuerfelFrame;
	private int wartezeit = 10;
	
	/**
	 * Erzeugt ein Zauberwuerfel-Netz.
	 */
	public ZGUI(ZLogik zLogik) {
		this.zauberwuerfelFrame = new ZFrame(zLogik);
	}
	
	public void updateGUI(ZModel zm){
		this.zauberwuerfelFrame.updateGUI(zm);
		try {
			Thread.sleep(wartezeit);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setWartezeit(int wartezeitInMillis){
		this.wartezeit = wartezeitInMillis;
	}

	public int getWartezeit() {
		return this.wartezeit;
	}

}
