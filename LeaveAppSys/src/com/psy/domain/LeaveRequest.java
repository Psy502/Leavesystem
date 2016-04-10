package com.psy.domain;

/**
 * 
 * @author psy
 *
 */
public class LeaveRequest {

	private Staff applyStaff;
	private String startTime;
	private String endTime;
	private Staff dealStaff;
	
	public LeaveRequest() {
		
	}
	public LeaveRequest(Staff applyStaff , String startTime , String endTime) {
		this.applyStaff = applyStaff;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public Staff getApplyStaff() {
		return applyStaff;
	}
	public void setApplyStaff(Staff applyStaff) {
		this.applyStaff = applyStaff;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Staff getDealStaff() {
		return dealStaff;
	}
	public void setDealStaff(Staff dealStaff) {
		this.dealStaff = dealStaff;
	}
}
