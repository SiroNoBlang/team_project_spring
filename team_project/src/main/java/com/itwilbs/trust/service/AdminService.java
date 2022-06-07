package com.itwilbs.trust.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwillbs.trust.mapper.EventMapper;
import com.itwillbs.trust.mapper.NoticeMapper;
import com.itwillbs.trust.mapper.QnAMapper;

@Service
public class AdminService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	private EventMapper eventMapper;
	private QnAMapper qnaMapper;
	
	
	
}
