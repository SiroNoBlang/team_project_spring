package com.itwillbs.trust.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.itwillbs.trust.vo.AdminVO;
import com.itwillbs.trust.vo.MemberVO;
import com.itwillbs.trust.vo.PageInfo;

@Controller
public class AdminController {

//	@Autowired
//	private AdminService service;
	
	@RequestMapping(value = "Management", method = RequestMethod.GET)
	public String management(String page, String value, Model model) {
		
		int pageNum = 1;
		int listLimit = 10;
		int pageLimit = 10;
		String table = "member";
		
		System.out.println(value);
		
		if(page != null) {
			pageNum = Integer.parseInt(page);
		}
		
		// 개시물이 총 개있는지 service.getListCount(table);
		int listCount = 0;
		
		// 뿌려줄 리스트 List 객체 service.getManagementList(pageNum, listLimit, value)
		ArrayList<MemberVO> memberList = null;
		
		// 멤버 상태에 따른 회원 수 service.getStatusCount();
		MemberVO member = new MemberVO();
		member.setTop_level(10);
		member.setNomal(60);
		member.setSuspension(90);
		member.setWithdrawal(50);
		
		int maxPage = (int)Math.ceil((double)listCount / listLimit);
		int startPage = ((int)((double)pageNum / pageLimit + 0.9) - 1) * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;

		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageInfo = new PageInfo(pageNum, maxPage, startPage, endPage, listCount);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("member", member);
		model.addAttribute("memberList", memberList);
		
		return "AdminPage/management/management";
	}
	
	@RequestMapping(value = "ManagementDetail", method = RequestMethod.GET)
	public String detail(String code, String page, String value, Model model) {
		
		System.out.println(code);
		System.out.println(page);
		System.out.println(value);
		
		// 코드에 해당하는 회원의 상세정보 조회를 위한 getMemberDetail(code);
		MemberVO member;
		
//		if(member != null) {
//			model.addAttribute("member", member);
//			model.addAttribute("page", page);
//			return "AdminPage/management/management_detail";
//		} else {
//			model.addAttribute("msg", "해당 회원은 정보를 볼 수 없습니다.");
//			return "";
//		}
		
		model.addAttribute("code", code);
		model.addAttribute("page", page);
		model.addAttribute("value", value);
		return "AdminPage/management/management_detail";
	}
	
	@RequestMapping(value = "ManagementUpdate", method = RequestMethod.POST)
	public String managementUpdate(String code, String status, String reason, String page, String value, Model model) {
		
		System.out.println(code);
		System.out.println(status);
		System.out.println(reason);
		System.out.println(page);
		System.out.println(value);
		
		// 회원 상태 정보를 수정하기 위한 service.getManagementUpdate(code, status, reason)
		boolean isManagementUpdate; // 타입이 boolean이 아닐 수도 있다. mapper에 따라 리턴되는 값이 0, 1이라는 구글링 검색결과가 있기 때문이다.
		
//		if(isManagementUpdate) {
//			model.addAttribute("code", code);
//			model.addAttribute("page", page);
//			return "redirect:ManagementDetail";
//		} else {
//			model.addAttribute("msg", "수정이 되지 않았습니다.");
//			return "";
//		}
		
		model.addAttribute("code", code);
		model.addAttribute("page", page);
		model.addAttribute("value", value);
		return "redirect:ManagementDetail";
	}
	
	@RequestMapping(value = "Community", method = RequestMethod.GET)
	public String community(@RequestParam(defaultValue = "") String table, String page, String search, String searchType, Model model) {
		System.out.println(table);
		
		// 페이징 처리를 위한 변수 선언
		int pageNum = 1; // 현재 페이지 번호
		int listLimit = 10; // 한 페이지 당 표시할 게시물 목록 갯수
		int pageLimit = 10; // 한 페이지 당 표시할 페이지 목록 갯수
		
		if(page != null) {
			pageNum = Integer.parseInt(page);
		}
		
		// 해당 테이블에 총 게시물 가져오기 service.getListCount(tableName, search, searchType)
		int listCount = 0;
		
		// 해당 게시물 목록 담을 변수 설정 service.selectList(pageNum, listLimit, search, searchType)
		ArrayList<MemberVO> list = null;
		
		int maxPage = (int)Math.ceil((double)listCount / listLimit);
		int startPage = ((int)((double)pageNum / pageLimit + 0.9) - 1) * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;

		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageInfo = new PageInfo(pageNum, maxPage, startPage, endPage, listCount, listLimit);

		
		if(table.equals("notice")) {
			
			model.addAttribute("list", list);
			model.addAttribute("msg", "공지사항");
			model.addAttribute("pageInfo", pageInfo);
			return "AdminPage/notice/noticeList";
		} else if(table.equals("event")) {
			
			model.addAttribute("list", list);
			model.addAttribute("msg", "이벤트");
			model.addAttribute("pageInfo", pageInfo);
			return "AdminPage/notice/noticeList";
		} else if(table.equals("qna")) {
			
			model.addAttribute("list", list);
			model.addAttribute("msg", "QnA");
			model.addAttribute("pageInfo", pageInfo);
			return "AdminPage/notice/noticeList";
		} else {
			return "AdminPage/notice/communityWrite";
		}
	}
	
	@RequestMapping(value = "CommunityDetail", method = RequestMethod.GET)
	public String communityDetail(String value_num, String page, String msg, Model model) {
		
		// 데이터베이스가 int 타입으로 되어 있기 때문에 변경 필수
		int num = Integer.parseInt(value_num);
		
		// 받아온 값으로 value_num(num)에 해당하는 상세정보 가져오기
		if(msg.equals("notice") || msg.equals("event")) {
			
		} else if(msg.equals("qna")) {
			
		}
		
		
		return "AdminPage/notice/noticeView";
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "Sales", method = RequestMethod.GET)
	public String sales() {
		return "AdminPage/sales/sales_main";
	}
	
	@RequestMapping(value = "SalesChart", method = RequestMethod.POST)
	public void salesChart(HttpServletResponse response) {
		String[] month = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		
		// 각 월에 해당하는 값 담기 service.getSalesChartList(month);
		List<AdminVO> salesChartList = null;
		
		String json = new Gson().toJson(salesChartList);
		
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
