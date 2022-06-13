package com.itwillbs.trust.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.itwillbs.trust.vo.AdminVO;
import com.itwillbs.trust.vo.ImgVO;
import com.itwillbs.trust.vo.MemberVO;
import com.itwillbs.trust.vo.SellVO;

public interface AdminMapper {

	public int selectListCount(@Param("table") String table,@Param("value") String value);

	public ArrayList<MemberVO> selectManagementList(@Param("pageNum") int pageNum, @Param("listLimit") int listLimit, @Param("value") String value);

	public MemberVO getStatusCount();

	public MemberVO getMemberDetail(String code);

	public boolean getManagementUpdate(String code, String status, String reason);

	public int getListCount(String tableName, String search, String searchType);

	AdminVO selectList(String pageNum, String listLimit, String search, String searchType);

	AdminVO getArticle(int num, String msg);

	ArrayList<ImgVO> getImg(int num);

	SellVO getListCountType();

	ArrayList<SellVO> selectproductConfirmList(int pageNum, int listLimit, String type, String value);

	SellVO getProductConfirmDetail(int num);

	boolean isProductConfirmUpdate(int num, String status, String nickname);

}
