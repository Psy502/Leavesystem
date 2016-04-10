package com.psy.UI;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.psy.domain.LeaveRequest;
import com.psy.domain.Staff;
import com.psy.util.CommonStaff;

public class Operate extends JFrame{

	private JLabel jlb1 , jlb2 ,jlb3 , jlb4 ,jlb5 ;
	private JButton add , delete , assign , leave , deal ,login, logout;
	private JPanel jp1 , jp2 ,jp3 , jp4 ,jp5,jlogInOut;
	private List<Staff> staffs;
	private Staff currentStaff;
	public Operate() {
		currentStaff = CommonStaff.currentStaff;
		initUI();
		this.setTitle("Operate");;
		initStaffs();
		this.setLayout(new GridLayout(6,1));
		this.add(jlogInOut);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
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
	private void initStaffs() {
		
		staffs = CommonStaff.staffs;
		Staff director = new Staff("admin" , "admin");
		Staff s1 = new Staff("psy1" , "psy1");
		s1.setNextLeader(director); //
		Staff s2 = new Staff("psy2" , "psy2"); 
		s2.setNextLeader(director); 
		Staff s3 = new Staff("psy3" , "psy3");
		s3.setNextLeader(s1); //
		Staff s4 = new Staff("psy4" , "psy4");
		s4.setNextLeader(s1); 
		Staff s5 = new Staff("psy5" , "psy5");
		s5.setNextLeader(s1);
		Staff s6 = new Staff("psy6" , "psy6");
		s6.setNextLeader(s1);
		staffs.add(director);
		staffs.add(s1);
		staffs.add(s2);
		staffs.add(s3);
		staffs.add(s4);
		staffs.add(s5);
		staffs.add(s6);
		System.out.println(staffs.get(0).getRequest());
	}
	private void initUI() {
		
		add = new JButton("Add");
		add.addActionListener(new AddButtonListener());
		delete = new JButton("Delete");
		delete.addActionListener(new DeleteButtonListener());
		assign = new JButton("Assign");
		assign.addActionListener(new AssignButtonListener());
		login = new JButton("Login");
		login.addActionListener(new LoginButtonListener());
		logout = new JButton("Logout");
		logout.addActionListener(new LogoutButtonListener());
		deal = new JButton("Deal");
		deal.addActionListener(new DealButtonListener());
		jlogInOut = new JPanel();
		jlogInOut.add(login);
		jlogInOut.add(logout);
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp1.add(add);
		jp2.add(delete);
		jp3.add(assign);
		leave = new JButton("Ask for Leave");
		leave.addActionListener(new LeaveButtonListener());
		jp4.add(leave);
		jp5 = new JPanel();
		jp5.add(deal);
	
	}
	private class AddButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			currentStaff = CommonStaff.currentStaff;
			if(currentStaff == null) {
				JOptionPane.showMessageDialog(null, "Login first");
				return;
			}
			new AddStaff();
			
		}
		
	}
	private class LeaveButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			currentStaff = CommonStaff.currentStaff;
			if(currentStaff == null) {
				JOptionPane.showMessageDialog(null, "Login first");
				return;
			}
			if(currentStaff.getNextLeader() == null) {
				JOptionPane.showMessageDialog(null, "You don't have supervisor,no need for ask for leave ");
				return;
			}
			new AskForLeave();
		}
		
	}
	private class DeleteButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			currentStaff = CommonStaff.currentStaff;
			if(currentStaff == null) {
				JOptionPane.showMessageDialog(null, "Login first");
				return;
			}
			new DeleteStaff();
			
		}
		
	}
	private class AssignButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			currentStaff = CommonStaff.currentStaff;
			if(currentStaff == null) {
				JOptionPane.showMessageDialog(null, "Login first");
				return;
			}
			new AssignStaff();
			
		}
		
	}
	private class LoginButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			currentStaff = CommonStaff.currentStaff;
			if(currentStaff != null) {
				JOptionPane.showMessageDialog(null, "You have already login, logout first");
				return;
			}
			new Login();
			
		}
		
	}
	private class LogoutButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			currentStaff = CommonStaff.currentStaff;
			if(currentStaff == null) {
				JOptionPane.showMessageDialog(null, "You did not login");
				return;
			}
			CommonStaff.currentStaff = null;
			JOptionPane.showMessageDialog(null, "Logout successful");
		}
		
	}
	private class DealButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			currentStaff = CommonStaff.currentStaff;
			if(currentStaff == null) {
				JOptionPane.showMessageDialog(null, "Login first");
				return;
			}
			if(currentStaff.getRequest() == null) {
				JOptionPane.showMessageDialog(null, "No ask for leave information");
				return;
			}
			new DealLeave();
		}
		
	}
	public static void main(String[]args) {
		new Operate();
	}
}
