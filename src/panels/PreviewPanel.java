package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import frameGUIs.EditGUI;
import templates.Template;

public class PreviewPanel extends JPanel {

	public EditGUI frame;
	public JPanel options;
	public JPanel preview;
	public JPanel title;
	public JScrollPane preview_scroll;
	public JButton currentButton;
	public Template currentTemplate;
	public JButton done;
	public JButton delete;
	public JButton change;
	public JLabel change_pos;
	public JLabel title_l;

	public List<Integer> indexes=new ArrayList<Integer>();
	public JComboBox change_op;
	public Boolean change_ip = false;
	
	public List<Template> templates=new ArrayList<Template>();
	public List<JButton> buttons=new ArrayList<JButton>(); 
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public PreviewPanel(EditGUI frame) {
		this.frame = frame;
		CreatePanel();
		if(!frame.templates.isEmpty()) {
			loadTemplates();
		}
		
		
	}
	
	private void CreatePanel() {
		//this.setPreferredSize(screenSize);
		this.setBackground(Color.green);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(0, 200));
		
		preview = new JPanel();
		preview.setBackground(Color.black);
		preview.setLayout(new FlowLayout());
		preview.setPreferredSize(new Dimension(screenSize.width-250, 180));
		preview.setLocation(0, 0);
		
		preview_scroll = new JScrollPane(preview);
		preview_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		
		options = new JPanel();
		options.setBackground(Color.DARK_GRAY);
		options.setLayout(new FlowLayout());
		options.setPreferredSize(new Dimension(200, 200));
		options.setLocation(this.getWidth()-200, 0);
		
		title = new JPanel();
		title.setBackground(Color.LIGHT_GRAY);
		title_l = new JLabel("Preview");
		title_l.setFont(new Font("TimesRoman", Font.BOLD, 20));
		
		done = new JButton("Save & Exit");
		delete = new JButton("Delete");
		change = new JButton("Change Position");
		change_pos = new JLabel("Position:");
		change_pos.setForeground(Color.RED);
		change_op = new JComboBox();
		
		
		done.setPreferredSize(new Dimension(150,40));
		delete.setPreferredSize(new Dimension(150,40));
		change.setPreferredSize(new Dimension(150,40));
		change_pos.setPreferredSize(new Dimension(70, 20));
		change_op.setPreferredSize(new Dimension(75, 20));
		
		delete.setVisible(false);
		change.setVisible(false);
		change_pos.setVisible(false);
		change_op.setVisible(false);
		
		change.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (change_ip) {
					int pos = templates.indexOf(currentTemplate);
					int newpos = (int) change_op.getSelectedItem() -1;
					if (newpos == indexes.size()-1) {
						templates.add(currentTemplate);
						templates.remove(pos);
					}else if (newpos == 0){
						templates.remove(pos);
						templates.add(0, currentTemplate);
					}else {
						if (pos < newpos) {
							templates.add(newpos+1, currentTemplate);
							templates.remove(pos);
						}else if (pos > newpos) {
							templates.remove(pos);
							templates.add(newpos, currentTemplate);
						}
					}
					
					reCreatePreview();
					change_ip = false;
					change_pos.setVisible(false);
					change_op.setVisible(false);
					delete.setVisible(false);
					change.setVisible(false);
				}else {
					change_pos.setVisible(true);
					change_op.setVisible(true);
					change_ip = true;
				}
				
			}
			
		});
		
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				preview.remove(currentButton);
				templates.remove(currentTemplate);
				buttons.remove(currentButton);
				change_op.removeItem(indexes.size());
				indexes.remove(indexes.size()-1);
				reDraw();
			}
			
		});
		
		options.add(done);
		options.add(change);
		options.add(change_pos);
		options.add(change_op);
		options.add(delete);
		
		title.add(title_l);
		
		this.add(title, BorderLayout.NORTH);
		this.add(preview_scroll, BorderLayout.CENTER);
		this.add(options, BorderLayout.EAST);
	}
	
	private void loadTemplates() {
		for (Template i: frame.templates) {
			JButton add = i.getAddButton();
			if (add != null) {
				i.getRealEditPanel().remove(add);
			}
			addTemplate(i, false);
		}
	}
	
	public void addTemplate(Template template, Boolean reCreate) {
		JButton tmp = new JButton();
		tmp.setIcon(template.getImage());
		tmp.setHorizontalTextPosition(JButton.CENTER);
		tmp.setVerticalTextPosition(JButton.CENTER);
		tmp.setMargin(new Insets(0,0,0,0));
		tmp.setPreferredSize(new Dimension(140,140));
		tmp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				currentButton = tmp;
				currentTemplate = template;
				CreationPanel create = frame.create;
				create.setPreview(template, tmp);
				delete.setVisible(true);
				change.setVisible(true);
				change_pos.setVisible(false);
				change_op.setVisible(false);
				change_ip = false;
			}
			
		});
		if (!reCreate) {
			templates.add(template);
			indexes.add(indexes.size()+1);
			change_op.addItem(indexes.size());
		}
		buttons.add(tmp);
		preview.add(tmp);
		
		
		if (buttons.size() >7) {
			preview_scroll.setPreferredSize(new Dimension(screenSize.width-250 + ((buttons.size()-7)*180), preview_scroll.getHeight()));
			preview.setPreferredSize(new Dimension(screenSize.width-250 + ((buttons.size()-7)*180), preview_scroll.getHeight()));
		}
		reDraw();
	}
	
	private void reDraw() {
		this.validate();
		this.repaint();
	}
	
	private void reCreatePreview() {
		for (JButton i: buttons) {
			preview.remove(i);
		}
		currentTemplate = null;
		currentButton = null;
		buttons = new ArrayList<JButton>(); 
		for (Template i: templates) {
			addTemplate(i, true);
		}
		
	}
}
