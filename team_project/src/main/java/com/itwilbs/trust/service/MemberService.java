package com.itwilbs.trust.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwillbs.trust.mapper.MemberMapper;
import com.itwillbs.trust.vo.MemberVO;

@Service
public class MemberService {

	@Autowired
	private MemberMapper mapper;
	
	public boolean checkNickname(String nickname) {
		return false;
	}

	public Map<String, String> isLogin(String id, String passwd) {
		return mapper.isLogin(id, passwd);
	}
	
}
