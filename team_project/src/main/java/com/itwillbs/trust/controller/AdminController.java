package com.itwillbs.trust.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.itwilbs.trust.service.AdminService;
import com.itwillbs.trust.vo.AdminVO;
import com.itwillbs.trust.vo.ImgVO;
import com.itwillbs.trust.vo.MemberVO;
import com.itwillbs.trust.vo.PageInfo;
import com.itwillbs.trust.vo.SellVO;

@Controller
public class AdminController {

	@Autowired
	private AdminService service;
	
	// Management 리스트 및 검색 결과 리스트, 상태에 따른 리스트
	@RequestMapping(value = "Management", method = RequestMethod.GET)
	public String management(String page, @RequestParam(defaultValue = "") String value, Model model) {
		
		int pageNum = 1;
		int listLimit = 10;
		int pageLimit = 10;
		int startRow = (pageNum - 1) * listLimit;
		String table = "";
		if(page != null) {
			pageNum = Integer.parseInt(page);
		}
		// 해당하는 개시물의 총 수
		if (value != null) {
			if (value.equals("0") || value.equals("VVVIP")) {
				table = "info_detail";
				value = "VVVIP";
			} else if (value.equals("1") || value.equals("정상") || value.equals("2") || value.equals("정지") || value.equals("3") || value.equals("탈퇴")) {
				table = "service_log";
				if (value.equals("1") || value.equals("정상")) {
					value = "정상";
				} else if (value.equals("2") || value.equals("정지")) {
					value = "정지";
				} else {
					value = "탈퇴";
				}
			} else {
				table = "member";
			}
		} else {
			table = "member";
			value = "";
		}
		int listCount = service.getListCount(table);
		
		// 뿌려줄 리스트 List 객체
		List<Map<String, String>> memberList = service.getManagementList(startRow, listLimit, value);
		
		// 멤버 상태에 따른 회원 수
		Map<String, String> member = service.getStatusCount();
		
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
		model.addAttribute("value", value);
		
		return "AdminPage/management/management";
	}
	
	// 해당 회원 코드의 상세 정보 출력
	@RequestMapping(value = "ManagementDetail", method = RequestMethod.GET)
	public String detail(String code, String page, String value, Model model) {
		
		// 코드에 해당하는 회원의 상세정보 조회를 위한 getMemberDetail(code);
		MemberVO member = service.getMemberDetail(code);
		
		if(member != null) {
			model.addAttribute("member", member);
			model.addAttribute("value", value);
			model.addAttribute("page", page);
			return "AdminPage/management/management_detail";
		} else {
			model.addAttribute("msg", "해당 회원은 정보를 볼 수 없습니다.");
			return "HomePage/error_page/error";
		}
	}
	
	// 해당 회원의 상태 변경
	@RequestMapping(value = "ManagementUpdate", method = RequestMethod.POST)
	public String managementUpdate(String code, String status, String reason, String page, String value, Model model) {
		
		// 회원 상태 정보를 수정하기 위한 service.getManagementUpdate(code, status, reason)
		int isManagementUpdate = service.getManagementUpdate(code, status, reason); // 타입이 boolean이 아닐 수도 있다. mapper에 따라 리턴되는 값이 0, 1이라는 구글링 검색결과가 있기 때문이다.
		
		if(isManagementUpdate > 0) {
			model.addAttribute("code", code);
			model.addAttribute("page", page);
			model.addAttribute("value", value);
			return "redirect:ManagementDetail";
		} else {
			model.addAttribute("msg", "수정이 되지 않았습니다.");
			return "HomePage/error_page/error";
		}
		
	}
	
