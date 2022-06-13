package com.itwillbs.trust.mapper;

import java.util.ArrayList;

import com.itwillbs.trust.vo.AdminVO;
import com.itwillbs.trust.vo.ImgVO;
import com.itwillbs.trust.vo.MemberVO;
import com.itwillbs.trust.vo.SellVO;

public interface AdminMapper {

	int selectListCount(String table, String value);

	ArrayList<MemberVO> selectManagementList(int pageNum, int listLimit, String value);

	MemberVO getStatusCount();

	MemberVO getMemberDetail(String code);

	boolean getManagementUpdate(String code, String status, String reason);

	int getListCount(String tableName, String search, String searchType);

	AdminVO selectList(String pageNum, String listLimit, String search, String searchType);

	AdminVO getArticle(int num, String msg);

	ArrayList<ImgVO> getImg(int num);

	SellVO getListCountType();

	ArrayList<SellVO> selectproductConfirmList(int pageNum, int listLimit, String type, String value);

	SellVO getProductConfirmDetail(int num);

	boolean isProductConfirmUpdate(int num, String status, String nickname);

}
