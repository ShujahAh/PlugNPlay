package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import frameGUIs.EditGUI;
import templates.Template;

public class PreviewPanel extends JPanel {

	public EditGUI frame;
	public JPanel options;
	public JPanel preview;
	public JButton done;
	public JButton delete;
	public JButton change;
	
	public List<Template> templates=new ArrayList<Template>();
	public List<JButton> buttons=new ArrayList<JButton>(); 
	
	public PreviewPanel(EditGUI frame) {
		this.frame = frame;
		CreatePanel();
	}
	
	private void CreatePanel() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setPreferredSize(screenSize);
		this.setBackground(Color.green);
		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(0, 200));
		
		preview = new JPanel();
		preview.setBackground(Color.black);
		preview.setLayout(new FlowLayout());
		preview.setPreferredSize(new Dimension(screenSize.width-250, 200));
		preview.setLocation(0, 0);
		
		
		options = new JPanel();
		options.setBackground(Color.cyan);
		options.setLayout(new FlowLayout());
		options.setPreferredSize(new Dimension(200, 200));
		options.setLocation(this.getWidth()-200, 0);
		
		done = new JButton("Save & Exit");
		delete = new JButton("Delete");
		change = new JButton("Change Position");
		
		done.setPreferredSize(new Dimension(150,50));
		delete.setPreferredSize(new Dimension(150,50));
		change.setPreferredSize(new Dimension(150,50));
		
		delete.setVisible(false);
		change.setVisible(false);
		
		options.add(done);
		options.add(change);
		options.add(delete);
		
		this.add(preview);
		this.add(options);
	}
	
	public void addTempalte(Template template) {
		templates.add(template);
		JButton tmp = new JButton();
		tmp.setIcon(template.getImage());
		tmp.setHorizontalTextPosition(JButton.CENTER);
		tmp.setVerticalTextPosition(JButton.CENTER);
		tmp.setMargin(new Insets(0,0,0,0));
		tmp.setPreferredSize(new Dimension(180,180));
		tmp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CreationPanel create = frame.create;
				create.setPreview(template);
			}
			
		});
		buttons.add(tmp);
		preview.add(tmp);
		reDraw();
	}
	
	private void reDraw() {
		this.validate();
		this.repaint();
	}
}
