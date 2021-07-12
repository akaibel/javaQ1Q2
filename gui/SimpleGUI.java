package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public abstract class SimpleGUI{
	private JFrame frame;
	private JTextArea textArea;
	private JButton sendenButton;
	private JTextField textField;
	private JScrollPane textAreaScrollPane;

	public SimpleGUI() {
		initGUI();
	}
	
	private void initGUI() {
		try {
			frame = new JFrame();
			frame.setTitle("SimpleGUI");
			frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
//					System.out.println("this.windowClosing, event="+evt);
					System.exit(0);
				}
			});
			{
				textAreaScrollPane = new JScrollPane();
				frame.getContentPane().add(textAreaScrollPane);
				textAreaScrollPane.setBounds(12, 88, 353, 162);
				{
					textArea = new JTextArea();
					textAreaScrollPane.setViewportView(textArea);
					textArea.setFocusable(false);
					textArea.setEditable(false);
				}
			}
			{
				textField = new JTextField();
				frame.getContentPane().add(textField);
				textField.setText("");
				textField.addKeyListener(new KeyListener(){

					
					public void keyPressed(KeyEvent arg0) {
						if(arg0.getKeyCode() == 10){
							String message = textField.getText();
							neuerText(message);
						}
					}

					
					public void keyReleased(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					
					public void keyTyped(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				});
				textField.setBounds(12, 34, 248, 23);
			}
			{
				sendenButton = new JButton();
				frame.getContentPane().add(sendenButton);
				sendenButton.setText("senden");
				sendenButton.setBounds(278, 34, 87, 23);
				sendenButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String message = textField.getText();
						neuerText(message);
					}

				});
			}
			frame.pack();
			frame.setSize(400, 300);
			frame.setVisible(true);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public abstract void neuerText(String pText);

	public void textAnhaengen(String pText){
		if(textArea != null){
			this.textArea.append(pText+"\n");
			textArea.setCaretPosition(textArea.getDocument().getLength());
		}
	}	
	
	protected JFrame getFrame() {
		// TODO Auto-generated method stub
		return this.frame;
	}
	
}
