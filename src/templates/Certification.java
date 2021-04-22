package templates;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Certification extends JPanel implements Template {
	
	private final String ID = "M";
	private String name;
	JPanel panel;
	JPanel editPanel;
	JScrollPane scroll;
	JLabel background;
	
	JButton add;

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	ImageIcon image_edit = new ImageIcon(new ImageIcon("src/images/congrats.jpg").getImage().getScaledInstance(screenSize.width/3-10,screenSize.width/5, Image.SCALE_DEFAULT));
	ImageIcon image_act = new ImageIcon(new ImageIcon("src/images/congrats.jpg").getImage().getScaledInstance(screenSize.width*3/4-20, (int) (screenSize.height/1.4), Image.SCALE_DEFAULT));
	ImageIcon image_button = new ImageIcon(new ImageIcon("src/images/congrats.jpg").getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT));
	
	public Certification(String name) {
		this.name = name;
		createPanel();
	}
	
	public void createPanel() {
		background = new JLabel(image_edit);
		editPanel = new JPanel();
		scroll = new JScrollPane();
		panel = new JPanel();
		panel.add(background);
		scroll.add(panel);
		
		add = new JButton();
		
	}
	
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return "start";
	}
	@Override
	public ImageIcon getImage() {
		// TODO Auto-generated method stub
		return image_button;
	}
	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return panel;
	}
	@Override
	public JScrollPane getEditPanel() {
		// TODO Auto-generated method stub
		return scroll;
	}
	@Override
	public Template getInstance() {
		// TODO Auto-generated method stub
		return new Certification(name);
	}
	@Override
	public void setSizetoPlay(boolean yes) {
		if (yes) {
			background.setIcon(image_act);
		
			
		}else {
			background.setIcon(image_edit);
			
		}
		
	}
	@Override
	public JButton getAddButton() {
		// TODO Auto-generated method stub
		return add;
	}
	@Override
	public JPanel getRealEditPanel() {
		// TODO Auto-generated method stub
		return editPanel;
	}
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return ID;
	}
	@Override
	public JComponent getComponentToAdvance() {
		// TODO Auto-generated method stub
		return panel;
	}
}
