package org.imooc.controller.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.imooc.bean.BusinessList;
import org.imooc.dto.AdDto;
import org.imooc.dto.BusinessDto;
import org.imooc.dto.BusinessListDto;
import org.imooc.service.AdService;
import org.imooc.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private AdService adService;
	
	@Resource
	private BusinessService businessService;
	
	@Value("${ad.number}")
	private int adNumber;
	
	@Value("${businessHome.number}")
	private int businessHomeNumber;

	@Value("${businessSearch.number}")
	private int businessSearchNumber;
	
	/**
	 * 首页 —— 广告（超值特惠）
	 */
	@RequestMapping(value = "/homead",method = RequestMethod.GET)
	public List<AdDto> homead(){
		AdDto adDto = new AdDto();
		adDto.getPage().setPageNumber(adNumber);
		return adService.searchByPage(adDto);
	}
	
	/**
	 * 首页 —— 推荐列表（猜你喜欢）
	 */
	@RequestMapping(value = "/homelist/{city}/{page.currentPage}", method = RequestMethod.GET)
	public BusinessListDto homelist(BusinessDto businessDto) {
		businessDto.getPage().setPageNumber(businessHomeNumber);
		return businessService.searchByPageForApi(businessDto);
	}
	
	@RequestMapping(value = "/submitComment",method = RequestMethod.POST)
	public Map<String, Object> submitComment() throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("errno ", 0);
		resultMap.put("msg ", "ok");
		return resultMap;
	}
}
