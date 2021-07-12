package telnet;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public abstract class TelnetGUI{
	private JFrame frame;
	private JTextArea textArea;
	private JButton sendButton;
	private JButton reconnectButton;
	private JTextField inputField;
	private JPanel northPanel;
	private JScrollPane textAreaScrollPane;
	private int fontSize = 12;

	public TelnetGUI() {
		schriftgroesseSetzen(fontSize);		
		initGUI();
	}
	
	private void schriftgroesseSetzen(int pGroesse) {
		Font f = new Font("Arial", Font.PLAIN, pGroesse);
		if(textArea != null) textArea.setFont(f);
		if(inputField != null) inputField.setFont(f);
	}

	private void initGUI() {
		try {
			frame = new JFrame();
			frame.setTitle("TelnetGUI");
//			frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			frame.getContentPane().setLayout(new BorderLayout());
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
//					System.out.println("this.windowClosing, event="+evt);
					System.exit(0);
				}
			});
			{
				textAreaScrollPane = new JScrollPane();
				//textAreaScrollPane.setBounds(12, 88, 353, 362);
				textAreaScrollPane.setSize(new Dimension(200, 300));
				{
					textArea = new JTextArea();
					//textArea.setPreferredSize(new Dimension(200, 300));
					textArea.setFocusable(false);
					textArea.setEditable(false);
					textAreaScrollPane.setViewportView(textArea);
				}
				frame.getContentPane().add(textAreaScrollPane, BorderLayout.CENTER);
			}
			{
				inputField = new JTextField();
				inputField.setText("");
				inputField.addKeyListener(new KeyListener(){

					
					public void keyPressed(KeyEvent arg0) {
						if(arg0.getKeyCode() == 10){
							String message = inputField.getText();
							if(message != null && !message.isEmpty()){
								neuerText(message);
							}
							inputField.setText("");
						}
					}

					
					public void keyReleased(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					
					public void keyTyped(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				});
				//inputField.setBounds(12, 34, 250, 30);
				inputField.setPreferredSize(new Dimension(200, 30));
			}
			{
				sendButton = new JButton();
				sendButton.setText("send");
				//sendButton.setBounds(278, 34, 90, 30);
				sendButton.setSize(90,30);
				sendButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String message = inputField.getText();
						if(message != null && !message.isEmpty()){
							neuerText(message);
						}
						inputField.setText("");
					}

				});
			}
			{
				reconnectButton = new JButton();
				reconnectButton.setText("reconnect");
				//reconnectButton.setBounds(278, 34, 90, 30);
				reconnectButton.setSize(90,30);
				reconnectButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						reconnect();
					}

				});
			}
			this.northPanel = new JPanel();
			northPanel.setLayout(new FlowLayout());
			northPanel.add(inputField);
			northPanel.add(sendButton);
			northPanel.add(reconnectButton);
			frame.getContentPane().add(northPanel, BorderLayout.NORTH);
			
			
			// KeyListener
			KeyListener k = new MyKeyListener();
			frame.addKeyListener(k);
			inputField.addKeyListener(k);
			textArea.addKeyListener(k);
			
			
			frame.pack();
			frame.setSize(400, 500);
			frame.setVisible(true);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public void setTitle(String pText){
		this.frame.setTitle(pText);
	}
	
	public abstract void neuerText(String pText);
	public abstract void reconnect();

	public void textAnhaengen(String pText){
		if(textArea != null){
			this.textArea.append(pText+"\n");
			textArea.setCaretPosition(textArea.getDocument().getLength());
		}
	}	
	
	public void textLoeschen(){
		if(textArea != null){
			this.textArea.setText("");
			textArea.setCaretPosition(textArea.getDocument().getLength());
		}
		
	}
	
	protected JFrame getFrame() {
		// TODO Auto-generated method stub
		return this.frame;
	}
	
	private class MyKeyListener implements KeyListener{
			public void keyPressed(KeyEvent arg0) {}

			public void keyReleased(KeyEvent arg0) {
				// STRG+ abfragen
				if(arg0.getKeyCode() == 521 && arg0.getModifiers() == 2){
					fontSize++;
					schriftgroesseSetzen(fontSize);
					
				}
				// STRG- abfragen
				else if(arg0.getKeyCode() == 45 && arg0.getModifiers() == 2){
					fontSize--;
					schriftgroesseSetzen(fontSize);
				}					
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	}
}
