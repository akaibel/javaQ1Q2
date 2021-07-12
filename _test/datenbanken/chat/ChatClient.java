package _test.datenbanken.chat;


import javax.swing.JOptionPane;

public class ChatClient implements TimerListener{
	private final int reaktionsZeitInMilliSec = 1000;
	private ChatClientGUI gui;
	private Datenbank datenbank;
	private Timer timer;
	
	
	
	public ChatClient(){
		datenbank = new Datenbank();
		gui = new ChatClientGUI(this);
		String code = "";
		String nickname = "";
		boolean erfolg = false;
		do{
			String codeNickname = JOptionPane.showInputDialog(gui, "Code:Nickname");
			if(codeNickname == null){
				System.exit(0);
			}
			String[] splits = codeNickname.split(":");
			if(splits.length == 2){
				code = splits[0].trim();
				nickname = splits[1].trim();
				if(code.length()>2 && nickname.length()>2){
					erfolg = true;
				}
			}
		}while(erfolg == false);
		this.enterChatroom(code, nickname);
		timer = new Timer(reaktionsZeitInMilliSec, this);
	}

	/**
	 * zeigt eine Message an.
	 * @param pMessage
	 */
	private void addMessage(String pMessage){
		gui.addMessage(pMessage);
	}

	private void enterChatroom(String pCode, String pNickname) {
		this.addMessage("Raum "+pCode+" "+pNickname);
		//TODO
	}

	/**
	 * wird in regelmaessigen Abstaenden aufgerufen
	 * siehe reaktionszeitInMilliSec
	 */	
	public void timerSignal() {
		//TODO
		System.out.println("timerSignal");
	}

	/**
	 * sendet eine Nachricht an den Server	
	 * @param pMessage
	 */
	public void send(String pMessage) {
		System.out.println("ChatClient.send(\""+pMessage+"\")");
		//TODO
	}

	/**
	 * wird aufgerufen, wenn die ChatClientGUI geschlossen wird.
	 */
	public void windowClosing() {
		System.out.println("ChatClient.windowClosing()");
		//TODO
		System.exit(0);
	}
	
	public static void main(String[] args) {
		ChatClient sfc = new ChatClient();
	}	
}

