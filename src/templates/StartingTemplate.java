package templates;

import javax.swing.JPanel;

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
}
