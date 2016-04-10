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

import com.psy.domain.LeaveRequest;
import com.psy.domain.Staff;
import com.psy.util.CommonStaff;
import com.psy.util.FindLeader;

public class DealLeave extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel startTime , endTime , applyName;
	private JButton endorse , decline;
	private JPanel jp1 , jp2 ,jp3 ,jp4;
	private Staff currentStaff;
	 Staff applayStaff;
	LeaveRequest request;
	public DealLeave() {
		initUI();
		this.setLayout(new GridLayout(4,1));
		this.add(jp4);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.setTitle("Deal leave");
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
		currentStaff = CommonStaff.currentStaff;
		 request = currentStaff.getRequest();
		if(null != request) {
			String start = request.getStartTime();
			String end = request.getEndTime();
		
			applayStaff = request.getApplyStaff();
			applyName = new JLabel("Apply Staff : " + applayStaff.getUsername());
			
			startTime = new JLabel("StartTime : " +start);
			endTime = new JLabel("EndTime : " + end);
			endorse = new JButton("Endorse");
			endorse.addActionListener(new EndorseButtonListener());
			decline = new JButton("Decline");
			decline.addActionListener(new DeclineButtonListener());
			jp1 = new JPanel();
			jp2 = new JPanel();
			jp3 = new JPanel();
			jp4 = new JPanel();
			jp4.add(applyName);
			jp1.add(startTime);
			jp2.add(endTime);
			jp3.add(endorse);
			jp3.add(decline);
		}
	}
	private class EndorseButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(null == currentStaff.getNextLeader()) {
				int leaderIndex = FindLeader.findLeader(applayStaff);
				applayStaff = CommonStaff.staffs.get(leaderIndex);
				applayStaff.setLeaveFlag(1);
				JOptionPane.showMessageDialog(null, "Successful");
				DealLeave.this.setVisible(false);
			}else {
				int leaderIndex = FindLeader.findLeader(currentStaff.getNextLeader());
				CommonStaff.staffs.get(leaderIndex).setRequest(request);
				JOptionPane.showMessageDialog(null, "Successful,move to the next supervisor");
				DealLeave.this.setVisible(false);
			}
		
		}
		
	}
	private class DeclineButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int leaderIndex = FindLeader.findLeader(applayStaff);
			applayStaff = CommonStaff.staffs.get(leaderIndex);
			System.out.println(applayStaff.getUsername());
			applayStaff.setLeaveFlag(2);
			JOptionPane.showMessageDialog(null, "Successful,You decilned a ask for leave requirment");
			DealLeave.this.setVisible(false);
			
		}
		
	}
}
