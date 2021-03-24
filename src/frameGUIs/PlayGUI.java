package frameGUIs;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dataManipulation.FileRead;
import templates.Template;

public class PlayGUI {
	private JFrame frame;
	private JPanel rootPanel;
	public JPanel mainPanel;
	public JPanel topPanel;
	public JPanel bottomPanel;
	public JPanel midPanel;
	
	public int count= 1;
	
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
		loadTemplates();
	}
	
	private void createFrame() {
		frame = new JFrame("PlugNPlay");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setPreferredSize(screenSize);
		//frame.setLayout(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);
		
		ImageIcon img = new ImageIcon("src/images/logo.png");
		frame.setIconImage(img.getImage());
		
		mainPanel = new JPanel(new BorderLayout());
		topPanel = new JPanel();
		topPanel.setBackground(Color.LIGHT_GRAY);
		topPanel.setPreferredSize(new Dimension(0, screenSize.height/6));
		bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.LIGHT_GRAY);
		bottomPanel.setPreferredSize(new Dimension(0, screenSize.height/6));
		midPanel = new JPanel(new CardLayout());
		
		
		frame.add(mainPanel);
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(midPanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void loadTemplates() {
		JPanel tmp;
		JComponent tmp_comp = null;
		for (int y= 1; y < templates.size()-1; y++) {
			Template i = templates.get(y);
			tmp = i.getPanel();
			i.setSizetoPlay(true);
			midPanel.add(tmp, String.valueOf(count));
			if (tmp_comp != null) {
				tmp_comp.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						CardLayout tmp = (CardLayout)(midPanel.getLayout());
						tmp.show(midPanel, String.valueOf(count));
					}
				});
			}
			
			tmp_comp = i.getComponentToAdvance();
		}
	}
		

	
}
