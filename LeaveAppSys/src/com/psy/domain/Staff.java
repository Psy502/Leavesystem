package com.psy.domain;

public class Staff  {

	private String username;
	private String password;
	private String age;
	private Staff nextLeader;
	private LeaveRequest request;
	private int leaveFlag;
	public Staff() {
		
	}
	public Staff(String username , String password ) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Staff getNextLeader() {
		return nextLeader;
	}
	public void setNextLeader(Staff nextLeader) {
		this.nextLeader = nextLeader;
	}
	public LeaveRequest getRequest() {
		return request;
	}
	public void setRequest(LeaveRequest request) {
		this.request = request;
	}
	public int getLeaveFlag() {
		return leaveFlag;
	}
	public void setLeaveFlag(int leaveFlag) {
		this.leaveFlag = leaveFlag;
	}
	
}
