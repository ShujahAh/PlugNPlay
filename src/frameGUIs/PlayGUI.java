package frameGUIs;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dataManipulation.FileRead;
import dataManipulation.FileSave;
import templates.Template;

public class PlayGUI {
	private JFrame frame;
	private JPanel rootPanel;
	
	public JPanel mainPanel;
	
	public JPanel topPanel;
	public JButton exit_button;
	
	public JPanel bottomPanel;
	public JPanel midPanel;
	public JPanel rightPanel;
	public JPanel leftPanel;
	
	public int count= 1;
	
	final static String ABOUT = "Panel for About Page";
	final static String EDIT = "Panel for Edit Page";
	final static String INSESSION = "Panel for if User isnt using the menu window";
	final static String PLAY = "Panel for Play Page";
	final static String MENU = "Panel for Main Page";
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	private List<Template> templates=new ArrayList<Template>(); 
	private List<JLabel> number_reps=new ArrayList<JLabel>(); 
	
	public PlayGUI(File file, JPanel menuRootPanel) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		FileRead p = new FileRead(file.toString());
		templates = p.getTemplates();
		CardLayout tmp = (CardLayout)(menuRootPanel.getLayout());
		tmp.show(menuRootPanel, INSESSION);
		rootPanel = menuRootPanel;
		createFrame();
		loadTemplates();
	}
	
	private void createFrame() {
		frame = new JFrame("PlugNPlay");
		frame.setPreferredSize(screenSize);
		//frame.setLayout(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);
		
		ImageIcon img = new ImageIcon("src/images/logo.png");
		frame.setIconImage(img.getImage());
		
		mainPanel = new JPanel(new BorderLayout());
		topPanel = new JPanel(new BorderLayout());
		topPanel.setBackground(Color.LIGHT_GRAY);
		topPanel.setPreferredSize(new Dimension(0, screenSize.height/7));
		bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.white);
		bottomPanel.setPreferredSize(new Dimension(0, screenSize.height/7));
		midPanel = new JPanel(new CardLayout());
		rightPanel = new JPanel();
		rightPanel.setPreferredSize(new Dimension(screenSize.width/7, 0 ));
		leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(screenSize.width/7, 0 ));
		
		ImageIcon image_exit = new ImageIcon(new ImageIcon("src/images/exit.png").getImage().getScaledInstance( screenSize.height/6+40, screenSize.height/6+40, Image.SCALE_DEFAULT));
		exit_button = new JButton(image_exit);
		exit_button.setMargin(new Insets(0,0,0,0));
		exit_button.setPreferredSize(new Dimension( screenSize.height/7, screenSize.height/7));
		exit_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?") == JOptionPane.YES_OPTION) {
					frame.dispose();
					CardLayout tmp = (CardLayout)(rootPanel.getLayout());
					tmp.show(rootPanel, MENU);
				}
			}
			
		});
		
		
		frame.add(mainPanel);
		
		mainPanel.add(topPanel, BorderLayout.NORTH);
		topPanel.add(exit_button, BorderLayout.EAST);
		
		mainPanel.add(midPanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		mainPanel.add(leftPanel, BorderLayout.WEST);
		mainPanel.add(rightPanel, BorderLayout.EAST);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void loadTemplates() {
		JPanel tmp;
		JComponent tmp_comp = null;
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/images/nonNumber.png").getImage().getScaledInstance(screenSize.height/9, screenSize.height/9, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_done = new ImageIcon(new ImageIcon("src/images/Number.png").getImage().getScaledInstance(screenSize.height/9, screenSize.height/9, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_current = new ImageIcon(new ImageIcon("src/images/Number_current.png").getImage().getScaledInstance(screenSize.height/9, screenSize.height/9, Image.SCALE_DEFAULT));

		for (int y= 1; y < templates.size()-1; y++) {
			Template i = templates.get(y);
			tmp = i.getPanel();
			i.setSizetoPlay(true);
			midPanel.add(tmp, String.valueOf(count));
			JLabel number_rep = new JLabel(String.valueOf(count));
			number_rep.setHorizontalTextPosition(JLabel.CENTER);
			number_rep.setIcon(imageIcon);
			number_reps.add(number_rep);
			bottomPanel.add(number_rep);
			if (tmp_comp != null) {
				tmp_comp.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						count += 1;
						CardLayout tmp = (CardLayout)(midPanel.getLayout());
						tmp.show(midPanel, String.valueOf(count));
						
						for (int y = 0; y < count-1; y++) {
							number_reps.get(y).setIcon(imageIcon_done);
						}
						number_reps.get(count-1).setIcon(imageIcon_current);
						
					}
				});
			}
			count += 1;
			
			tmp_comp = i.getComponentToAdvance();
		}
		number_reps.get(0).setIcon(imageIcon_current);
		 
		count = 1;
	}
		

	
}
