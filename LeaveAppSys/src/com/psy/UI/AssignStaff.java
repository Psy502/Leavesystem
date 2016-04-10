package com.psy.UI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.psy.domain.Staff;
import com.psy.util.CommonStaff;

public class AssignStaff extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton assign;
	private JPanel jp1 , jp2 ,jp3;
	private List<Staff> staffs;
	private JList<Staff> jLists ,jSupervisor;
	private DefaultListModel  mode;
	
	public  AssignStaff() {
		this.setTitle("assign");
		initUI();
		staffs = CommonStaff.staffs;
		this.setLayout(new GridLayout(1, 3));
		mode = new DataModel();
		jLists = new JList<Staff>(mode);
		jLists.setBorder(BorderFactory.createTitledBorder("Staffs"));
		jLists.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.add(new JScrollPane(jLists));
		jSupervisor = new JList<Staff>(mode);
		jSupervisor.setBorder(BorderFactory.createTitledBorder("Supervisors"));
		jSupervisor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.add(new JScrollPane(jSupervisor));
		this.add(jp1);
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
		assign = new JButton("Assign");
		assign.addActionListener(new AssignButtonListener());
		jp1 = new JPanel();
		jp1.add(assign);
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		
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
	private class AssignButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(jLists.getSelectedIndex() < 0 ) {
				JOptionPane.showMessageDialog(null, "Please select staff");
				return;
			}
			if(jSupervisor.getSelectedIndex() < 0 ) {
				JOptionPane.showMessageDialog(null, "Please select Supervisor");
				return;
			}
			int staffIndex = jLists.getSelectedIndex();
			Staff staff = staffs.get(staffIndex);
			if(staff.getNextLeader() != null) {
				JOptionPane.showMessageDialog(null, "This staff already has supervisor,please select again");
				return;
			}
			int supervisorIndex = jSupervisor.getSelectedIndex();
			Staff supervisor = staffs.get(supervisorIndex);
			staff.setNextLeader(supervisor);
			JOptionPane.showMessageDialog(null, "Assign supervisor sucessful");
		}
		
	}
}
