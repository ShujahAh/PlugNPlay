package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PlayPanel extends JPanel {
	
	public JButton back_button;
	
	public PlayPanel() {
		CreatePanel();
	}
	
	private void CreatePanel() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setPreferredSize(screenSize);
		this.setBackground(Color.pink);
		this.setLayout(null);
		
		back_button = new JButton("Back");
		back_button.setBounds(screenSize.width/2-100, screenSize.height/2+100, 200, 40);
		this.add(back_button);
	}
}
