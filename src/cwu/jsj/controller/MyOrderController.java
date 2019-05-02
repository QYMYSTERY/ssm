package cwu.jsj.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cwu.jsj.model.Order;
import cwu.jsj.service.MyOrderService;

@Controller
@RequestMapping("/myOrder")
public class MyOrderController {
	@Resource
	private MyOrderService myOrderService;
	@RequestMapping("/unfinished")
	public String listUnfinishedOrder(HttpSession session,HttpServletRequest request) {
		int userId = (int) session.getAttribute("userId");
		
		List<Order> order = myOrderService.listUnfinishedOrder(userId);
		
		request.setAttribute("orderList", order);
		return "user/user_MyOrder";
	}	
	
	@RequestMapping("/finished")
	public String listFinishedOrder(HttpSession session,HttpServletRequest request) {
		int userId = (int) session.getAttribute("userId");
		
		List<Order> order = myOrderService.listFinishedOrder(userId);
		
		request.setAttribute("orderList", order);
		return "user/user_MyOrder";
	}
}
