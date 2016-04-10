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

public class AskForLeave extends JFrame{

	private JLabel jlb1 , jlb2;
	private JTextField jStartTime ,jEndTime ;
	private JButton submit , reset;
	private JPanel jp1 , jp2 ,jp3;
	private Staff applyStaff;
	public AskForLeave() {
		initUI();
		applyStaff = CommonStaff.currentStaff;
		this.setLayout(new GridLayout(3,1));
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
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
		jlb1 = new JLabel("Start Time");
		jlb2 = new JLabel("End Time");
		jStartTime = new JTextField(12);
		jEndTime = new JTextField(12);
		submit = new JButton("submit");
		submit.addActionListener(new SubmitButtonListener());
		reset = new JButton("reset");
		reset.addActionListener(new ResetButtonListener());
		jp1.add(jlb1);
		jp1.add(jStartTime);
		jp2.add(jlb2);
		jp2.add(jEndTime);
		jp3.add(submit);
		jp3.add(reset);
		
	}
	
	private class SubmitButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String startTime = jStartTime.getText().trim();
			String endTime = jEndTime.getText().trim();
			LeaveRequest request = new LeaveRequest(applyStaff , startTime , endTime);
			int leaderIndex = FindLeader.findLeader(applyStaff.getNextLeader());
			CommonStaff.staffs.get(leaderIndex).setRequest(request);
			System.out.println(CommonStaff.staffs.get(leaderIndex).getRequest().getEndTime());
			JOptionPane.showMessageDialog(null, "Submit ask for leave request successful");
			AskForLeave.this.setVisible(false);
		}
		
	}
	private class ResetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			jStartTime.setText("");
			jEndTime.setText("");
			
		}
		
	}
}
