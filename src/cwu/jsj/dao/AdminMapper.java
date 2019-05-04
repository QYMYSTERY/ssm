package cwu.jsj.dao;

import java.util.List;

import cwu.jsj.model.Order;
import cwu.jsj.model.Price;
import cwu.jsj.model.User;
import cwu.jsj.model.Uuid;

public interface AdminMapper {
	
	public int addAdmin(User user);
	
	public int deleteAdmin(User user);
	
	public List<User> getUser1();
	
	public List<Order> getUrgencyNewOrder();
	
	public List<Order> getGeneralNewOrder();
	
	public List<Order> getNewOrder();
	
	public List<Order> getPrintingOrder();
	
	public List<Order> getFinishedOrder();
	
	public List<Order> getAllOrder();
	
	public int updateOrderStatus(Order order);
	
	public Price getJ_BW_DPrice();
	
	public Price getJ_CO_SPrice();
	
	public Price getJ_BW_SPrice();
	
	public Price getJ_CO_DPrice();
	
	public Price getP_BW_SPrice();
	
	public Price getP_BW_DPrice();
	
	public Price getP_CO_SPrice();
	
	public Price getP_CO_DPrice();
	
	public int updateTypePrice1(Price price);
	
	public int updateTypePrice2(Price price);
	
	public int updateTypePrice3(Price price);
	
	public int updateTypePrice4(Price price);
	
	public int updateTypePrice5(Price price);
	
	public int updateTypePrice6(Price price);
	
	public int updateTypePrice7(Price price);
	
	public int updateTypePrice8(Price price);
	
	public int updateCardPrice(Uuid uuid);
	
	
}
