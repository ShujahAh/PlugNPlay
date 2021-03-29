package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
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
	public JButton quit_button;
	public JLabel title_label;
	public JLabel background;
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
		quit_button = new JButton("Quit");
		
		title_label = new JLabel("PlugNPlay");
		
		ImageIcon image_button = new ImageIcon(new ImageIcon("src/images/button.png").getImage().getScaledInstance( screenSize.width/5+130, screenSize.height/15+40, Image.SCALE_DEFAULT));
		ImageIcon image_button_up = new ImageIcon(new ImageIcon("src/images/button_up.png").getImage().getScaledInstance( screenSize.width/5+130, screenSize.height/15+37, Image.SCALE_DEFAULT));
		ImageIcon image_menu_background = new ImageIcon(new ImageIcon("src/images/menu_background.jpg").getImage().getScaledInstance( screenSize.width, screenSize.height, Image.SCALE_DEFAULT));
		ImageIcon image_title = new ImageIcon(new ImageIcon("src/images/map.png").getImage().getScaledInstance( screenSize.width/2, screenSize.height/3, Image.SCALE_DEFAULT));

		title_label.setIcon(image_title);
		title_label.setFont(new Font("Comic Sans MS", Font.ITALIC, 135));
		title_label.setHorizontalTextPosition(JButton.CENTER);
		title_label.setVerticalTextPosition(JButton.CENTER);
		
		background = new JLabel();
		background.setIcon(image_menu_background);
		background.setBounds(0, 0, screenSize.width, screenSize.height);
		
		title_label.setBounds(screenSize.width/2-(screenSize.width/4), screenSize.height/9, screenSize.width/2, screenSize.height/3);
		play_button.setBounds(screenSize.width/2-(screenSize.width/10), screenSize.height/2, screenSize.width/5, screenSize.height/15);
		edit_button.setBounds(screenSize.width/2-(screenSize.width/10), screenSize.height/2+(screenSize.height/15)+10, screenSize.width/5, screenSize.height/15);
		about_button.setBounds(screenSize.width/2-(screenSize.width/10), screenSize.height/2+(screenSize.height/15*2)+20, screenSize.width/5, screenSize.height/15);
		quit_button.setBounds(screenSize.width/2-(screenSize.width/10), screenSize.height/2+(screenSize.height/15*3)+30, screenSize.width/5, screenSize.height/15);
		
		
		play_button.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
		play_button.setIcon(image_button);
		play_button.setHorizontalTextPosition(JButton.CENTER);
		play_button.setVerticalTextPosition(JButton.CENTER);
		play_button.setMargin(new Insets(0,0,0,0));
		play_button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				play_button.setIcon(image_button_up);
			}
			
			public void mouseExited(MouseEvent e) {
				play_button.setIcon(image_button);
			}
		});
		edit_button.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
		edit_button.setIcon(image_button);
		edit_button.setHorizontalTextPosition(JButton.CENTER);
		edit_button.setVerticalTextPosition(JButton.CENTER);
		edit_button.setMargin(new Insets(0,0,0,0));
		edit_button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				edit_button.setIcon(image_button_up);
			}
			
			public void mouseExited(MouseEvent e) {
				edit_button.setIcon(image_button);
			}
		});
		about_button.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
		about_button.setIcon(image_button);
		about_button.setHorizontalTextPosition(JButton.CENTER);
		about_button.setVerticalTextPosition(JButton.CENTER);
		about_button.setMargin(new Insets(0,0,0,0));
		about_button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				about_button.setIcon(image_button_up);
			}
			
			public void mouseExited(MouseEvent e) {
				about_button.setIcon(image_button);
			}
		});
		quit_button.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
		quit_button.setIcon(image_button);
		quit_button.setHorizontalTextPosition(JButton.CENTER);
		quit_button.setVerticalTextPosition(JButton.CENTER);
		quit_button.setMargin(new Insets(0,0,0,0));
		quit_button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				quit_button.setIcon(image_button_up);
			}
			
			public void mouseExited(MouseEvent e) {
				quit_button.setIcon(image_button);
			}
		});
		
		recreateBubbles();
		
		
		
		
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
		this.add(quit_button);
		this.add(background);
		
	}
	
	public void recreateBubbles() {
		this.remove(background);
		for (JLabel i: bubbles) {
			i.setVisible(false);
			this.remove(i);
			this.validate();
			this.repaint();
		}
		ImageIcon img_bubble = new ImageIcon("src/images/bubble.png");
		ImageIcon img_pop = new ImageIcon("src/images/pop.png");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		for (int i=0; i< 5; i++) {
			JLabel bubble = new JLabel();
			int width = (int)(Math.random()*(screenSize.width-154));
			int height = (int)(Math.random() *(screenSize.height-146));
			while ((width >screenSize.width/2-200-154 && width<screenSize.width/2-200+421) && height < screenSize.height/2+230) {
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
		this.add(background);
		this.validate();
		this.repaint();
		
	}
}

