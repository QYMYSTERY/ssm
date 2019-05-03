package cwu.jsj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cwu.jsj.dao.AdminMapper;
import cwu.jsj.model.Order;
@Service
public class AdminManageOrderService {
	@Resource
	private AdminMapper adminMapper;
	
	public List<Order> getPrintingOrder(){
		List<Order> orderList = adminMapper.getPrintingOrder();
		return orderList;
	}
	
	public List<Order> getFinishedOrder(){
		List<Order> orderList = adminMapper.getFinishedOrder();
		return orderList;
	}
	
	public List<Order> getAllOrder(){
		List<Order> orderList = adminMapper.getAllOrder();
		return orderList;
	}
	
	public int updateStatus(int orderId,int orderStatus){
		Order order  = new Order();
		order.setId(orderId);
		order.setOrderStatus(orderStatus);
		int result = adminMapper.updateOrderStatus(order);
		return result;
	}
}
