package templates;

import java.util.List;

import javax.swing.JPanel;

public class Test extends JPanel implements Template {

	public Test(List<String> data){
		System.out.println("worked");
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return "pop";
	}

}
