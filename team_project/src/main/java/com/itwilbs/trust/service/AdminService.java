package com.itwilbs.trust.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwillbs.trust.mapper.AdminMapper;
import com.itwillbs.trust.vo.AdminVO;
import com.itwillbs.trust.vo.ImgVO;
import com.itwillbs.trust.vo.MemberVO;
import com.itwillbs.trust.vo.SellVO;

@Service
public class AdminService {

	@Autowired
	private AdminMapper adminMapper;

	public int selectListCount(String table, String search, String searchType) {
		return adminMapper.selectListCount(table, search, searchType);
	}

	public List<Map<String, String>> getManagementList(int startRow, int listLimit, String value) {
		return adminMapper.selectManagementList(startRow, listLimit, value);
	}

	public Map<String, String> getStatusCount() {
		return adminMapper.getStatusCount();
	}

	public MemberVO getMemberDetail(String code) {
		return adminMapper.getMemberDetail(code);
	}

	public int getManagementUpdate(String code, String status, String reason) {
		return adminMapper.getManagementUpdate(code, status, reason);
	}

	public int isDelete(String code) {
		return adminMapper.isDelete(code);
	}

	public ArrayList<AdminVO> selectList(int startRow, int listLimit, String table, String search, String searchType) {
		return adminMapper.selectList(startRow, listLimit, table, search, searchType);
	}

	public AdminVO getArticle(int num, String msg) {
		return adminMapper.getArticle(num, msg);
	}

	public ArrayList<ImgVO> getImg(int num) {
		return adminMapper.getImg(num);
	}

	public SellVO getListCountType() {
		return adminMapper.getListCountType();
	}

	public ArrayList<SellVO> selectproductConfirmList(int pageNum, int listLimit, String type, String value) {
		return adminMapper.selectproductConfirmList(pageNum, listLimit, type, value);
	}

	public SellVO getProductConfirmDetail(int num) {
		return adminMapper.getProductConfirmDetail(num);
	}

	public boolean isProductConfirmUpdate(int num, String status, String nickname) {
		return adminMapper.isProductConfirmUpdate(num, status, nickname);
	}

}
