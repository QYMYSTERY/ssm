package cwu.jsj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cwu.jsj.service.StatistialChartService;

@Controller
@RequestMapping("/index")
public class StatistialChartController {
	@Resource
	private StatistialChartService StatistialChartService;
	@RequestMapping("/statistialChart")
	public String echartShow(HttpServletRequest request) {
		
		List<Integer> list = StatistialChartService.getTimeInterval();
		
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
			}
		
		return "user/user_Index";
	}	
}
