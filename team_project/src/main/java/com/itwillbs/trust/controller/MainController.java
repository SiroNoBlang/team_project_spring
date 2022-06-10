package com.itwillbs.trust.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwilbs.trust.service.MemberService;
import com.itwillbs.trust.vo.MemberVO;

@Controller
public class MainController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value = "")
	public String checkEmail(HttpServletRequest request, String nickname, String id, String passwd, String email1, String email2, String gender, String age, String[] style, String[] brand, String[] category, Model model) {
		String like_style = "";
		String like_brand = "";
		String like_category = "";
		
		for(String s : style) {
			like_style += s + ",";
		}
		
		for(String s : brand) {
			like_brand += s + ",";
		}
		
		for(String s : category) {
			like_category += s + ",";
		}
		
		MemberVO member = new MemberVO();
		member.setNickname(nickname);
		member.setId(id);
		member.setPasswd(passwd);
		member.setEmail(email1 + email2);
		member.setGender(gender);
		member.setAge(age);
		member.setStyle(like_style);
		member.setBrand(like_brand);
		member.setCategory(like_category);
		
		if(service.checkEmail(member.getEmail(), request)) {
			model.addAttribute("memberVO", member);
			return "result";
		} else {
			model.addAttribute("msg", "사용하실 수 없는 이메일입니다.");
			return "";
		}
		
	}
	
	@RequestMapping(value = "")
	public String join(Model model) {
		model.getAttribute("memberVO");
		
		
		return "/";
	}
	
	
	
}
