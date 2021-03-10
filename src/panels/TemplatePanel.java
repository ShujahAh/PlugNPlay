package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import frameGUIs.EditGUI;
import templates.Template;

public class TemplatePanel extends JPanel {

	private EditGUI frame;
	public List<JButton> options=new ArrayList<JButton>(); 
	
	public TemplatePanel(EditGUI frame) {
		this.frame = frame;
		CreatePanel();
		
	}
	
	private void CreatePanel() {
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setPreferredSize(screenSize);
		this.setBackground(Color.yellow);
		this.setLayout(new FlowLayout(10));
		
		JButton option;
		for (Template i: frame.templates) {
			option = new JButton();
			option.setIcon(i.getImage());
			option.setHorizontalTextPosition(JButton.CENTER);
			option.setVerticalTextPosition(JButton.CENTER);
			option.setMargin(new Insets(0,0,0,0));
			option.setPreferredSize(new Dimension(200,200));
			option.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					CreationPanel create = frame.create;
					create.setPreview(i.getInstance());
					
				}
				
			});
			
			options.add(option);
			this.add(option);
		}
		//this.setPreferredSize(new Dimension(0, 0));
	}
	
	
}
