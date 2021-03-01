package panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
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

public class EditPanel extends JPanel {
	
	public JButton create_button;
	public JButton edit_button;
	public JButton back_button;
	public List<JLabel> pixels=new ArrayList<JLabel>();
	public JTextField create_field;
	public Boolean create = false;
	JPanel current = this;
	
	public EditPanel() {
		CreatePanel();
	}
	
	private void CreatePanel() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setPreferredSize(screenSize);
		this.setBackground(Color.GREEN);
		this.setLayout(null);
		
		create_button = new JButton("Create New");
		edit_button = new JButton("Edit Existing");
		back_button = new JButton("Back");
		create_button.setBounds(screenSize.width/2-100, screenSize.height/2, 200, 40);
		edit_button.setBounds(screenSize.width/2-100, screenSize.height/2+50, 200, 40);
		back_button.setBounds(screenSize.width/2-100, screenSize.height/2+100, 200, 40);
		this.add(back_button);
		this.add(create_button);
		this.add(edit_button);
		
		create_field = new JTextField(10);
		create_field.setBounds(screenSize.width/2-115, screenSize.height/2+50, 230, 40);
		create_field.setVisible(false);
		create_field.setText("type your game name here and click create");
		this.add(create_field);
		
		
		
		ImageIcon img_black = new ImageIcon("src/images/black.jpg");
		for (int y = 0; y< screenSize.height-10; y= y+ 10) {
			for (int x = 0; x< screenSize.width-10; x = x+ 10) {
				if (!(x > screenSize.width/2-130 && x < screenSize.width/2-100+230 && y >screenSize.height/2-30 && y <screenSize.height/2+100+70)) {
					if (x >80 || y<screenSize.height-90) {
						JLabel pixel = new JLabel();
						pixel.setBounds(x, y, 10, 10);
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
		ImageIcon img_red = new ImageIcon("src/images/red.jpg");
		reset.setIcon(img_red);
		reset.setBounds(0, screenSize.height-80, 80, 80);
		reset.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				for(JLabel i: pixels) {
					i.setIcon(null);
				}
			}
		});
		
		this.add(reset);
		
		this.add(back_button);
		this.add(create_button);
		this.add(edit_button);
		
	}
}
