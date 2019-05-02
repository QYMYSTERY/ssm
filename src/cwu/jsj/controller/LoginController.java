package cwu.jsj.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cwu.jsj.model.User;
import cwu.jsj.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Resource
	private LoginService LoginService;
	
	@RequestMapping("/userRegister")
	public String toRegister(){
		return "user/user_Register";
	}
	@RequestMapping("/ssm_Login")
	public String ssmLogin(HttpSession session,
			HttpServletRequest request, String accountnumber, String password,HttpServletResponse re){
//		re.getOutputStream()
		
		Map<String, String> errorMap = new HashMap<String, String>();
		request.setAttribute("errorMap", errorMap);
		
		if (accountnumber == null || accountnumber.trim().length() == 0) {
			errorMap.put("accounterror", "帐号|手机号不能为空");
			return "../login/ssm_Login";
		}else{
			if (password == null || password.trim().length() == 0) {
				errorMap.put("passworderror", "密码不能为空");
				return "../login/ssm_Login";
			}
		}
		// 判定是否手机号
		/*
		 * if 是手机号
		 * 	retrieveuserByPhoneNum
		 * else if 
		 * 	retrieveuserByusername
		 */
		User user;
		if(accountnumber.length()==11){
			user = LoginService.retrieveuserByPhoneNum(accountnumber, password);
		}else{
			user = LoginService.retrieveuserByusername(accountnumber, password);
		}
		// 判定是否是管理员
		/*
		 * if 管理员
		 * 	return "/admin/admin_Index";
		 * else if user
		 * 	return "/user/user_Index";
		 * eles
		 * 	"帐号不存在或密码错误！"
		 */
		if(user != null){
			int role = user.getUserRole();
			if(role != 2){
				String username=user.getUserName();
				int userid=user.getId();
				session.setAttribute("username", username);
				session.setAttribute("userId", userid);
				return "forward:/newOrder/urgencyNewOrder";
			}
			else{
				String username=user.getUserName();
				int userid=user.getId();
				session.setAttribute("username", username);
				session.setAttribute("userId", userid);
				return "forward:/index/statistialChart";
			}
		}else{
			errorMap.put("error", "帐号不存在或密码错误！");
			return "../login/ssm_Login";
		}
	}
}
