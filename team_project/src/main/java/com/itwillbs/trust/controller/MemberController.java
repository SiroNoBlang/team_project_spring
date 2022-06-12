package com.itwillbs.trust.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.trust.vo.MemberVO;

import googleSMTPAuthenticator.MyMessageDigest;

@Controller
public class MemberController {
	
//	@Autowired
//	private MemberService service;

	@RequestMapping(value = "/Join", method = RequestMethod.POST)
	public String checkEmail(HttpServletRequest request, String join_nickname, String join_id, String join_passwd, String join_email1, String join_email2, String join_gender, String join_age, String[] join_style, String[] join_brand, String[] join_category, Model model) {
		String like_style = "";
		String like_brand = "";
		String like_category = "";
		
		for(String s : join_style) {
			like_style += s + ",";
		}
		
		for(String s : join_brand) {
			like_brand += s + ",";
		}
		
		for(String s : join_category) {
			like_category += s + ",";
		}
		
		MemberVO member = new MemberVO();
		member.setNickname(join_nickname);
		member.setId(join_id);
		member.setPasswd(join_passwd);
		member.setEmail(join_email1 + join_email2);
		member.setGender(join_gender);
		member.setAge(join_age);
		member.setStyle(like_style);
		member.setBrand(like_brand);
		member.setCategory(like_category);
		
		System.out.println(member.getNickname());
		System.out.println(member.getId());
		System.out.println(member.getPasswd());
		System.out.println(member.getEmail());
		System.out.println(member.getGender());
		System.out.println(member.getAge());
		System.out.println(member.getStyle());
		System.out.println(member.getBrand());
		System.out.println(member.getCategory());
		
//		if(service.checkEmail(member.getEmail(), request)) {
//			model.addAttribute("memberVO", member);
//			return "result";
//		} else {
//			model.addAttribute("msg", "사용하실 수 없는 이메일입니다.");
//			return "";
//		}
		
		return "";
	}
	
	@RequestMapping(value = "Login", method = RequestMethod.POST)
	public String login(String login_id, String login_passwd, HttpSession session) {
		String algorithm = "SHA-256";
		
		MyMessageDigest mmd = new MyMessageDigest(algorithm, login_passwd);
		String result = mmd.getHashedData();
		
//		MemberVO isLogin = service.isLogin(login_id, result);
		
		// 나중에 삭제해야 됩니다.
		System.out.println(login_id);
		System.out.println(login_passwd);
		System.out.println(result);
		
//		if(isLogin != null) {
//			if(isLogin.getLevel().equals("Admin")) {
//				model.addAttribute("code", isLogin.getCode());
//				model.addAttribute("nickname", isLogin.getNickname());
//				return "";
//			} else if(isLogin.getStatus().equals("정상")) {
//				model.addAttribute("code", isLogin.getCode());
//				model.addAttribute("nickname", isLogin.getNickname());
//				return "";
//			} else if(isLogin.getStatus().equals("정지")) {
//				model.addAttribute("code", isLogin.getCode());
//				model.addAttribute("nickname", isLogin.getNickname());
//				return "";
//			} else if(isLogin.getStatus().equals("탈퇴")) {
//				model.addAttribute("code", isLogin.getCode());
//				model.addAttribute("nickname", isLogin.getNickname());
//				return "";
//			}
//		} else {
//			model.addAttribute("msg", "로그인 실패");
//			return "";
//		}
		
		session.setAttribute("code", login_id);
		session.setAttribute("nickname", result);
		
		return "redirect:/Management";
	}
	
	@RequestMapping(value = "Logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:HomePage/first_page/index";
	}
	
	@RequestMapping(value = "findId")
	public String findId(String find_id_nickname, String find_id_email, Model model) {
		System.out.println(find_id_nickname);
		System.out.println(find_id_email);
		
		// nickname과 email이 일치하는 아이디 가져오기 service.isFindId(find_id_nickname, find_id_email)
		String id = "";
		
		model.addAttribute("id", id);
		return "";
	}
}
