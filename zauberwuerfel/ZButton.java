package zauberwuerfel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ZButton extends JButton {

	public ZButton(String string) {
		super(string);
		this.setEnabled(false);
		this.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				changeColor();
			}
		});
	}
	
	private void changeColor(){
		int nr = 0;
		for(Color c: ZModel.farben){
			if(c == this.getBackground()){
				this.setBackground(ZModel.farben[(nr+1)%ZModel.farben.length]);
				return;
			}
			nr++;
		}
	}

}
