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

public class PlayPanel extends JPanel {
	
	public JButton back_button;
	public JLabel title;
	
	public PlayPanel() {
		CreatePanel();
	}
	
	private void CreatePanel() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setPreferredSize(screenSize);
		this.setBackground(Color.pink);
		this.setLayout(null);
		
		ImageIcon image_button = new ImageIcon(new ImageIcon("src/images/button.png").getImage().getScaledInstance( screenSize.width/5+130, screenSize.height/15+40, Image.SCALE_DEFAULT));
		ImageIcon image_button_up = new ImageIcon(new ImageIcon("src/images/button_up.png").getImage().getScaledInstance( screenSize.width/5+130, screenSize.height/15+37, Image.SCALE_DEFAULT));
		ImageIcon image_title = new ImageIcon(new ImageIcon("src/images/pickafile.png").getImage().getScaledInstance( screenSize.width/2, screenSize.height/5, Image.SCALE_DEFAULT));

		title = new JLabel(image_title);
		title.setBounds(screenSize.width/2-(screenSize.width/4), screenSize.height/12, screenSize.width/2, screenSize.height/3);
		
		back_button = new JButton("Back");

		back_button.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
		back_button.setIcon(image_button);
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
		back_button.setBounds(screenSize.width/2-(screenSize.width/10), screenSize.height/2, screenSize.width/5, screenSize.height/15);
		this.add(back_button);
		this.add(title);
	}
}
