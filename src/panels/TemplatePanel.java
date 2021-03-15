package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import frameGUIs.EditGUI;
import templates.Template;
import templates.Test;

public class TemplatePanel extends JPanel {

	private EditGUI frame;
	public List<Template> templates=new ArrayList<Template>(); 
	public List<JButton> options=new ArrayList<JButton>(); 
	
	public TemplatePanel(EditGUI frame) {
		this.frame = frame;
		initializeTemplates();
		CreatePanel();
		
		/*addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				frame.preview.delete.setVisible(false);
				frame.preview.change.setVisible(false);
			}
		});*/
		
	}
	
	private void CreatePanel() {
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setPreferredSize(screenSize);
		this.setBackground(Color.yellow);
		this.setLayout(new FlowLayout(10));
		
		
		for (Template i: templates) {
			JButton option = new JButton();
			option.setIcon(i.getImage());
			option.setHorizontalTextPosition(JButton.CENTER);
			option.setVerticalTextPosition(JButton.CENTER);
			option.setMargin(new Insets(0,0,0,0));
			option.setPreferredSize(new Dimension(200,200));
			option.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					CreationPanel create = frame.create;
					create.setPreview(i.getInstance(), option);
					frame.preview.delete.setVisible(false);
					frame.preview.change.setVisible(false);
					frame.preview.change_pos.setVisible(false);
					frame.preview.change_op.setVisible(false);
				}
				
			});
			
			options.add(option);
			this.add(option);
		}
		//this.setPreferredSize(new Dimension(0, 0));
	}
	
	private void initializeTemplates() {
		templates.add(new Test(null));
	}
	
	
}
