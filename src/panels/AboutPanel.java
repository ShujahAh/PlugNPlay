package panels;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AboutPanel extends JPanel {

	private JTextArea textField;
	public JButton back_button;
	public JLabel background;
	private JLabel title;
	
	public AboutPanel() {
		CreatePanel();
	}
	
	private void CreatePanel() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setPreferredSize(screenSize);
		this.setBackground(Color.white);
		this.setLayout(null);
		
		back_button = new JButton("Back");
		back_button.setBounds(screenSize.width/2-(screenSize.width/10), screenSize.height/2+200, screenSize.width/5, screenSize.height/17);
		
		ImageIcon image_background = new ImageIcon(new ImageIcon("src/images/shawarma.jpg").getImage().getScaledInstance( screenSize.width, screenSize.height, Image.SCALE_DEFAULT));
		ImageIcon image_button = new ImageIcon(new ImageIcon("src/images/button.png").getImage().getScaledInstance(screenSize.width/4+40, screenSize.height/9-10, Image.SCALE_DEFAULT));
		ImageIcon image_button_up = new ImageIcon(new ImageIcon("src/images/button_up.png").getImage().getScaledInstance( screenSize.width/4+40, screenSize.height/9-20, Image.SCALE_DEFAULT));
		ImageIcon image_title = new ImageIcon(new ImageIcon("src/images/About.png").getImage().getScaledInstance( screenSize.width/3, screenSize.height/7, Image.SCALE_DEFAULT));

		title = new JLabel(image_title);
		title.setBounds(screenSize.width/2-(screenSize.width/4), screenSize.height/12, screenSize.width/2, screenSize.height/3);
		
		back_button.setIcon(image_button);
		back_button.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
		back_button.setHorizontalTextPosition(JButton.CENTER);
		back_button.setVerticalTextPosition(JButton.CENTER);
		back_button.setMargin(new Insets(0,0,0,0));
		back_button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				back_button.setIcon(image_button_up);
			}
			
			public void mouseExited(MouseEvent e) {
				back_button.setIcon(image_button);
			}
		});
		
		background = new JLabel(image_background);
		background.setBounds(0, 0, screenSize.width, screenSize.height);
		
		textField = new JTextArea(5, 20);
		textField.setBounds(screenSize.width/2-(screenSize.width/6), screenSize.height/2-(screenSize.height/6), screenSize.width/3, screenSize.height/3);
		textField.setLineWrap(true);
		textField.setWrapStyleWord(true);
		textField.setText(">About:\r\n"
				+ ">PlugNPlay is an educational tool aimed at teachers of any kind to create game >like lessons for their student to play. These lessons are saved to a txt files >that can be distributed to the students who can also use PlugNPlay to play >them. These txt files can be found saved in the gameFiles folder within the >PlugNPlay files.\r\n"
				+ ">PlugNPlay was created by Ahmad Shujah for his Computer Science Degree. >There isn’t much else known about him besides that he likes Shawarma.\r\n"
				+ ">\n"
				+ ">Help:\r\n"
				+ ">To create a lesson, click the edit/create button. Then click either the edit and >existing button or a create a new button and follow the prompts.\r\n"
				+ ">To play a lesson, click the play button and pick the txt file that contains the >game. Please ask your teacher/creator of the lesson for the lesson you want >to play. \r\n"
				+ "");

		
		textField.setEditable(false);
		textField.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		JScrollPane areaScrollPane = new JScrollPane(textField);
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(250, 250));
		
		this.add(areaScrollPane);
		this.add(back_button);
		this.add(textField);
		this.add(title);
		this.add(background);
		
	}
}
