package templates;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public interface Template {
	public String getText();
	public ImageIcon getImage();
	public JPanel getPanel();
	public JScrollPane getEditPanel();
	public Template getInstance();
	public void setSizetoPlay(boolean yes);
	public JButton getAddButton();
	public JPanel getRealEditPanel();
}
