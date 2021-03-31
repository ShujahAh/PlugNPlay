package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import frameGUIs.EditGUI;

public class OptionPanel extends JPanel {
	
	public JPanel left;
	public JPanel right;
	public JPanel rightSplit;
	public JLabel exit_l;
	public JLabel design;
	public JLabel title;
	public JButton help;
	public JButton exit;
	
	public OptionPanel() {
		CreatePanel();
	}
	
	private void CreatePanel() {
	
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setPreferredSize(screenSize);
		this.setBackground(Color.black);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(0, screenSize.height/25));
		
		left = new JPanel();
		left.setPreferredSize(new Dimension(screenSize.width/3, screenSize.height/25));
		
		right = new JPanel(new BorderLayout());
		right.setPreferredSize(new Dimension(screenSize.width/3, screenSize.height/25));
		
		rightSplit = new JPanel(new BorderLayout());
		rightSplit.setPreferredSize(new Dimension(screenSize.width/17, screenSize.height/25));
		
		help = new JButton("Help");
		help.setPreferredSize(new Dimension(screenSize.width/3-screenSize.width/17 + screenSize.width/30-10, screenSize.height/25));
		
		exit_l = new JLabel("Exit:");
		exit_l.setPreferredSize(new Dimension(screenSize.width/30, screenSize.height/30));
		exit_l.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

		exit_l.setVisible(false);
		
		ImageIcon image_button = new ImageIcon(new ImageIcon("src/images/exit.png").getImage().getScaledInstance( screenSize.width/24, screenSize.height/24, Image.SCALE_DEFAULT));
		exit = new JButton(image_button);
		exit.setMargin(new Insets(0,0,0,0));
		exit.setPreferredSize(new Dimension(screenSize.width/30, screenSize.height/30));
		
		ImageIcon image_design = new ImageIcon(new ImageIcon("src/images/design.jpg").getImage().getScaledInstance( screenSize.width/3, screenSize.height/24, Image.SCALE_DEFAULT));
		design = new JLabel(image_design);
		
		ImageIcon image_title = new ImageIcon(new ImageIcon("src/images/editingprogram.png").getImage().getScaledInstance( screenSize.width/3, screenSize.height/24, Image.SCALE_DEFAULT));
		title = new JLabel(image_title);
		
		//left.add(help);
		rightSplit.add(exit_l, BorderLayout.WEST);
		rightSplit.add(exit, BorderLayout.EAST);
		right.add(help, BorderLayout.WEST);
		right.add(rightSplit, BorderLayout.EAST);
		
		this.add(design, BorderLayout.CENTER);
		this.add(title, BorderLayout.WEST);
		this.add(right, BorderLayout.EAST);
	}
}
