package cwu.jsj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myWallet")
public class MyWalletController {
	
	@RequestMapping("/balance")
	public String echartShow(HttpServletRequest request) {
		return "user/user_MyWallet";
	}	
}
