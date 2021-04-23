package templates;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import panels.PreviewPanel;

public class Scenario3 implements Template {

	private final String ID = "T";
	public JPanel rootPane;
	public JPanel pane;
	public JPanel paneimg;
	public JPanel editpane;
	public JScrollPane panelPane;
	public JPanel wrong_panel;
	public JPanel right_panel;
	
	
	private String correctAnswer; 
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	//text that will appear on the preview
	public JTextArea text1_os;
	public JTextArea text2_os;
	public JTextArea text3_os;
	public JTextArea wrong_os;
	public JTextArea right_os;
	public JLabel wrong_img;
	public JLabel right_img;
	
	//buttons that will appear on the preview
	public JButton button1_os;
	public JButton button2_os;
	public JButton button3_os;
	public JButton button4_os;
	
	//buttons under each input option to preview the change
	public JButton add;
	public JButton preview1;
	public JButton preview2;
	public JButton preview21;
	public JButton preview3;
	public JButton preview4;
	public JButton preview5;
	public JButton preview6;
	public JButton preview7;
	public JButton preview8;
	
	//labels to label each set of input options
	public JLabel text1;
	public JLabel text2;
	public JLabel text3;
	public JLabel button1;
	public JLabel button2;
	public JLabel button3;
	public JLabel button4;
	public JLabel wrong;
	public JLabel right;
	
	//panels that will hold font, size, color for each set of input options
	public JPanel preview1_ops;
	public JPanel preview2_ops;
	public JPanel preview21_ops;
	public JPanel preview3_ops;
	public JPanel preview4_ops;
	public JPanel preview5_ops;
	public JPanel preview6_ops;
	public JPanel preview7_ops;
	public JPanel preview8_ops;
	
	//text area for each set of input options
	public JTextArea area1;
	public JTextArea area2;
	public JTextArea area21;
	public JTextArea area3;
	public JTextArea area4;
	public JTextArea area5;
	public JTextArea area6;
	public JTextArea area7;
	public JTextArea area8;
	
	//color options for each set of input options
	public final String[] colors = {"White","Gray","Black","Red","Orange", "Yellow", "Green", "Blue"};
	public JLabel color1;
	public JLabel color2;
	public JLabel color21;
	public JLabel color3;
	public JLabel color4;
	public JLabel color5;
	public JLabel color6;
	public JLabel color7;
	public JLabel color8;
	public JComboBox color_op1;
	public JComboBox color_op2;
	public JComboBox color_op21;
	public JComboBox color_op3;
	public JComboBox color_op4;
	public JComboBox color_op5;
	public JComboBox color_op6;
	public JComboBox color_op7;
	public JComboBox color_op8;
	
	//font options for each set of input options
	public final String[] fonts = {"Dialog","Helvetica","TimesR","Courier","Symbol"};
	public JLabel font1;
	public JLabel font2;
	public JLabel font21;
	public JLabel font3;
	public JLabel font4;
	public JLabel font5;
	public JLabel font6;
	public JLabel font7;
	public JLabel font8;
	public JComboBox font_op1;
	public JComboBox font_op2;
	public JComboBox font_op21;
	public JComboBox font_op3;
	public JComboBox font_op4;
	public JComboBox font_op5;
	public JComboBox font_op6;
	public JComboBox font_op7;
	public JComboBox font_op8;
	
	public ButtonGroup correct_op;
	public JRadioButton correct1;
	public JRadioButton correct2;
	public JRadioButton correct3;
	public JRadioButton correct4;
	
