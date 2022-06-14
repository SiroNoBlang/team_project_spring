package com.itwillbs.trust.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.itwillbs.trust.vo.MemberVO;

public interface MemberMapper {

	public Map<String, String> isLogin(@Param("id") String id, @Param("passwd") String passwd);
	
}
