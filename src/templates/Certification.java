package templates;

import javax.swing.JPanel;

public class Certification extends JPanel implements Template {

	private String name;
	public Certification(String name) {
		this.name = name;
	}
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return "cert";
	}
}
