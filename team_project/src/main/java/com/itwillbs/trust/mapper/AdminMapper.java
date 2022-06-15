package com.itwillbs.trust.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.itwillbs.trust.vo.AdminVO;
import com.itwillbs.trust.vo.ImgVO;
import com.itwillbs.trust.vo.MemberVO;
import com.itwillbs.trust.vo.SellVO;

public interface AdminMapper {

	public int selectListCount(@Param("table") String table,@Param("search") String search, @Param("searchType") String searchType);

	public List<Map<String, String>> selectManagementList(@Param("startRow") int startRow, @Param("listLimit") int listLimit, @Param("value") String value);

	public Map<String, String> getStatusCount();

	public MemberVO getMemberDetail(@Param("code") String code);

	public int getManagementUpdate(@Param("code") String code, @Param("status") String status, @Param("reason") String reason);
	
	public int isDelete(@Param("code") String code);

	ArrayList<AdminVO> selectList(@Param("startRow") int startRow, @Param("listLimit") int listLimit, @Param("table") String table, @Param("search") String search, @Param("searchType") String searchType);

	AdminVO getArticle(@Param("num") int num,@Param("msg") String msg);

	ArrayList<ImgVO> getImg(int num);

	SellVO getListCountType();

	ArrayList<SellVO> selectproductConfirmList(int pageNum, int listLimit, String type, String value);

	SellVO getProductConfirmDetail(int num);

	boolean isProductConfirmUpdate(int num, String status, String nickname);

}
