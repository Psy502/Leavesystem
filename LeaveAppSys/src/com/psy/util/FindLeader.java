package com.psy.util;


import java.util.List;

import com.psy.domain.Staff;

public class FindLeader {
	
	public static int findLeader(Staff staff) {
		int index =-1;
		if(staff == null) {
			return index;
		}
		
		List<Staff> staffs = CommonStaff.staffs;
		for(int i = 0 , length = staffs.size() ; i < length ; i++) {
			if(staff.getUsername().equals(staffs.get(i).getUsername())) {
				index =  i;
				return index;
			}
		}
		return index;
	}
}
