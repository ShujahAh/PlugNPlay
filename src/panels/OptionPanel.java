package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OptionPanel extends JPanel {
	
	public JPanel left;
	public JPanel right;
	public JLabel sort;
	public JComboBox options;
	public JButton help;
	public OptionPanel() {
		CreatePanel();
	}
	
	private void CreatePanel() {
	
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setPreferredSize(screenSize);
		this.setBackground(Color.blue);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(0, screenSize.height/25));
		
		left = new JPanel();
		left.setPreferredSize(new Dimension(screenSize.width/3, screenSize.height/25));
		
		right = new JPanel();
		right.setPreferredSize(new Dimension(screenSize.width/3, screenSize.height/25));
		
		help = new JButton("Help");
		sort = new JLabel("Sort Templates By:");
		options = new JComboBox();
		
		right.add(help);
		
		left.add(sort);
		left.add(options);
		
		this.add(left, BorderLayout.WEST);
		this.add(right, BorderLayout.EAST);
	}
}
