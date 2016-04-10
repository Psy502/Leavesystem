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
import javax.swing.JTextField;

import com.psy.domain.Staff;
import com.psy.util.CommonStaff;

public class AddStaff extends JFrame{

	private JLabel jlb1 , jlb2;
	private JTextField jUsername ,jPassword ;
	private JButton add , reset;
	private JPanel jp1 , jp2 ,jp3;
	private List<Staff> staffs;
	public AddStaff() {
		initUI();
		staffs = CommonStaff.staffs;
		this.setLayout(new GridLayout(3,1));
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.setTitle("add staff");
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
		jlb1 = new JLabel("uesrname");
		jlb2 = new JLabel("password");
		jUsername = new JTextField(12);
		jPassword = new JTextField("123456" ,12);
		add = new JButton("add");
		add.addActionListener(new AddButtonListener());
		reset = new JButton("reset");
		reset.addActionListener(new ResetButtonListener());
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp1.add(jlb1);
		jp1.add(jUsername);
		jp2.add(jlb2);
		jp2.add(jPassword);
		jp3.add(add);
		jp3.add(reset);
	}
	private class AddButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String username = jUsername.getText().trim();
			String password = jPassword.getText().trim();
			Staff staff = new Staff(username , password);
			staffs.add(staff);
			JOptionPane.showMessageDialog(null, "Add stuff successful");
		}
		
	}
	private class ResetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			jUsername.setText("");		
			jPassword.setText("");
		}
		
	}
}
