package com.itwilbs.trust.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwillbs.trust.mapper.AdminMapper;
import com.itwillbs.trust.vo.MemberVO;

@Service
public class AdminService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	public int getListCount(String table) {
		return adminMapper.selectListCount(table);
	}
	
	public ArrayList<MemberVO> getManagementList(int pageNum, int listLimit, String value) {
		return adminMapper.selectManagementList(pageNum, listLimit, value);
	}
	
	public MemberVO getStatusCount() {
		return adminMapper.getStatusCount();
	}
	
	public MemberVO getMemberDetail(String code) {
		return adminMapper.getMemberDetail(code);
	}
	
	public boolean getManagementUpdate(String code, String status,String reason) {
		return adminMapper.getManagementUpdate(code, status, reason);
	}
}
