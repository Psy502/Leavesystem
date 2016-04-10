package com.psy.util;

import java.util.List;

import com.psy.domain.Staff;

public class LoginCheck {
	
	public static boolean checkStaff(Staff staff) {
		if(staff.getRequest() !=null) {
			System.out.println(staff.getRequest().getApplyStaff().getUsername());
		}
		boolean flag = false;
		if(null == staff) {
			return flag;
		}
		List<Staff> staffs = CommonStaff.staffs;
		
		if(null == staffs || staffs.size() <= 0) {
			return flag;
		}
		for(Staff s : staffs ) {
			String username = s.getUsername();
			String password = s.getPassword();
			if(staff.getUsername().equals(username) && staff.getPassword().equals(password)) {
				flag = true;
				CommonStaff.currentStaff = s;
			System.out.println(s.getRequest());
				return flag ;
			}
			
		}
		return flag;
	}
	
}