	// 탈퇴한 회원의 삭제
	@RequestMapping(value = "ManagementDelete", method = RequestMethod.GET)
	public String managementDelete(String code, String page, String value, Model model) {
		int delete = service.isDelete(code);
		
		if(delete > 0) {
			model.addAttribute("page", page);
			model.addAttribute("value", value);
			return "redirect:Management";
		} else {
			model.addAttribute("msg", "삭제 실패!");
			return "";
		}
		
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
		ArrayList<AdminVO> list = null;
		
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
		
		// 받아온 값으로 value_num(num)에 해당하는 상세정보 가져오기 service.getArticle(num, msg);
		AdminVO adminArticle = null;
		ArrayList<ImgVO> imgFileList = null;
		if(msg.equals("notice") || msg.equals("event")) {
			// imgFileList = service.getImg(num);
			model.addAttribute("adminArticle", adminArticle);
			model.addAttribute("imgFileList", imgFileList);
		} else if(msg.equals("qna")) {
			model.addAttribute("adminArticle", adminArticle);
		}
		
		return "AdminPage/notice/noticeView";
	}
	
	@RequestMapping(value = "ProductConfirm", method = RequestMethod.GET)
	public String productConfirm(String page, String type, String value, Model model) {
		
		// 페이징 처리를 위한 변수 선언
		int pageNum = 1; // 현재 페이지 번호
		int listLimit = 10; // 한 페이지 당 표시할 게시물 목록 갯수
		int pageLimit = 10; // 한 페이지 당 표시할 페이지 목록 갯수
		String table = "sell";
		
		System.out.println(value);
		
		if(page != null) {
			pageNum = Integer.parseInt(page);
		}
		
		// 상품의 상태에 따른 수 가져오기 service.getListCountType();
		SellVO CountType = null;
		
		// 해당 검수 목록 총 게시물 수 service.getListCount(table, type, value)
		// getListCount(String tableName, String search, String searchType) 
		// 공지사항 파트랑 같이 쓸 예정 (벌써부터 Mapper 생각에 머리가 아픔)
		int listCount = 0;
		
		// 페이지 처리 및 페이지에 해당하는 값을 가져오기 위한 작업
		int maxPage = (int)Math.ceil((double)listCount / listLimit);
		int startPage = ((int)((double)pageNum / pageLimit + 0.9) - 1) * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;

		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageInfo = new PageInfo(pageNum, maxPage, startPage, endPage, listCount,listLimit);
		
		// 작성된 sell 목록 가져오기 service.selectproductConfirmList(pageNum, listLimit, type, value);
		ArrayList<SellVO> productConfirmList = null;
		
		model.addAttribute("CountType", CountType);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("productConfirmList", productConfirmList);
		
		return "AdminPage/confirm/productConfirm";
	}
	
	@RequestMapping(value = "ProductConfirmDetail", method = RequestMethod.GET)
	public String productConfirmDetail(String value_num, String page, Model model) {
		int num = Integer.parseInt(value_num);
		
		// 해당 번호의 판매글 상세 정보 가져오기 service.getProductConfirmDetail(num);
		SellVO productConfirmDetail = null;
		
		// 해당 번호의 판매글 이미지 가져오기 service.getImg(int num);
		ArrayList<ImgVO> imgFileList = null;
		
		model.addAttribute("productConfirmDetail", productConfirmDetail);
		model.addAttribute("imgFileList", imgFileList);
		return "AdminPage/confirm/productConfirmView";
	}
	
	@RequestMapping(value = "ProductConfirmUpdate", method = RequestMethod.GET)
	public String productConfirmUpdate(String value_num, String status, String nickname, Model model) {
		int num = Integer.parseInt(value_num);
		
		// 받아온 값으로 업데이트가 실행이 되었는지 아닌지 판단하고 리턴 service.isProductConfirmUpdate(num, status, nickname)
		boolean isProductConfirmUpdate = false;
		
//		if(!isProductConfirmUpdate) {
//			model.addAttribute("msg", "검수확인 실패!");
//			return "HomePage/error_page/error";
//		} else {
//			return "ProductConfirm";
//		}
		
		return "ProductConfirm";
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
