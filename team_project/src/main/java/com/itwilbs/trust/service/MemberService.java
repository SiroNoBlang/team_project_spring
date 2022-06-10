package com.itwilbs.trust.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwillbs.trust.mapper.MemberMapper;

import googleSMTPAuthenticator.GenerateAuthenticationCode;

@Service
public class MemberService {

	@Autowired
	private MemberMapper mapper;

	public boolean checkEmail(String email, HttpServletRequest request) {
		boolean isSendEmail = false;
		
		GenerateAuthenticationCode genCode = new GenerateAuthenticationCode();
		String code = genCode.getAuthenticationCode();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		String sender = "qhrud200265@gmail.com";
		String title = "";
		String receiver = email;
		String content = "";
		
		return false;
	}
	
	
	
	
}
