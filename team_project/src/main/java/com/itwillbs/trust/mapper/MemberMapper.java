package com.itwillbs.trust.mapper;

import com.itwillbs.trust.vo.MemberVO;

public interface MemberMapper {

	MemberVO isLogin(String login_id, String result);
	
}
