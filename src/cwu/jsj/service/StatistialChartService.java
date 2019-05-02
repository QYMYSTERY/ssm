package cwu.jsj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cwu.jsj.dao.UserMapper;
@Service
public class StatistialChartService {
	@Resource
	private UserMapper userMapper;
	
	public List<Integer> getTimeInterval(){
		List<Integer> timeInterval = userMapper.getTimeInterval();
		return timeInterval;
	}
}
