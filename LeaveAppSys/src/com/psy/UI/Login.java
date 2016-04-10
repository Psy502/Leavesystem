package com.psy.UI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.psy.domain.LeaveRequest;
import com.psy.domain.Staff;
import com.psy.util.CommonStaff;
import com.psy.util.FindLeader;
import com.psy.util.LoginCheck;

public class Login extends JFrame{

	private JLabel jlb1 , jlb2;
	private JTextField jUsername ;
	private JPasswordField jPassword;
	private JButton login , reset;
	private JPanel jp1 , jp2 ,jp3;
	private List<Staff> staffs;
	public Login() {
		initUI();
	
		this.setLayout(new GridLayout(3,1));
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.setTitle("login");
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
	/**
	 * ��ʼ��UI
	 */
	private void initUI() {
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jlb1 = new JLabel("Username");
		jlb2 = new JLabel("Password");
		jUsername = new JTextField(12);
		jPassword = new JPasswordField(12);
		login = new JButton("Login");
		login.addActionListener(new LoginButtonListener());
		reset = new JButton("Reset");
		reset.addActionListener(new ResetButtonListener());
		jp1.add(jlb1);
		jp1.add(jUsername);
		jp2.add(jlb2);
		jp2.add(jPassword);
		jp3.add(login);
		jp3.add(reset);
		
	}


	private class LoginButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String username = jUsername.getText().trim();
			String password = jPassword.getText().trim();
			Staff staff = new Staff(username , password);
			boolean flag = LoginCheck.checkStaff(staff);
			if(flag) {
				Login.this.setVisible(false);
				
				int leaderIndex = FindLeader.findLeader(staff);
				Staff currStaff = CommonStaff.staffs.get(leaderIndex);
				if(currStaff != null) {
					if(currStaff.getLeaveFlag() == 1 ) {
						JOptionPane.showMessageDialog(null, "Login Successful,Your request has been approved");
					}
					else if(currStaff.getLeaveFlag() == 2) {
						JOptionPane.showMessageDialog(null, "Login Successful,Your requset has been refused");
					}
					else {
						JOptionPane.showMessageDialog(null, "Login Successful");
					}
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Wrong Username or Password");
			}
			
			
		}
		
	}
	private class ResetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			jUsername.setText("");
			jPassword.setText("");
			
		}
		
	}
}
