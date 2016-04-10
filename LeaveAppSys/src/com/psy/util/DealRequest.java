package com.psy.util;

import com.psy.domain.LeaveRequest;
import com.psy.domain.Staff;

public class DealRequest {
	
	public DealRequest(LeaveRequest request) {
		Staff staff = CommonStaff.currentStaff;
		staff.getNextLeader().setRequest(request);
		
	}
}
