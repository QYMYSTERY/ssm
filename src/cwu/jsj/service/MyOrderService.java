package cwu.jsj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

import cwu.jsj.dao.UserMapper;
import cwu.jsj.model.Order;
import cwu.jsj.model.User;
@Service
public class MyOrderService {
	@Resource
	private UserMapper userMapper;
	
	public List<Order> listUnfinishedOrder(int userId){
		Order order=new Order();
		order.setUserId(userId);
		List<Order> orderList = userMapper.getUnfinishedOrder(order);
		return orderList;
	}
	
	public List<Order> listFinishedOrder(int userId){
		Order order=new Order();
		order.setUserId(userId);
		List<Order> orderList = userMapper.getFinishedOrder(order);
		return orderList;
	}
}
