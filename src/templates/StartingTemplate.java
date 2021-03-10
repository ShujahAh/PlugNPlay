package templates;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class StartingTemplate extends JPanel implements Template {
	
	private String name;
	public StartingTemplate(String name) {
		this.name = name;
	}
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return "start";
	}
	@Override
	public ImageIcon getImage() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public JScrollPane getEditPanel() {
		// TODO Auto-generated method stub
		return null;
	}
}
