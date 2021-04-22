package panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Document;

public class EditPanel extends JPanel {
	
	public JButton create_button;
	public JButton edit_button;
	public JButton back_button;
	public JLabel title;
	public List<JLabel> pixels=new ArrayList<JLabel>();
	public JTextField create_field;
	public Boolean create = false;
	public Boolean ready_to_input = false;
	JPanel current = this;
	
	public EditPanel() {
		CreatePanel();
	}
	
	private void CreatePanel() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setPreferredSize(screenSize);
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(null);
		
		create_button = new JButton("Create New");
		edit_button = new JButton("Edit Existing");
		back_button = new JButton("Back");
		
		ImageIcon image_button = new ImageIcon(new ImageIcon("src/images/button.png").getImage().getScaledInstance(screenSize.width/4+40, screenSize.height/9, Image.SCALE_DEFAULT));
		ImageIcon image_button_up = new ImageIcon(new ImageIcon("src/images/button_up.png").getImage().getScaledInstance( screenSize.width/4+40, screenSize.height/9, Image.SCALE_DEFAULT));
		ImageIcon image_title = new ImageIcon(new ImageIcon("src/images/editcreatetitle.png").getImage().getScaledInstance( screenSize.width/3, screenSize.height/7, Image.SCALE_DEFAULT));

		title = new JLabel(image_title);
		
		title.setBounds(screenSize.width/2-(screenSize.width/4), screenSize.height/12, screenSize.width/2, screenSize.height/3);
		create_button.setBounds(screenSize.width/2-(screenSize.width/10), screenSize.height/2, screenSize.width/5, screenSize.height/15);
		edit_button.setBounds(screenSize.width/2-(screenSize.width/10), screenSize.height/2+(screenSize.height/15)+10, screenSize.width/5, screenSize.height/15);
		back_button.setBounds(screenSize.width/2-(screenSize.width/10), screenSize.height/2+(screenSize.height/15*2)+20, screenSize.width/5, screenSize.height/15);
		
		create_button.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
		create_button.setIcon(image_button);
		create_button.setHorizontalTextPosition(JButton.CENTER);
		create_button.setVerticalTextPosition(JButton.CENTER);
		create_button.setMargin(new Insets(0,0,0,0));
		create_button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				create_button.setIcon(image_button_up);
			}
			
			public void mouseExited(MouseEvent e) {
				create_button.setIcon(image_button);
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
		
		this.add(back_button);
		this.add(create_button);
		this.add(edit_button);
		
		create_field = new JTextField(10);
		create_field.setBounds(screenSize.width/2-(screenSize.width/10),screenSize.height/2+(screenSize.height/15)+10, screenSize.width/5, screenSize.height/18);
		create_field.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		create_field.setVisible(false);
		create_field.setDocument(new JTextFieldLimit(45));
		create_field.setText("Type Your Game Name Here And Click Create");
		create_field.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (!ready_to_input) {
					ready_to_input = true;
					create_field.setText("");
				}
			}
		});
		this.add(create_field);
		
		
		
		ImageIcon img_black = new ImageIcon("src/images/black.jpg");
		for (int y = 0; y< screenSize.height-20; y= y+ 20) {
			for (int x = 0; x< screenSize.width-20; x = x+ 20) {
				if (!(x > screenSize.width/2-170 && x < screenSize.width/2-100+260 && y >screenSize.height/2-30 && y <screenSize.height/2+100+90)) {
					if (x >screenSize.width/12 ) {
						JLabel pixel = new JLabel();
						pixel.setBounds(x, y, 20, 20);
						pixel.addMouseListener(new MouseAdapter() {
							public void mouseEntered(MouseEvent e) {
								pixel.setIcon(img_black);
							}
						});
						this.add(pixel);
						pixels.add(pixel);
					}
				}
				
			}
		}
		
		JLabel reset = new JLabel();
		ImageIcon image_erase = new ImageIcon(new ImageIcon("src/images/erase.png").getImage().getScaledInstance(screenSize.width/12, screenSize.height/12, Image.SCALE_DEFAULT));

		reset.setIcon(image_erase);
		reset.setBounds(0, 0,screenSize.width/12, screenSize.height/12);
		reset.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				for(JLabel i: pixels) {
					i.setIcon(null);
				}
			}
		});
		
		this.add(reset);
		
		this.add(title);
		this.add(back_button);
		this.add(create_button);
		this.add(edit_button);
		
	}
}


