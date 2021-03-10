package frameGUIs;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dataManipulation.FileRead;
import panels.CreationPanel;
import panels.OptionPanel;
import panels.PreviewPanel;
import panels.TemplatePanel;
import templates.Template;

public class EditGUI {

	private JFrame frame;
	private JPanel rootPanel;
	private File gameFile;
	public CreationPanel create;
	public OptionPanel options;
	public PreviewPanel preview;
	public TemplatePanel template;
	
	
	final static String ABOUT = "Panel for About Page";
	final static String EDIT = "Panel for Edit Page";
	final static String INSESSION = "Panel for if User isnt using the menu window";
	final static String PLAY = "Panel for Play Page";
	final static String MENU = "Panel for Main Page";
	
	public List<Template> templates=new ArrayList<Template>(); 
	
	public EditGUI(File	 file,JPanel menuRootPanel) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, FileNotFoundException{
		if (file.exists()) {
			FileRead p = new FileRead(file.toString());
			templates = p.getTemplates();
		}
		else {
			PrintWriter writer = new PrintWriter(file);
			writer.close();
		}
		gameFile = file;
		
		CardLayout tmp = (CardLayout)(menuRootPanel.getLayout());
		tmp.show(menuRootPanel, INSESSION);
		rootPanel = menuRootPanel;
		createFrame();
	}
	
	private void createFrame() {
		frame = new JFrame("PlugNPlay");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setPreferredSize(screenSize);
		frame.setLayout(new BorderLayout());
		ImageIcon img = new ImageIcon("src/images/logo.png");
		frame.setIconImage(img.getImage());
		
		create = new CreationPanel(this);
		options = new OptionPanel();
		preview = new PreviewPanel(this);
		template = new TemplatePanel(this);
		
		
		frame.add(options, BorderLayout.NORTH);
		frame.add(preview, BorderLayout.SOUTH);
		frame.add(create, BorderLayout.EAST);
		frame.add(template, BorderLayout.CENTER);
		
		
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	
}
