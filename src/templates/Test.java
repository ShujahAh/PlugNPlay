package templates;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Test implements Template {

	public JPanel pane;
	public JPanel paneimg;
	public JPanel editpane;
	public JScrollPane panelPane;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	//text that will appear on the preview
	public JLabel text1_os;
	public JLabel text2_os;
	
	//buttons that will appear on the preview
	public JButton button1_os;
	public JButton button2_os;
	public JButton button3_os;
	public JButton button4_os;
	
	//buttons under each input option to preview the change
	public JButton add;
	public JButton preview1;
	public JButton preview2;
	public JButton preview3;
	public JButton preview4;
	public JButton preview5;
	public JButton preview6;
	
	//labels to label each set of input options
	public JLabel text1;
	public JLabel text2;
	public JLabel button1;
	public JLabel button2;
	public JLabel button3;
	public JLabel button4;
	
	//panels that will hold font, size, color for each set of input options
	public JPanel preview1_ops;
	public JPanel preview2_ops;
	public JPanel preview3_ops;
	public JPanel preview4_ops;
	public JPanel preview5_ops;
	public JPanel preview6_ops;
	
	//text area for each set of input options
	public JTextArea area1;
	public JTextArea area2;
	public JTextArea area3;
	public JTextArea area4;
	public JTextArea area5;
	public JTextArea area6;
	
	//color options for each set of input options
	public final String[] colors = {"White","Gray","Black","Red","Organge", "Yellow", "Green", "Blue"};
	public JLabel color1;
	public JLabel color2;
	public JLabel color3;
	public JLabel color4;
	public JLabel color5;
	public JLabel color6;
	public JComboBox color_op1;
	public JComboBox color_op2;
	public JComboBox color_op3;
	public JComboBox color_op4;
	public JComboBox color_op5;
	public JComboBox color_op6;
	
	//font options for each set of input options
	public final String[] fonts = {"Dialog","Helvetica","TimesR","Courier","Symbol"};
	public JLabel font1;
	public JLabel font2;
	public JLabel font3;
	public JLabel font4;
	public JLabel font5;
	public JLabel font6;
	public JComboBox font_op1;
	public JComboBox font_op2;
	public JComboBox font_op3;
	public JComboBox font_op4;
	public JComboBox font_op5;
	public JComboBox font_op6;
	
	
	
	public Test(List<String> data){
		System.out.println("worked");
		CreateTemplate();
	}
	
	private void CreateTemplate() {
		pane = new JPanel();
		pane.setBackground(Color.GRAY);
		pane.setLayout(new FlowLayout());
		
		editpane = new JPanel();
		editpane.setBackground(Color.magenta);
		editpane.setLayout(new FlowLayout());
		editpane.setPreferredSize(new Dimension(screenSize.width/3-20, 650));
		//editpane.setLocation(0, 0);
		
		add = new JButton("Add to Lesson");
		add.setPreferredSize(new Dimension(screenSize.width/3-30, 20));
		
		Dimension dem_labels =new Dimension(screenSize.width/3-20, 20);
		text1 = new JLabel("Text #1");
		text1.setPreferredSize(dem_labels);
		text2 = new JLabel("Text #2");
		text2.setPreferredSize(dem_labels);
		button1 = new JLabel("Button #1");
		button1.setPreferredSize(dem_labels);
		button2 = new JLabel("Button #2");
		button2.setPreferredSize(dem_labels);
		button3 = new JLabel("Button #3");
		button3.setPreferredSize(dem_labels);
		button4 = new JLabel("Button #4");
		button4.setPreferredSize(dem_labels);
		
		Dimension dem_textarea = new Dimension(screenSize.width/3-170, 80);
		area1 = new JTextArea();
		area1.setPreferredSize(dem_textarea);
		area1.setLineWrap(true);
		area2 = new JTextArea();
		area2.setPreferredSize(dem_textarea);
		area2.setLineWrap(true);
		area3 = new JTextArea();
		area3.setPreferredSize(dem_textarea);
		area3.setLineWrap(true);
		area4 = new JTextArea();
		area4.setPreferredSize(dem_textarea);
		area4.setLineWrap(true);
		area5 = new JTextArea();
		area5.setPreferredSize(dem_textarea);
		area5.setLineWrap(true);
		area6 = new JTextArea();
		area6.setPreferredSize(dem_textarea);
		area6.setLineWrap(true);
		
		Dimension dem_optionpanel = new Dimension(dem_textarea.width/4+45, 80);
		Color background_color = Color.lightGray;
		preview1_ops = new JPanel();
		preview1_ops.setPreferredSize(dem_optionpanel);
		preview1_ops.setBackground(background_color);
		preview2_ops = new JPanel();
		preview2_ops.setPreferredSize(dem_optionpanel);
		preview2_ops.setBackground(background_color);
		preview3_ops = new JPanel();
		preview3_ops.setPreferredSize(dem_optionpanel);
		preview3_ops.setBackground(background_color);
		preview4_ops = new JPanel();
		preview4_ops.setPreferredSize(dem_optionpanel);
		preview4_ops.setBackground(background_color);
		preview5_ops = new JPanel();
		preview5_ops.setPreferredSize(dem_optionpanel);
		preview5_ops.setBackground(background_color);
		preview6_ops = new JPanel();
		preview6_ops.setPreferredSize(dem_optionpanel);
		preview6_ops.setBackground(background_color);
		
		Dimension dem_colorlabel = new Dimension(dem_optionpanel.width/2-5, 22);
		color1 = new JLabel("Color:");
		color1.setPreferredSize(dem_colorlabel);
		color_op1 = new JComboBox(colors);
		color_op1.setPreferredSize(dem_colorlabel);
		font1 = new JLabel("Font:");
		font1.setPreferredSize(dem_colorlabel);
		font_op1 = new JComboBox(fonts);
		font_op1.setPreferredSize(dem_colorlabel);
		color2 = new JLabel("Color:");
		color2.setPreferredSize(dem_colorlabel);
		color_op2 = new JComboBox(colors);
		color_op2.setPreferredSize(dem_colorlabel);
		font2 = new JLabel("Font:");
		font2.setPreferredSize(dem_colorlabel);
		font_op2 = new JComboBox(fonts);
		font_op2.setPreferredSize(dem_colorlabel);
		color3 = new JLabel("Color:");
		color3.setPreferredSize(dem_colorlabel);
		color_op3 = new JComboBox(colors);
		color_op3.setPreferredSize(dem_colorlabel);
		font3 = new JLabel("Font:");
		font3.setPreferredSize(dem_colorlabel);
		font_op3 = new JComboBox(fonts);
		font_op3.setPreferredSize(dem_colorlabel);
		color4 = new JLabel("Color:");
		color4.setPreferredSize(dem_colorlabel);
		color_op4 = new JComboBox(colors);
		color_op4.setPreferredSize(dem_colorlabel);
		font4 = new JLabel("Font:");
		font4.setPreferredSize(dem_colorlabel);
		font_op4 = new JComboBox(fonts);
		font_op4.setPreferredSize(dem_colorlabel);
		color5 = new JLabel("Color:");
		color5.setPreferredSize(dem_colorlabel);
		color_op5 = new JComboBox(colors);
		color_op5.setPreferredSize(dem_colorlabel);
		font5 = new JLabel("Font:");
		font5.setPreferredSize(dem_colorlabel);
		font_op5 = new JComboBox(fonts);
		font_op5.setPreferredSize(dem_colorlabel);
		color6 = new JLabel("Color:");
		color6.setPreferredSize(dem_colorlabel);
		color_op6 = new JComboBox(colors);
		color_op6.setPreferredSize(dem_colorlabel);
		font6 = new JLabel("Font:");
		font6.setPreferredSize(dem_colorlabel);
		font_op6 = new JComboBox(fonts);
		font_op6.setPreferredSize(dem_colorlabel);
		
		
		button1_os = new JButton("option 1");
		button2_os = new JButton("option 2");
		button3_os = new JButton("option 3");
		button4_os = new JButton("option 4");
		
		text1_os = new JLabel("text 1");
		text2_os = new JLabel("text 2");
		
		Dimension dem_optionbutton = new Dimension(dem_optionpanel.width-10, 15);
		preview1 = new JButton("Preview");
		preview1.setPreferredSize(dem_optionbutton);
		preview2 = new JButton("Preview");
		preview2.setPreferredSize(dem_optionbutton);
		preview3 = new JButton("Preview");
		preview3.setPreferredSize(dem_optionbutton);
		preview4 = new JButton("Preview");
		preview4.setPreferredSize(dem_optionbutton);
		preview5 = new JButton("Preview");
		preview5.setPreferredSize(dem_optionbutton);
		preview6 = new JButton("Preview");
		preview6.setPreferredSize(dem_optionbutton);

		//paneimg adds
		paneimg = new JPanel();
		paneimg.setLayout(null);
		paneimg.add(text1_os);
		paneimg.add(text2_os);
		
		//pane adds
		pane.add(paneimg);
		pane.add(button1_os);
		pane.add(button2_os);
		pane.add(button3_os);
		pane.add(button4_os);
		
		//editpane adds
		editpane.add(add);
		
		editpane.add(text1);
		editpane.add(area1);
		editpane.add(preview1_ops);
		preview1_ops.add(preview1);
		preview1_ops.add(color1);
		preview1_ops.add(color_op1);
		preview1_ops.add(font1);
		preview1_ops.add(font_op1);
		
		editpane.add(text2);
		editpane.add(area2);
		editpane.add(preview2_ops);
		preview2_ops.add(preview2);
		preview2_ops.add(color2);
		preview2_ops.add(color_op2);
		preview2_ops.add(font2);
		preview2_ops.add(font_op2);
		
		editpane.add(button1);
		editpane.add(area3);
		editpane.add(preview3_ops);
		preview3_ops.add(preview3);
		preview3_ops.add(color3);
		preview3_ops.add(color_op3);
		preview3_ops.add(font3);
		preview3_ops.add(font_op3);
		
		editpane.add(button2);
		editpane.add(area4);
		editpane.add(preview4_ops);
		preview4_ops.add(preview4);
		preview4_ops.add(color4);
		preview4_ops.add(color_op4);
		preview4_ops.add(font4);
		preview4_ops.add(font_op4);
		
		editpane.add(button3);
		editpane.add(area5);
		editpane.add(preview5_ops);
		preview5_ops.add(preview5);
		preview5_ops.add(color5);
		preview5_ops.add(color_op5);
		preview5_ops.add(font5);
		preview5_ops.add(font_op5);
		
		editpane.add(button4);
		editpane.add(area6);
		editpane.add(preview6_ops);
		preview6_ops.add(preview6);
		preview6_ops.add(color6);
		preview6_ops.add(color_op6);
		preview6_ops.add(font6);
		preview6_ops.add(font_op6);
		
		panelPane = new JScrollPane(editpane);
		panelPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panelPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panelPane.setPreferredSize(new Dimension(0,screenSize.height/4+30));
		//editpanel = new JPanel();
		//editpanel.add(panelPane);
		
		
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return "pop";
	}

	@Override
	public ImageIcon getImage() {
		// TODO Auto-generated method stub
		return new ImageIcon("src/images/logo.png");
	}

	@Override
	public JPanel getPanel() {
		return pane;
	}

	@Override
	public JScrollPane getEditPanel() {
		// TODO Auto-generated method stub
		return panelPane;
	}

	@Override
	public Template getInstance() {
		return new Test(null);
	}

	@Override
	public void setSizetoPlay(boolean yes) {
		// TODO Auto-generated method stub
		if (yes) {
			
		}else {
			paneimg.setPreferredSize(new Dimension(screenSize.width/3-10, screenSize.height/3-75));
			Dimension buttons = new Dimension((screenSize.width/3-10)/2-3, screenSize.height/10-50);
			button1_os.setPreferredSize(buttons);
			button2_os.setPreferredSize(buttons);
			button3_os.setPreferredSize(buttons);
			button4_os.setPreferredSize(buttons);
		}
	}

	@Override
	public JButton getAddButton() {
		// TODO Auto-generated method stub
		return add;
	}

	@Override
	public JPanel getRealEditPanel() {
		// TODO Auto-generated method stub
		return editpane;
	}

}
