package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AboutPanel extends JPanel {

	private JTextArea textField;
	public JButton back_button;
	
	public AboutPanel() {
		CreatePanel();
	}
	
	private void CreatePanel() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setPreferredSize(screenSize);
		this.setBackground(Color.red);
		this.setLayout(null);
		
		back_button = new JButton("Back");
		back_button.setBounds(screenSize.width/2-100, screenSize.height/2+200, 200, 40);
		
		
		
		textField = new JTextArea(5, 20);
		textField.setBounds(screenSize.width/2-200, screenSize.height/2-100, 400, 240);
		textField.setLineWrap(true);
		JScrollPane areaScrollPane = new JScrollPane(textField);
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(250, 250));
		this.add(areaScrollPane);
		this.add(back_button);
		this.add(textField);
		
	}
}
