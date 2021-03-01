package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import templates.Template;

public class MenuPanel extends JPanel {
	
	public JButton play_button;
	public JButton edit_button;
	public JButton about_button;
	public JLabel title_label;
	public List<JLabel> bubbles=new ArrayList<JLabel>(); 

	public MenuPanel(){
		CreatePanel();
	}
	
	private void CreatePanel() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setPreferredSize(screenSize);
		this.setBackground(Color.CYAN);
		this.setLayout(null);
		
		play_button = new JButton("Play");
		edit_button = new JButton("Edit/Create");
		about_button = new JButton("About");
		play_button.setBounds(screenSize.width/2-100, screenSize.height/2, 200, 40);
		edit_button.setBounds(screenSize.width/2-100, screenSize.height/2+50, 200, 40);
		about_button.setBounds(screenSize.width/2-100, screenSize.height/2+100, 200, 40);
		recreateBubbles();
		
		title_label = new JLabel();
		title_label.setBounds(screenSize.width/2-200, screenSize.height/2-400, 421, 332);
		ImageIcon img = new ImageIcon("src/images/logo.png");
		title_label.setIcon(img);
		System.out.println(screenSize.width);
		System.out.println(screenSize.height);
		ImageIcon img_bubble = new ImageIcon("src/images/bubble.png");
		ImageIcon img_pop = new ImageIcon("src/images/pop.png");
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				recreateBubbles();
			}
		});
		
		
		
		this.add(title_label);
		this.add(play_button);
		this.add(edit_button);
		this.add(about_button);
		
	}
	
	public void recreateBubbles() {
		for (JLabel i: bubbles) {
			i.setVisible(false);
		}
		ImageIcon img_bubble = new ImageIcon("src/images/bubble.png");
		ImageIcon img_pop = new ImageIcon("src/images/pop.png");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		for (int i=0; i< 8; i++) {
			JLabel bubble = new JLabel();
			int width = (int)(Math.random()*(screenSize.width-154));
			int height = (int)(Math.random() *(screenSize.height-146));
			while ((width >screenSize.width/2-200-154 && width<screenSize.width/2-200+421) && height < screenSize.height/2+140) {
				width = (int)(Math.random()*(screenSize.width-154));
				height = (int)(Math.random() *(screenSize.height-146));
			}
			
			bubble.setBounds(width, height, 154, 146);
			bubble.setIcon(img_bubble);
			bubble.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					bubble.setIcon(img_pop);
				}
			});
			bubbles.add(bubble);
		}
		for(JLabel i: bubbles) {
			this.add(i);
		}
	}
}

