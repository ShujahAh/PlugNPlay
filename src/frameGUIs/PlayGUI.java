package frameGUIs;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dataManipulation.FileRead;
import templates.Template;

public class PlayGUI {
	private JFrame frame;
	private JPanel rootPanel;
	
	final static String ABOUT = "Panel for About Page";
	final static String EDIT = "Panel for Edit Page";
	final static String INSESSION = "Panel for if User isnt using the menu window";
	final static String PLAY = "Panel for Play Page";
	final static String MENU = "Panel for Main Page";
	
	private List<Template> templates=new ArrayList<Template>(); 

	public PlayGUI(File file, JPanel menuRootPanel) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		FileRead p = new FileRead(file.toString());
		templates = p.getTemplates();
		CardLayout tmp = (CardLayout)(menuRootPanel.getLayout());
		tmp.show(menuRootPanel, INSESSION);
		createFrame();
	}
	
	private void createFrame() {
		frame = new JFrame("PlugNPlay");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setPreferredSize(screenSize);
		//frame.setLayout(null);
		ImageIcon img = new ImageIcon("src/images/logo.png");
		frame.setIconImage(img.getImage());
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
		

	
}
