package templates;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class StartingTemplate extends JPanel implements Template {
	
	private final String ID = "M";
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
	@Override
	public Template getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setSizetoPlay(boolean yes) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public JButton getAddButton() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public JPanel getRealEditPanel() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return ID;
	}
	@Override
	public JComponent getComponentToAdvance() {
		// TODO Auto-generated method stub
		return null;
	}
}
