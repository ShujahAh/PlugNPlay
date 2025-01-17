package frameGUIs;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dataManipulation.FileRead;
import dataManipulation.FileSave;
import panels.AboutPanel;
import panels.EditPanel;
import panels.InSessionPanel;
import panels.MenuPanel;
import panels.PlayPanel;
import templates.Template;

public class MenuGUI {

	private JFrame frame;
	private JPanel rootPanel;
	private EditGUI editFrame;
	private PlayGUI	playFrame;
	
	
	final static String ABOUT = "Panel for About Page";
	final static String EDIT = "Panel for Edit Page";
	final static String INSESSION = "Panel for if User isnt using the menu window";
	final static String PLAY = "Panel for Play Page";
	final static String MENU = "Panel for Main Page";
	
	public MenuGUI() {
		createFrame();
		createRootPanel();
		
	}
	
	private void createFrame() {
		frame = new JFrame("PlugNPlay");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setPreferredSize(screenSize);
		//frame.setLayout(null);
		ImageIcon img = new ImageIcon("src/images/logo.png");
		frame.setIconImage(img.getImage());
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void createRootPanel() {
		rootPanel = new JPanel(new CardLayout());
		rootPanel.setPreferredSize(new Dimension(1400,800));
		rootPanel.setLocation(0, 0);
		frame.add(rootPanel);
		
		AboutPanel about = new AboutPanel();
		EditPanel edit = new EditPanel();
		InSessionPanel inSession = new InSessionPanel();
		MenuPanel menu = new MenuPanel();
		PlayPanel play = new PlayPanel();
		
		rootPanel.add(menu, MENU);
		rootPanel.add(about, ABOUT);
		rootPanel.add(edit, EDIT);
		rootPanel.add(inSession, INSESSION);
		rootPanel.add(play, PLAY);
		
		menu.play_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout tmp = (CardLayout)(rootPanel.getLayout());
				tmp.show(rootPanel, PLAY);
				JFileChooser chooser = new JFileChooser("src/gameFiles");
		        int option = chooser.showOpenDialog(null);
		        while (option == JFileChooser.APPROVE_OPTION && !chooser.getSelectedFile().toString().contains(".txt")) {
		        	JOptionPane.showMessageDialog(chooser, "Selected file was not a Game Text File");
		        	option = chooser.showOpenDialog(null);
		        }
		        if (option == JFileChooser.APPROVE_OPTION) {
			        try {
						playFrame = new PlayGUI( chooser.getSelectedFile(), rootPanel);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException | SecurityException
							| ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
			}
			
		});
		
		menu.edit_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout tmp = (CardLayout)(rootPanel.getLayout());
				tmp.show(rootPanel, EDIT);
			}
			
		});
		
		menu.about_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout tmp = (CardLayout)(rootPanel.getLayout());
				tmp.show(rootPanel, ABOUT);
			}
			
		});
		
		edit.back_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout tmp = (CardLayout)(rootPanel.getLayout());
				edit.edit_button.setVisible(true);
				edit.create_field.setVisible(false);
				edit.create = false;
				for(JLabel i: edit.pixels) {
					i.setIcon(null);
				}
				menu.recreateBubbles();
				tmp.show(rootPanel, MENU);
				
			}
			
		});
		
		edit.create_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!edit.create) {
					edit.edit_button.setVisible(false);
					edit.create_field.setVisible(true);
					edit.create = true;
				}
				else {
					if (edit.create_field.getText().isBlank() || edit.create_field.getText().contains(" ")) {
						JOptionPane.showMessageDialog(edit.create_field, "Game Name Is Not Applicable");
					}
					else {
						
						edit.create = false;
						edit.edit_button.setVisible(true);
						edit.create_field.setVisible(false);
						File game = new File("src/gameFiles/" + edit.create_field.getText()+".txt");
						try {
							editFrame = new EditGUI(game, rootPanel);
						} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
								| InvocationTargetException | NoSuchMethodException | SecurityException
								| ClassNotFoundException | FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
				
				for(JLabel i: edit.pixels) {
					i.setIcon(null);
				}
				
				
			}
			
		});
		
		edit.edit_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser("src/gameFiles");
				int option = chooser.showOpenDialog(null);
		        while (option == JFileChooser.APPROVE_OPTION && !chooser.getSelectedFile().toString().contains(".txt")) {
		        	JOptionPane.showMessageDialog(chooser, "Selected file was not a Game Text File");
		        	option = chooser.showOpenDialog(null);
		        }
		        if (option == JFileChooser.APPROVE_OPTION) {
		        	try {
						editFrame = new EditGUI( chooser.getSelectedFile(),rootPanel);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException | SecurityException
							| ClassNotFoundException | FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
		       
			}
			
		});
		

		play.back_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				menu.recreateBubbles();
				CardLayout tmp = (CardLayout)(rootPanel.getLayout());
				tmp.show(rootPanel, MENU);
			}
			
		});
		
		about.back_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				menu.recreateBubbles();
				CardLayout tmp = (CardLayout)(rootPanel.getLayout());
				tmp.show(rootPanel, MENU);
			}
			
		});
		
		menu.quit_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
			
		});
	}
}
