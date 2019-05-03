package cwu.jsj.dao;

import java.util.List;

import cwu.jsj.model.Order;

public interface AdminMapper {
	
	public List<Order> getUrgencyNewOrder();
	
	public List<Order> getGeneralNewOrder();
	
	public List<Order> getNewOrder();
	
	public List<Order> getPrintingOrder();
	
	public List<Order> getFinishedOrder();
	
	public List<Order> getAllOrder();
	
	public int updateOrderStatus(Order order);
	
}
