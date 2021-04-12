package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import frameGUIs.EditGUI;
import templates.Scenario1;
import templates.Scenario3;
import templates.Scenario6;
import templates.Scenario7;
import templates.Scenario8;
import templates.Scenario9;
import templates.Template;
import templates.Test;

public class TemplatePanel extends JPanel {

	public JPanel title_panel;
	public JPanel opt_panel;
	
	private EditGUI frame;
	public List<Template> templates=new ArrayList<Template>(); 
	public List<Template> lessons=new ArrayList<Template>(); 
	public List<Template> quizes=new ArrayList<Template>(); 
	public List<Template> scenarios=new ArrayList<Template>(); 
	public List<Template> misc=new ArrayList<Template>(); 
	public List<JButton> options=new ArrayList<JButton>(); 
	
	public JLabel template_l;
	public JLabel lessons_l;
	public JLabel quizes_l;
	public JLabel scenarios_l;
	public JLabel misc_l;
	
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
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setPreferredSize(screenSize);
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(new BorderLayout());
		
		title_panel = new JPanel(new BorderLayout());
		opt_panel = new JPanel(new FlowLayout(10));
		
		template_l = new JLabel("Templates", SwingConstants.CENTER);
		template_l.setFont(new Font("TimesRoman", Font.BOLD, 40));
		template_l.setPreferredSize(new Dimension(600, 55));
		
		ImageIcon up = new ImageIcon("src/images/traingle.png");
		ImageIcon down = new ImageIcon("src/images/triangle_down.png");
		lessons_l = new JLabel("Lessons", SwingConstants.CENTER);
		lessons_l.setFont(new Font("TimesRoman", Font.BOLD, 20));
		lessons_l.setPreferredSize(new Dimension(screenSize.width*2/3-25, 30));
		lessons_l.setIcon(up);
		lessons_l.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.black, Color.DARK_GRAY));
		lessons_l.setOpaque(true);
		lessons_l.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (lessons_l.getIcon() == up) {
					lessons_l.setIcon(down);
				}else {
					lessons_l.setIcon(up);
				}
			}
			
		    public void mouseEntered(MouseEvent e) {
		        lessons_l.setBackground(Color.LIGHT_GRAY);
		        
		     }
		    
		    public void mouseExited(MouseEvent e) {
		    	lessons_l.setBackground(Color.white);
		     }

		});
		
		scenarios_l = new JLabel("Scenarios", SwingConstants.CENTER);
		scenarios_l.setFont(new Font("TimesRoman", Font.BOLD, 20));
		scenarios_l.setPreferredSize(new Dimension(screenSize.width*2/3-25, 30));
		scenarios_l.setIcon(up);
		scenarios_l.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.black, Color.DARK_GRAY));
		scenarios_l.setOpaque(true);
		scenarios_l.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (scenarios_l.getIcon() == up) {
					scenarios_l.setIcon(down);
				}else {
					scenarios_l.setIcon(up);
				}
			}
			
		    public void mouseEntered(MouseEvent e) {
		    	scenarios_l.setBackground(Color.LIGHT_GRAY);
		        
		     }
		    
		    public void mouseExited(MouseEvent e) {
		    	scenarios_l.setBackground(Color.white);
		     }

		});
		
		quizes_l = new JLabel("Quizes", SwingConstants.CENTER);
		quizes_l.setFont(new Font("TimesRoman", Font.BOLD, 20));
		quizes_l.setPreferredSize(new Dimension(screenSize.width*2/3-25, 30));
		quizes_l.setIcon(up);
		quizes_l.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.black, Color.DARK_GRAY));
		quizes_l.setOpaque(true);
		quizes_l.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (quizes_l.getIcon() == up) {
					quizes_l.setIcon(down);
				}else {
					quizes_l.setIcon(up);
				}
			}
			
		    public void mouseEntered(MouseEvent e) {
		    	quizes_l.setBackground(Color.LIGHT_GRAY);
		        
		     }
		    
		    public void mouseExited(MouseEvent e) {
		    	quizes_l.setBackground(Color.white);
		     }

		});
		
		misc_l = new JLabel("Miscellaneous", SwingConstants.CENTER);
		misc_l.setFont(new Font("TimesRoman", Font.BOLD, 20));
		misc_l.setPreferredSize(new Dimension(screenSize.width*2/3-25, 30));
		misc_l.setIcon(up);
		misc_l.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.black, Color.DARK_GRAY));
		misc_l.setOpaque(true);
		misc_l.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (misc_l.getIcon() == up) {
					misc_l.setIcon(down);
				}else {
					misc_l.setIcon(up);
				}
			}
			
		    public void mouseEntered(MouseEvent e) {
		    	misc_l.setBackground(Color.LIGHT_GRAY);
		        
		     }
		    
		    public void mouseExited(MouseEvent e) {
		    	misc_l.setBackground(Color.white);
		     }

		});
		
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
			opt_panel.add(option);
		}
		//this.setPreferredSize(new Dimension(0, 0));
		this.add(template_l, BorderLayout.NORTH);
		this.add(opt_panel, BorderLayout.CENTER);
		
		opt_panel.add(lessons_l);
		opt_panel.add(scenarios_l);
		opt_panel.add(quizes_l);
		opt_panel.add(misc_l);
	}
	
	private void initializeTemplates() {
		//templates.add(new Test(null));
		templates.add(new Scenario1(null));
		templates.add(new Scenario3(null));
		templates.add(new Scenario6(null));
		templates.add(new Scenario7(null));
		templates.add(new Scenario8(null));
		templates.add(new Scenario9(null));
	}
	
	
}
