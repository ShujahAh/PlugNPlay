package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class OptionPanel extends JPanel {

	public OptionPanel() {
		CreatePanel();
	}
	
	private void CreatePanel() {
	
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setPreferredSize(screenSize);
		this.setBackground(Color.blue);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(0, screenSize.height/25));
	}
}