	ImageIcon image_edit = new ImageIcon(new ImageIcon("src/images/Scenario3.png").getImage().getScaledInstance(screenSize.width/3-10,screenSize.width/7, Image.SCALE_DEFAULT));
	ImageIcon image_act = new ImageIcon(new ImageIcon("src/images/Scenario3.png").getImage().getScaledInstance(screenSize.width*3/4-20, (int) (screenSize.height/1.9), Image.SCALE_DEFAULT));
	ImageIcon image_button = new ImageIcon(new ImageIcon("src/images/Scenario3.png").getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT));
	ImageIcon image_right = new ImageIcon(new ImageIcon("src/images/correct.png").getImage().getScaledInstance(screenSize.width/10, screenSize.height/5, Image.SCALE_DEFAULT));
	ImageIcon image_wrong = new ImageIcon(new ImageIcon("src/images/wrong.png").getImage().getScaledInstance(screenSize.width/10, screenSize.height/5, Image.SCALE_DEFAULT));
	JLabel background;
	
	
	
	public Scenario3(List<String> data){
		//System.out.println("worked");
		CreateTemplate();
		if (data != null) {
			loadData(data);
		}
	}
	
	private void CreateTemplate() {
		pane = new JPanel();
		pane.setBackground(Color.GRAY);
		pane.setLayout(new FlowLayout());
		
		wrong_panel = new JPanel();
		wrong_panel.setBackground(Color.white);
		wrong_panel.setLayout(null);
		
		right_panel = new JPanel();
		right_panel.setBackground(Color.white);
		right_panel.setLayout(null);
		
		editpane = new JPanel();
		editpane.setBackground(Color.LIGHT_GRAY);
		editpane.setLayout(new FlowLayout());
		editpane.setPreferredSize(new Dimension(screenSize.width/3-20, 1000));
		//editpane.setLocation(0, 0);
		
		add = new JButton("Add to Lesson");
		add.setPreferredSize(new Dimension(screenSize.width/3-30, 20));
		
		Dimension dem_labels_buttons =new Dimension(screenSize.width/3-170, 20);
		Dimension dem_labels_texts =new Dimension(screenSize.width/3-30, 20);
		text1 = new JLabel("Text #1");
		text1.setPreferredSize(dem_labels_texts);
		text2 = new JLabel("Text #2");
		text2.setPreferredSize(dem_labels_texts);
		text3 = new JLabel("Text #3");
		text3.setPreferredSize(dem_labels_texts);
		button1 = new JLabel("Button #1");
		button1.setPreferredSize(dem_labels_buttons);
		button2 = new JLabel("Button #2");
		button2.setPreferredSize(dem_labels_buttons);
		button3 = new JLabel("Button #3");
		button3.setPreferredSize(dem_labels_buttons);
		button4 = new JLabel("Button #4");
		button4.setPreferredSize(dem_labels_buttons);
		right = new JLabel("Right Choice Text");
		right.setPreferredSize(dem_labels_texts);
		wrong = new JLabel("Wrong Choice Text");
		wrong.setPreferredSize(dem_labels_texts);
		
		Dimension dem_textarea = new Dimension(screenSize.width/3-170, 80);
		area1 = new JTextArea();
		area1.setPreferredSize(dem_textarea);
		area1.setLineWrap(true);
		area2 = new JTextArea();
		area2.setPreferredSize(dem_textarea);
		area2.setLineWrap(true);
		area21 = new JTextArea();
		area21.setPreferredSize(dem_textarea);
		area21.setLineWrap(true);
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
		area7 = new JTextArea();
		area7.setPreferredSize(dem_textarea);
		area7.setLineWrap(true);
		area8 = new JTextArea();
		area8.setPreferredSize(dem_textarea);
		area8.setLineWrap(true);
		
		Dimension dem_optionpanel = new Dimension(dem_textarea.width/4+45, 80);
		Color background_color = Color.lightGray;
		preview1_ops = new JPanel();
		preview1_ops.setPreferredSize(dem_optionpanel);
		preview1_ops.setBackground(background_color);
		preview2_ops = new JPanel();
		preview2_ops.setPreferredSize(dem_optionpanel);
		preview2_ops.setBackground(background_color);
		preview21_ops = new JPanel();
		preview21_ops.setPreferredSize(dem_optionpanel);
		preview21_ops.setBackground(background_color);
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
		preview7_ops = new JPanel();
		preview7_ops.setPreferredSize(dem_optionpanel);
		preview7_ops.setBackground(background_color);
		preview8_ops = new JPanel();
		preview8_ops.setPreferredSize(dem_optionpanel);
		preview8_ops.setBackground(background_color);
		
		
		Dimension dem_colorlabel = new Dimension(dem_optionpanel.width/2-5, 22);
		color1 = new JLabel("Color:");
		color1.setPreferredSize(dem_colorlabel);
		color_op1 = new JComboBox(colors);
		color_op1.setPreferredSize(dem_colorlabel);
		color_op1.setSelectedItem("Black");
		font1 = new JLabel("Font:");
		font1.setPreferredSize(dem_colorlabel);
		font_op1 = new JComboBox(fonts);
		font_op1.setPreferredSize(dem_colorlabel);
		color2 = new JLabel("Color:");
		color2.setPreferredSize(dem_colorlabel);
		color_op2 = new JComboBox(colors);
		color_op2.setPreferredSize(dem_colorlabel);
		color_op2.setSelectedItem("Black");
		font2 = new JLabel("Font:");
		font2.setPreferredSize(dem_colorlabel);
		font_op2 = new JComboBox(fonts);
		font_op2.setPreferredSize(dem_colorlabel);
		color21 = new JLabel("Color:");
		color21.setPreferredSize(dem_colorlabel);
		color_op21 = new JComboBox(colors);
		color_op21.setPreferredSize(dem_colorlabel);
		color_op21.setSelectedItem("Black");
		font21 = new JLabel("Font:");
		font21.setPreferredSize(dem_colorlabel);
		font_op21 = new JComboBox(fonts);
		font_op21.setPreferredSize(dem_colorlabel);
		color3 = new JLabel("Color:");
		color3.setPreferredSize(dem_colorlabel);
		color_op3 = new JComboBox(colors);
		color_op3.setPreferredSize(dem_colorlabel);
		color_op3.setSelectedItem("Black");
		font3 = new JLabel("Font:");
		font3.setPreferredSize(dem_colorlabel);
		font_op3 = new JComboBox(fonts);
		font_op3.setPreferredSize(dem_colorlabel);
		color4 = new JLabel("Color:");
		color4.setPreferredSize(dem_colorlabel);
		color_op4 = new JComboBox(colors);
		color_op4.setPreferredSize(dem_colorlabel);
		color_op4.setSelectedItem("Black");
		font4 = new JLabel("Font:");
		font4.setPreferredSize(dem_colorlabel);
		font_op4 = new JComboBox(fonts);
		font_op4.setPreferredSize(dem_colorlabel);
		color5 = new JLabel("Color:");
		color5.setPreferredSize(dem_colorlabel);
		color_op5 = new JComboBox(colors);
		color_op5.setPreferredSize(dem_colorlabel);
		color_op5.setSelectedItem("Black");
		font5 = new JLabel("Font:");
		font5.setPreferredSize(dem_colorlabel);
		font_op5 = new JComboBox(fonts);
		font_op5.setPreferredSize(dem_colorlabel);
		color6 = new JLabel("Color:");
		color6.setPreferredSize(dem_colorlabel);
		color_op6 = new JComboBox(colors);
		color_op6.setPreferredSize(dem_colorlabel);
		color_op6.setSelectedItem("Black");
		font6 = new JLabel("Font:");
		font6.setPreferredSize(dem_colorlabel);
		font_op6 = new JComboBox(fonts);
		font_op6.setPreferredSize(dem_colorlabel);
		color7 = new JLabel("Color:");
		color7.setPreferredSize(dem_colorlabel);
		color_op7 = new JComboBox(colors);
		color_op7.setPreferredSize(dem_colorlabel);
		color_op7.setSelectedItem("Black");
		font7 = new JLabel("Font:");
		font7.setPreferredSize(dem_colorlabel);
		font_op7 = new JComboBox(fonts);
		font_op7.setPreferredSize(dem_colorlabel);
		color8 = new JLabel("Color:");
		color8.setPreferredSize(dem_colorlabel);
		color_op8 = new JComboBox(colors);
		color_op8.setPreferredSize(dem_colorlabel);
		color_op8.setSelectedItem("Black");
		font8 = new JLabel("Font:");
		font8.setPreferredSize(dem_colorlabel);
		font_op8 = new JComboBox(fonts);
		font_op8.setPreferredSize(dem_colorlabel);
		
		
		button1_os = new JButton("option 1");
		button2_os = new JButton("option 2");
		button3_os = new JButton("option 3");
		button4_os = new JButton("option 4");
		
		text1_os = new JTextArea("text 1");
		text1_os.setLineWrap(true);
		text1_os.setEditable(false);
		text1_os.setWrapStyleWord(true);
		text2_os = new JTextArea("text 2");
		text2_os.setLineWrap(true);
		text2_os.setWrapStyleWord(true);
		text2_os.setEditable(false);
		text3_os = new JTextArea("text 3");
		text3_os.setLineWrap(true);
		text3_os.setWrapStyleWord(true);
		text3_os.setEditable(false);
		
		wrong_os = new JTextArea("Wrong");
		wrong_os.setLineWrap(true);
		wrong_os.setWrapStyleWord(true);
		wrong_os.setEditable(false);
		right_os = new JTextArea("Right");
		right_os.setLineWrap(true);
		right_os.setWrapStyleWord(true);
		right_os.setEditable(false);
		right_img = new JLabel(image_right);
		wrong_img = new JLabel(image_wrong);
		
		String lab = "Correct Answer";
		Dimension dem_correct =new Dimension(dem_textarea.width/4+45, 20);
		correct1 = new JRadioButton(lab);
		correct1.setPreferredSize(dem_correct);
		correct1.setBackground(Color.LIGHT_GRAY);
		correct2 = new JRadioButton(lab); 
		correct2.setPreferredSize(dem_correct);
		correct2.setBackground(Color.LIGHT_GRAY);
		correct3 = new JRadioButton(lab); 
		correct3.setPreferredSize(dem_correct);
		correct3.setBackground(Color.LIGHT_GRAY);
		correct4 = new JRadioButton(lab);
		correct4.setPreferredSize(dem_correct);
		correct4.setBackground(Color.LIGHT_GRAY);
		correct_op = new ButtonGroup();
		correct_op.add(correct1);
		correct_op.add(correct2);
		correct_op.add(correct3);
		correct_op.add(correct4);
		
		
		Dimension dem_optionbutton = new Dimension(dem_optionpanel.width-10, 15);
		preview1 = new JButton("Preview");
		preview1.setPreferredSize(dem_optionbutton);
		setPreviewListener(preview1, area1, font_op1, color_op1, text1_os);
		preview2 = new JButton("Preview");
		preview2.setPreferredSize(dem_optionbutton);
		setPreviewListener(preview2, area2, font_op2, color_op2, text2_os);
		preview21 = new JButton("Preview");
		preview21.setPreferredSize(dem_optionbutton);
		setPreviewListener(preview21, area21, font_op21, color_op21, text3_os);
		preview3 = new JButton("Preview");
		preview3.setPreferredSize(dem_optionbutton);
		setPreviewListener(preview3, area3, font_op3, color_op3, button1_os, correct1, button1);
		preview4 = new JButton("Preview");
		preview4.setPreferredSize(dem_optionbutton);
		setPreviewListener(preview4, area4, font_op4, color_op4, button2_os, correct2, button2);
		preview5 = new JButton("Preview");
		preview5.setPreferredSize(dem_optionbutton);
		setPreviewListener(preview5, area5, font_op5, color_op5, button3_os, correct3, button3);
		preview6 = new JButton("Preview");
		preview6.setPreferredSize(dem_optionbutton);
		setPreviewListener(preview6, area6, font_op6, color_op6, button4_os, correct4, button4);
		preview7 = new JButton("Preview");
		preview7.setPreferredSize(dem_optionbutton);
		setPreviewListener(preview7, area7, font_op7, color_op7, right_os);
		preview8 = new JButton("Preview");
		preview8.setPreferredSize(dem_optionbutton);
		setPreviewListener(preview8, area8, font_op8, color_op8, wrong_os);
		
		background = new JLabel(image_edit);

		//wrong and right adds
		wrong_panel.add(wrong_os);
		wrong_panel.add(wrong_img);
		right_panel.add(right_os);
		right_panel.add(right_img);
		
		//paneimg adds
		paneimg = new JPanel();
		paneimg.setLayout(null);
		paneimg.add(text1_os);
		paneimg.add(text2_os);
		paneimg.add(text3_os);
		paneimg.add(background);
		
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
		
		editpane.add(text3);
		editpane.add(area21);
		editpane.add(preview21_ops);
		preview21_ops.add(preview21);
		preview21_ops.add(color21);
		preview21_ops.add(color_op21);
		preview21_ops.add(font21);
		preview21_ops.add(font_op21);
		
		editpane.add(button1);
		editpane.add(correct1);
		editpane.add(area3);
		editpane.add(preview3_ops);
		preview3_ops.add(preview3);
		preview3_ops.add(color3);
		preview3_ops.add(color_op3);
		preview3_ops.add(font3);
		preview3_ops.add(font_op3);
		
		editpane.add(button2);
		editpane.add(correct2);
		editpane.add(area4);
		editpane.add(preview4_ops);
		preview4_ops.add(preview4);
		preview4_ops.add(color4);
		preview4_ops.add(color_op4);
		preview4_ops.add(font4);
		preview4_ops.add(font_op4);
		
		editpane.add(button3);
		editpane.add(correct3);
		editpane.add(area5);
		editpane.add(preview5_ops);
		preview5_ops.add(preview5);
		preview5_ops.add(color5);
		preview5_ops.add(color_op5);
		preview5_ops.add(font5);
		preview5_ops.add(font_op5);
		
		editpane.add(button4);
		editpane.add(correct4);
		editpane.add(area6);
		editpane.add(preview6_ops);
		preview6_ops.add(preview6);
		preview6_ops.add(color6);
		preview6_ops.add(color_op6);
		preview6_ops.add(font6);
		preview6_ops.add(font_op6);
		
		editpane.add(right);
		editpane.add(area7);
		editpane.add(preview7_ops);
		preview7_ops.add(preview7);
		preview7_ops.add(color7);
		preview7_ops.add(color_op7);
		preview7_ops.add(font7);
		preview7_ops.add(font_op7);
		
		editpane.add(wrong);
		editpane.add(area8);
		editpane.add(preview8_ops);
		preview8_ops.add(preview8);
		preview8_ops.add(color8);
		preview8_ops.add(color_op8);
		preview8_ops.add(font8);
		preview8_ops.add(font_op8);
		
		panelPane = new JScrollPane(editpane);
		panelPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panelPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panelPane.setPreferredSize(new Dimension(0,screenSize.height/4+30));
		//editpanel = new JPanel();
		//editpanel.add(panelPane);
		
		rootPane = new JPanel(new CardLayout());
		rootPane.add(pane, "main");
		rootPane.add(wrong_panel, "wrong");
		rootPane.add(right_panel, "right");
		CardLayout tmp = (CardLayout)(rootPane.getLayout());
		tmp.show(rootPane, "main");
		
		wrong_panel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CardLayout tmp = (CardLayout)(rootPane.getLayout());
				tmp.show(rootPane, "main");
			}
		});
		
		
		
	}
	
	private void loadData(List<String> data) {
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).isEmpty()) {
				data.remove(i);
			}
		}
		String[] txt1 = data.get(0).split("<end>");
		String[] txt2 = data.get(1).split("<end>");
		String[] txt21 = data.get(2).split("<end>");
		String[] txt3 = data.get(3).split("<end>");
		String[] txt4 = data.get(4).split("<end>");
		String[] txt5 = data.get(5).split("<end>");
		String[] txt6 = data.get(6).split("<end>");
		String[] txt7 = data.get(7).split("<end>");
		String[] txt8 = data.get(8).split("<end>");
		correctAnswer = data.get(9);
		
		loadText(txt1, area1, font_op1, color_op1, preview1, null, false);
		loadText(txt2, area2, font_op2, color_op2, preview2, null, false);
		loadText(txt21, area21, font_op21, color_op21, preview21, null, false);
		loadText(txt3, area3, font_op3, color_op3, preview3, null, false);
		loadText(txt4, area4, font_op4, color_op4, preview4, null, false);
		loadText(txt5, area5, font_op5, color_op5, preview5, null, false);
		loadText(txt6, area6, font_op6, color_op6, preview6, null, false);
		loadText(txt7, area7, font_op7, color_op7, preview7, null, false);
		loadText(txt8, area8, font_op8, color_op8, preview8, null, false);
		
		switch (correctAnswer) {
			case  "Button #1":
				loadText(txt3, area3, font_op3, color_op3, preview3, correct1, true);
				break;
			case  "Button #2":
				loadText(txt4, area4, font_op4, color_op4, preview4, correct2, true);
				break;
			case  "Button #3":
				loadText(txt5, area5, font_op5, color_op5, preview5, correct3, true);
				break;
			case  "Button #4":
				loadText(txt6, area6, font_op6, color_op6, preview6, correct4, true);
				break;		
		}
			
	}
	
	private void loadText(String[] data, JTextArea area, JComboBox font_op, JComboBox color_op, JButton preview, JRadioButton correct, Boolean right) {
		area.setText(data[0]);
		font_op.setSelectedItem(data[1]);
		color_op.setSelectedItem(data[2]);
		if (correct != null & right) {
			correct.setSelected(true);
		}
		preview.doClick();
	}
	
	private void setPreviewListener(JButton preview, JTextArea area, JComboBox font_op, JComboBox color_op, JTextArea text_os) {
		
		preview.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = area.getText();
				String font = (String) font_op.getSelectedItem();
				String color = (String) color_op.getSelectedItem();
				text_os.setText(text);
				Font fo = new Font(null);
				Color co = Color.cyan;
				
				
				switch (font) {
					case "Dialog":
						fo = new Font("Dialog", Font.BOLD, 10);
						break;
					case "Helvetica":
						fo = new Font("Helvetica", Font.BOLD, 10);
						break;
					case "TimesR":
						fo = new Font("TimesRoman", Font.BOLD, 10);
						break;
					case "Courier":
						fo = new Font("Courier", Font.BOLD, 10);
						break;
					case "Symbol":
						fo = new Font("Symbol", Font.BOLD, 10);
				}
				
				switch (color) {
					case "White":
						co = Color.white;
						break;
					case "Gray":
						co = Color.gray;
						break;
					case "Black":
						co = Color.black;
						break;
					case "Red":
						co = Color.red;
						break;
					case "Orange":
						co = Color.orange;
						break;
					case "Yellow":
						co = Color.yellow;
						break;
					case "Green":
						co = Color.green;
						break;
					case "Blue":
						co = Color.blue;
						break;
				}
				
				text_os.setForeground(co);
				text_os.setFont(fo);
			}
			
		});
		
	}

	private void setPreviewListener(JButton preview, JTextArea area, JComboBox font_op, JComboBox color_op, JButton button_os, JRadioButton correct, JLabel this_text) {
		
		preview.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = area.getText();
				String font = (String) font_op.getSelectedItem();
				String color = (String) color_op.getSelectedItem();
				button_os.setText(text);
				Font fo = new Font(null);
				Color co = Color.cyan;
				
				switch (font) {
					case "Dialog":
						fo = new Font("Dialog", Font.BOLD, 10);
						break;
					case "Helvetica":
						fo = new Font("Helvetica", Font.BOLD, 10);
						break;
					case "TimesR":
						fo = new Font("TimesRoman", Font.BOLD, 10);
						break;
					case "Courier":
						fo = new Font("Courier", Font.BOLD, 10);
						break;
					case "Symbol":
						fo = new Font("Symbol", Font.BOLD, 10);
				}
				
				switch (color) {
					case "White":
						co = Color.white;
						break;
					case "Gray":
						co = Color.gray;
						break;
					case "Black":
						co = Color.black;
						break;
					case "Red":
						co = Color.red;
						break;
					case "Orange":
						co = Color.orange;
						break;
					case "Yellow":
						co = Color.yellow;
						break;
					case "Green":
						co = Color.green;
						break;
					case "Blue":
						co = Color.blue;
						break;
				}
				
				button_os.setForeground(co);
				button_os.setFont(fo);
				
				if(correct.isSelected()) {
					correctAnswer = this_text.getText();
					if (button_os.getActionListeners().length > 0) {
						button_os.removeActionListener(button_os.getActionListeners()[0]);
					}
					button_os.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							CardLayout tmp = (CardLayout)(rootPane.getLayout());
							tmp.show(rootPane, "right");
						}
					});
				}else {				
					if (button_os.getActionListeners().length > 0) {
						button_os.removeActionListener(button_os.getActionListeners()[0]);
					}
					button_os.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							CardLayout tmp = (CardLayout)(rootPane.getLayout());
							tmp.show(rootPane, "wrong");
						}
					});
				}
			}
			
		});
		
	}

	@Override
	public String getText() {
		String nametemplate_data = "Scenario3";
		String text1_data = "<textsub>" + text1_os.getText() + "<end>" + font_op1.getSelectedItem().toString() + "<end>" + color_op1.getSelectedItem().toString() + "<textsub>"; 
		String text2_data = "<textsub>" + text2_os.getText() + "<end>" + font_op2.getSelectedItem().toString() + "<end>" + color_op2.getSelectedItem().toString() + "<textsub>"; 
		String text21_data = "<textsub>" + text3_os.getText() + "<end>" + font_op21.getSelectedItem().toString() + "<end>" + color_op21.getSelectedItem().toString() + "<textsub>"; 
		String text3_data = "<textsub>" + button1_os.getText() + "<end>" + font_op3.getSelectedItem().toString() + "<end>" + color_op3.getSelectedItem().toString() + "<textsub>"; 
		String text4_data = "<textsub>" + button2_os.getText() + "<end>" + font_op4.getSelectedItem().toString() + "<end>" + color_op4.getSelectedItem().toString() + "<textsub>"; 
		String text5_data = "<textsub>" + button3_os.getText() + "<end>" + font_op5.getSelectedItem().toString() + "<end>" + color_op5.getSelectedItem().toString() + "<textsub>"; 
		String text6_data = "<textsub>" + button4_os.getText() + "<end>" + font_op6.getSelectedItem().toString() + "<end>" + color_op6.getSelectedItem().toString() + "<textsub>"; 
		String text7_data = "<textsub>" + right_os.getText() + "<end>" + font_op7.getSelectedItem().toString() + "<end>" + color_op7.getSelectedItem().toString() + "<textsub>"; 
		String text8_data = "<textsub>" + wrong_os.getText() + "<end>" + font_op8.getSelectedItem().toString() + "<end>" + color_op8.getSelectedItem().toString() + "<textsub>"; 
		String correctanswer_data = correctAnswer;
		
		String data = nametemplate_data + "\n" + "<text>" + "\n" + text1_data + "\n" + text2_data + "\n" + text21_data + "\n" + text3_data 
					+ "\n" + text4_data + "\n" + text5_data + "\n" + text6_data + "\n" + text7_data + "\n" + text8_data + "\n" 
					+ "<text>" + "\n"  + correctanswer_data;
		
		return data;
	}

	@Override
	public ImageIcon getImage() {
		// TODO Auto-generated method stub
		return image_button;
	}

	@Override
	public JPanel getPanel() {
		return rootPane;
	}

	@Override
	public JScrollPane getEditPanel() {
		// TODO Auto-generated method stub
		return panelPane;
	}

	@Override
	public Template getInstance() {
		return new Scenario3(null);
	}

	@Override
	public void setSizetoPlay(boolean yes) {
		// TODO Auto-generated method stub
		if (yes) {
			paneimg.setPreferredSize(new Dimension(screenSize.width*3/4-20, (int) (screenSize.height/1.9)));
			Dimension buttons = new Dimension(screenSize.width/3, screenSize.height/13);
			background.setIcon(image_act);
			background.setBounds(0,0,screenSize.width*3/4-20, (int) (screenSize.height/1.9));
			text1_os.setBounds((int) (screenSize.width/1.715),screenSize.height/19,  (int) (screenSize.width/7.2), screenSize.height/12);
			text1_os.setFont(new Font(text3_os.getFont().getFontName(), Font.BOLD, 20));
			text2_os.setBounds((int) (screenSize.width/2.57),screenSize.height/9, screenSize.width/8, screenSize.height/13);
			text2_os.setFont(new Font(text3_os.getFont().getFontName(), Font.BOLD, 20));
			text3_os.setBounds((int) (screenSize.width/3),(int) (screenSize.height/2.6), (int) (screenSize.width/2.7), screenSize.height/6);
			text3_os.setFont(new Font(text3_os.getFont().getFontName(), Font.BOLD, 20));
			button1_os.setPreferredSize(buttons);
			button1_os.setFont(new Font(text3_os.getFont().getFontName(), Font.BOLD, 20));
			button2_os.setPreferredSize(buttons);
			button2_os.setFont(new Font(text3_os.getFont().getFontName(), Font.BOLD, 20));
			button3_os.setPreferredSize(buttons);
			button3_os.setFont(new Font(text3_os.getFont().getFontName(), Font.BOLD, 20));
			button4_os.setPreferredSize(buttons);
			button4_os.setFont(new Font(text3_os.getFont().getFontName(), Font.BOLD, 20));
			right_os.setBounds((int) (screenSize.width/5.8),screenSize.height/4,  screenSize.width/3, screenSize.height/3);
			right_os.setFont(new Font(text3_os.getFont().getFontName(), Font.BOLD, 20));
			wrong_os.setBounds((int) (screenSize.width/5.8),screenSize.height/4,  screenSize.width/3, screenSize.height/3);
			wrong_os.setFont(new Font(text3_os.getFont().getFontName(), Font.BOLD, 20));
			right_img.setBounds((int) (screenSize.width/100),screenSize.height/4, screenSize.width/10, screenSize.height/5);
			wrong_img.setBounds((int) (screenSize.width/100),screenSize.height/4, screenSize.width/10, screenSize.height/5);
		}else {
			paneimg.setPreferredSize(new Dimension(screenSize.width/3-10, screenSize.height/3-75));
			Dimension buttons = new Dimension((screenSize.width/3-10)/2-3, screenSize.height/10-50);
			background.setIcon(image_edit);
			background.setBounds(0,0,screenSize.width/3-10,screenSize.width/7);
			text1_os.setBounds((int) (screenSize.width/3.85),screenSize.height/40,  screenSize.width/17, screenSize.height/24);
			text2_os.setBounds((int) (screenSize.width/5.7),screenSize.height/19, (int) (screenSize.width/18), screenSize.height/25);
			text3_os.setBounds((int) (screenSize.width/7.2),(int) (screenSize.height/5.5), screenSize.width/6, screenSize.height/17);
			button1_os.setPreferredSize(buttons);
			button2_os.setPreferredSize(buttons);
			button3_os.setPreferredSize(buttons);
			button4_os.setPreferredSize(buttons);
			right_os.setBounds((int) (screenSize.width/9),screenSize.height/9,  screenSize.width/6, screenSize.height/6);
			wrong_os.setBounds((int) (screenSize.width/9),screenSize.height/9,  screenSize.width/6, screenSize.height/6);
			right_img.setBounds((int) (screenSize.width/100),screenSize.height/9, screenSize.width/10, screenSize.height/5);
			wrong_img.setBounds((int) (screenSize.width/100),screenSize.height/9, screenSize.width/10, screenSize.height/5);
			
			right_panel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					CardLayout tmp = (CardLayout)(rootPane.getLayout());
					tmp.show(rootPane, "main");
				}
			});
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

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return ID;
	}

	@Override
	public JComponent getComponentToAdvance() {
		// TODO Auto-generated method stub
		return right_panel;
	}

}
