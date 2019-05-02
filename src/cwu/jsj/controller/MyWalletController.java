package cwu.jsj.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cwu.jsj.model.Recharge;
import cwu.jsj.model.User;
import cwu.jsj.service.MyWalletService;

@Controller
@RequestMapping("/myWallet")
public class MyWalletController {
	@Resource
	private MyWalletService myWalletService;
	@RequestMapping("/balance")
	public String balanceShow(HttpSession session,HttpServletRequest request) {
		//查询该用户余额
		int userId = (int) session.getAttribute("userId");
		User user = myWalletService.getUserBalance(userId);
		double balance = user.getRemainSum();
		request.setAttribute("balance", balance);
		return "user/user_MyWallet";
	}
	
	@RequestMapping("/recharge")
	public String rechargeBalance(HttpSession session,HttpServletRequest request,String uuid) {
		
		if(uuid == null || uuid.trim().length() == 0){
			String uuidNull ="请输入充值卡序列号！";
			request.setAttribute("uuidNull", uuidNull);
			return "forward:/myWallet/balance";
		}
		
		Recharge recharge = myWalletService.getUuid(uuid);
		if(recharge!=null){
			//查询充值卡状态
			int cardStatus = recharge.getStatus();
			if(cardStatus==0){
				String cardInvalid ="无效的序列号！";
				request.setAttribute("cardInvalid", cardInvalid);
				return "forward:/myWallet/balance";
			}else{
				double rechargeAmount = recharge.getRechargeAmount();
				//查询该用户余额
				int userId = (int) session.getAttribute("userId");
				User user = myWalletService.getUserBalance(userId);
				double balance = user.getRemainSum();
				
				double newBalance = rechargeAmount+balance;
				
				//充值成功更新用户余额
				myWalletService.updateBalance(userId,newBalance);
				//更改充值卡状态
				myWalletService.updateCardStatus(uuid);
				
				return "forward:/myWallet/balance";
			}
		}else{
			String uuidNotExist ="序列号不存在！";
			request.setAttribute("uuidNotExist", uuidNotExist);
			return "forward:/myWallet/balance";
		}
	}
}
