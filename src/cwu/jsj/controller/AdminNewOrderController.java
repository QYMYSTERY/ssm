package cwu.jsj.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cwu.jsj.model.Order;
import cwu.jsj.service.AdminNewOrderService;

@Controller
@RequestMapping("/newOrder")
public class AdminNewOrderController {
	@Resource
	private AdminNewOrderService adminNewOrderService;
	
	@RequestMapping("/urgencyNewOrder")
	public String urgencyNewOrderShow(HttpServletRequest request) {
		//订单表里查询订单状态为:1（已提交）且为紧急状态的订单
		List<Order> order = adminNewOrderService.getUrgencyNewOrder();
		request.setAttribute("listOrder", order);
		return "admin/admin_Index";
	}
	
	@RequestMapping("/generalNewOrder")
	public String generalNewOrderShow(HttpServletRequest request) {
		//订单表里查询订单状态为:1（已提交）且为非紧急状态的订单
		List<Order> order = adminNewOrderService.getGeneralNewOrder();
		request.setAttribute("listOrder", order);
		return "admin/admin_Index";
	}
	
	@RequestMapping("/allNewOrder")
	public String newOrderShow(HttpServletRequest request) {
		//订单表里查询订单状态为:1（已提交）的订单
		List<Order> order = adminNewOrderService.getNewOrder();
		request.setAttribute("listOrder", order);
		return "admin/admin_Index";
	}
}
