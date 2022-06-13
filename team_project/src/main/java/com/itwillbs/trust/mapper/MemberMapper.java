package com.itwillbs.trust.mapper;

import org.apache.ibatis.annotations.Param;

import com.itwillbs.trust.vo.MemberVO;

public interface MemberMapper {

	public MemberVO isLogin(@Param("id") String id, @Param("passwd") String passwd);
	
}
