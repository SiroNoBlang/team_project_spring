package com.itwillbs.trust.mapper;

import java.util.ArrayList;

import com.itwillbs.trust.vo.MemberVO;

public interface AdminMapper {

	int selectListCount(String table);

	ArrayList<MemberVO> selectManagementList(int pageNum, int listLimit, String value);

	MemberVO getStatusCount();

	MemberVO getMemberDetail(String code);

	boolean getManagementUpdate(String code, String status, String reason);

}
