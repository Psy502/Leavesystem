package com.psy.UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.psy.domain.Staff;
import com.psy.util.CommonStaff;

/**
 * 
 * @author 
 *
 */
public class DeleteStaff extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton delete;
	private JPanel jp1 , jp2 ;
	private List<Staff> staffs;
	private JList<Staff> jLists;
	private DefaultListModel  mode;
	public DeleteStaff() {
		initUI();
		staffs = CommonStaff.staffs;
		this.setLayout(new BorderLayout());
		this.add(jp1 , BorderLayout.NORTH);
		mode = new DataModel();
		jLists= new JList(mode);
		jLists.setVisibleRowCount(5);
		jLists.setBorder(BorderFactory.createTitledBorder("Delete Staff"));
		this.add(new JScrollPane(jLists) ,BorderLayout.CENTER);
		int windowWidth = this.getWidth();                     

	     int windowHeight = this.getHeight();                   

	     Toolkit kit = Toolkit.getDefaultToolkit();             

	     Dimension screenSize = kit.getScreenSize();             

	     int screenWidth = screenSize.width;                     

	     int screenHeight = screenSize.height;                   

	     this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
	     this.setPreferredSize(new Dimension(500, 400));  
	     this.pack();  
	     this.setVisible(true);
	}
	private void initUI() {
		delete = new JButton("Delete");
		delete.addActionListener(new DeleteActionLinster());
		jp1 = new JPanel();
		jp1.add(delete);
		jp2 = new JPanel();
	
	}
	@SuppressWarnings("serial")
	private class DataModel extends DefaultListModel<Object> {
		
			@SuppressWarnings("unchecked")
			public DataModel() {
				for(Staff staff : CommonStaff.staffs) {
					String name = staff.getUsername();
					addElement(name);
				}
			}
		}
	
	private class DeleteActionLinster implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(jLists.getSelectedIndices().length > 0) {
				int [] objArr = jLists.getSelectedIndices();
				for(int i =0 ;i <objArr.length ; i++) {
					staffs.remove(objArr[i]);
					mode.remove(objArr[i]);
				}
			}
		}
		
	}
	
	}