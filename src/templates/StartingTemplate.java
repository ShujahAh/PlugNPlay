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

public class StartingTemplate extends JPanel implements Template {
	
	private final String ID = "M";
	private String name;
	JPanel panel;
	JPanel editPanel;
	JScrollPane scroll;
	JLabel background;
	JLabel title;
	JButton add;

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	ImageIcon image_edit = new ImageIcon(new ImageIcon("src/images/starting.png").getImage().getScaledInstance(screenSize.width/3-10,screenSize.width/5, Image.SCALE_DEFAULT));
	ImageIcon image_act = new ImageIcon(new ImageIcon("src/images/starting.png").getImage().getScaledInstance(screenSize.width*3/4-20, (int) (screenSize.height/1.4), Image.SCALE_DEFAULT));
	ImageIcon image_button = new ImageIcon(new ImageIcon("src/images/starting.png").getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT));
	
	public StartingTemplate(String name) {
		this.name = name;
		createPanel();
	}
	
	public void createPanel() {
		background = new JLabel(image_edit);
		title = new JLabel(name);
		title.setBounds(screenSize.width/2, screenSize.height/2, 50, 50);
		background.add(title);
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
		return new StartingTemplate(name);
	}
	@Override
	public void setSizetoPlay(boolean yes) {
		if (yes) {
			background.setIcon(image_act);
			title.setBounds((int) (screenSize.width/3.7),(int) (screenSize.height/3), (int) (screenSize.width/4), screenSize.height/10);
			title.setFont(new Font(title.getFont().getFontName(), Font.BOLD, 80));
			
		}else {
			background.setIcon(image_edit);
			title.setBounds((int) (screenSize.width/8.5),(int) (screenSize.height/7), screenSize.width/3, screenSize.height/20);
			title.setFont(new Font(title.getFont().getFontName(), Font.BOLD, 40));
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
