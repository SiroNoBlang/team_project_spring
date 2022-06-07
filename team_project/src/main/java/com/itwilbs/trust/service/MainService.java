package com.itwilbs.trust.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwillbs.trust.mapper.ProductMapper;
import com.itwillbs.trust.mapper.SellMapper;

@Service
public class MainService {
	
	@Autowired
	private SellMapper sellMapper;
	private ProductMapper productMapper;
	
	
	
}
