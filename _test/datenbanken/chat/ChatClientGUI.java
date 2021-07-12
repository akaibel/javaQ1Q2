package _test.datenbanken.chat;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ChatClientGUI extends javax.swing.JFrame {
	private JTextArea messageTextArea;
	private JScrollPane textAreaScrollPane;
	
	private ChatClient client;
	private JTextField inputTextField;

	public ChatClientGUI(ChatClient pClient) {
		super();
		this.client = pClient;
		initGUI();
		setVisible(true);
	}
	
	private void initGUI() {
		try {
			this.setTitle("SIBI Informatik Chat");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(new BorderLayout());
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					client.windowClosing();
					System.exit(0);
				}
			});
			{
				textAreaScrollPane = new JScrollPane();
				getContentPane().add(textAreaScrollPane);
				//textAreaScrollPane.setBounds(12, 88, 353, 162);
				{
					messageTextArea = new JTextArea();
					messageTextArea.setEditable(false);
					messageTextArea.setColumns(30);
					messageTextArea.setRows(20);
					textAreaScrollPane.setViewportView(messageTextArea);
					messageTextArea.setFocusable(false);
				}
			}
			
			JPanel inputPanel = new JPanel();
			getContentPane().add(inputPanel, BorderLayout.SOUTH);
			inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			inputTextField = new JTextField();
			inputTextField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent arg0) {
					// auf ENTER ueberpruefen
					if(arg0.getKeyCode() == 10){
						send();
					}
				}
			});
			inputPanel.add(inputTextField);
			inputTextField.setColumns(30);
			
			JButton inputButton = new JButton("send");
			inputButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					send();
				}
			});
			inputPanel.add(inputButton);
			pack();
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public void send(){
		String text = this.inputTextField.getText();
		this.inputTextField.setText("");
		this.client.send(text);
	}
	
	public void addMessage(String pMessage){
		this.messageTextArea.append(pMessage+"\n");
		messageTextArea.setCaretPosition(messageTextArea.getDocument().getLength());
	}
}
