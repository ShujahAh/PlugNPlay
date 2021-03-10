package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import frameGUIs.EditGUI;
import templates.Template;
import templates.Test;

public class CreationPanel extends JPanel {
	
	public JPanel current_template;
	public JScrollPane edit_template;
	public JButton add;
	
	private EditGUI frame;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public CreationPanel(EditGUI frame) {
		this.frame = frame;
		CreatePanel();
		
	}
	


	private void CreatePanel() {
		
		//this.setPreferredSize(screenSize);
		this.setBackground(Color.red);
		this.setLayout(new BorderLayout(5,5));
		this.setPreferredSize(new Dimension(screenSize.width/3, 500));
		
		
	}
	
	public void setPreview(Template template) {
		
		if (current_template != null) {
			this.remove(current_template);
			this.remove(edit_template);
			current_template = null;
			edit_template = null;
		}
		
		template.setSizetoPlay(false);
		
		//ImageIcon tmp = template.getImage();
		current_template = template.getPanel();
		current_template.setPreferredSize(new Dimension(screenSize.width/3-10,screenSize.width/5));
		//current_template.setLocation(5, 5);
		current_template.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		
		edit_template = template.getEditPanel();
		edit_template.setPreferredSize(new Dimension(screenSize.width/3-10,10));
		
		add = template.getAddButton();
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PreviewPanel preview = frame.preview;
				preview.addTempalte(template);
				template.getRealEditPanel().remove(add);
				reDraw();
			}
			
		});
		
		this.add(current_template, BorderLayout.NORTH);
		this.add(edit_template, BorderLayout.CENTER);
		reDraw();
	}
	
	private void reDraw() {
		this.validate();
		this.repaint();
	}
}
