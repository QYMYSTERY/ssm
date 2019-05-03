package cwu.jsj.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cwu.jsj.model.Order;
import cwu.jsj.service.AdminManageOrderService;

@Controller
@RequestMapping("/ManageOrder")
public class AdminManageOrderController {
	@Resource
	private AdminManageOrderService adminManageOrderService;
	@RequestMapping("/OrderList")
	public String echartShow(HttpServletRequest request) {
		List<Order> order = adminManageOrderService.getAllOrder();
		request.setAttribute("listOrder", order);
		return "admin/admin_ManageOrder";
	}
	
	@RequestMapping("/PrintingOrder")
	public String generalNewOrderShow(HttpServletRequest request) {
		//订单表里查询订单状态为:2（打印中）且为非紧急状态的订单
		List<Order> order = adminManageOrderService.getPrintingOrder();
		request.setAttribute("listOrder", order);
		return "admin/admin_ManageOrder";
	}
	
	@RequestMapping("/Finished")
	public String newOrderShow(HttpServletRequest request) {
		//订单表里查询订单状态为:3（已完成）的订单
		List<Order> order = adminManageOrderService.getFinishedOrder();
		request.setAttribute("listOrder", order);
		return "admin/admin_ManageOrder";
	}
	
	@RequestMapping("/updateStatus")
	public String updateStatus(HttpServletRequest request,int orderStatus,int orderId){
		String Msg = "";
		if(orderStatus==3){
			Msg = "该订单为已完成状态";
			request.setAttribute("Msg", Msg);
			return "forward:/ManageOrder/Finished";
		}else{
			//更新状态
			orderStatus = 3;
			adminManageOrderService.updateStatus(orderId,orderStatus);
			return "forward:/ManageOrder/Finished";
		}
		
	}
}
