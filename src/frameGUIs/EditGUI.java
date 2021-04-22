package frameGUIs;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dataManipulation.FileRead;
import dataManipulation.FileSave;
import panels.CreationPanel;
import panels.OptionPanel;
import panels.PreviewPanel;
import panels.TemplatePanel;
import templates.Template;

public class EditGUI {

	private JFrame frame;
	private JPanel rootPanel;
	private File gameFile;
	private JPanel editpanel;
	public JPanel editMain;
	public JPanel helpMain;
	public CreationPanel create;
	public OptionPanel options;
	public PreviewPanel preview;
	public TemplatePanel template;
	public JLabel background;
	
	
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
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);
		
		editpanel = new JPanel(new CardLayout());
		
		editMain = new JPanel(new BorderLayout());
		helpMain = new JPanel(new BorderLayout());
		
		ImageIcon image_title = new ImageIcon(new ImageIcon("src/images/HelpGuide.png").getImage().getScaledInstance( screenSize.width, screenSize.height, Image.SCALE_DEFAULT));
		background = new JLabel(image_title);
		background.setBounds(0, 0, screenSize.width, screenSize.height);
		helpMain.add(background);
		
		editpanel.add(editMain, "Main");
		editpanel.add(helpMain, "Help");
		
		create = new CreationPanel(this);
		options = new OptionPanel();
		preview = new PreviewPanel(this);
		template = new TemplatePanel(this);
		
		options.help.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout tmp = (CardLayout)(editpanel.getLayout());
				tmp.show(editpanel, "Help");
			}
			
		});
		
		background.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CardLayout tmp = (CardLayout)(editpanel.getLayout());
				tmp.show(editpanel, "Main");
			}

		});
		
		
		editMain.add(options, BorderLayout.NORTH);
		editMain.add(preview, BorderLayout.SOUTH);
		editMain.add(create, BorderLayout.EAST);
		editMain.add(template, BorderLayout.CENTER);
		
		preview.done.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Template> data = preview.templates;
				FileSave saving = new FileSave(gameFile);
				try {
					saving.SaveData(data);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
				CardLayout tmp = (CardLayout)(rootPanel.getLayout());
				tmp.show(rootPanel, MENU);
			}
			
		});
		
		options.exit.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				options.exit_l.setVisible(true);
				options.help.setPreferredSize(new Dimension(screenSize.width/3-screenSize.width/17-5, screenSize.height/25));
			}
			
			public void mouseExited(MouseEvent e) {
				options.exit_l.setVisible(false);
				options.help.setPreferredSize(new Dimension(screenSize.width/3-screenSize.width/17 + screenSize.width/30-10, screenSize.height/25));
			}
			
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to exit without saving?") == JOptionPane.YES_OPTION) {
					frame.dispose();
					CardLayout tmp = (CardLayout)(rootPanel.getLayout());
					tmp.show(rootPanel, MENU);
				}
				
			}
		});
		
		frame.add(editpanel);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	
}
