package cwu.jsj.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cwu.jsj.model.User;
import cwu.jsj.service.PersonalService;

@Controller
@RequestMapping("/personal")
public class PersonalController {
	@Resource
	private PersonalService personalService;
	@RequestMapping("/myinfo")
	public String getUserInfo(HttpSession session,HttpServletRequest request) {
		int userId = (int) session.getAttribute("userId");
		//通过用户id查询用户注册信息
		User user  = personalService.getUserInfo(userId);
		String username = user.getUserName();
		String userePwd  = user.getUserPwd();
		String userPhone  = user.getUserPhone();
		Date cTime  = user.getCreateTime();
		request.setAttribute("username", username);
		request.setAttribute("userePwd", userePwd);
		request.setAttribute("userPhone", userPhone);
		request.setAttribute("cTime", cTime);
		return "user/user_MyInfo";
	}	
	@RequestMapping("/updateUserInfo")
	public String updateUserInfo(HttpSession session,HttpServletRequest request,String userName,String userPhone,String userPwd,String userRpwd,String oldPwd){
		
		int userId = (int) session.getAttribute("userId");
		
		String Msg = "";
		
		if(!StringUtils.hasText(userPhone)){
			Msg = "手机号不能为空";
			request.setAttribute("Msg", Msg);
			return "forward:/personal/myinfo";
		}
		
		if(!StringUtils.hasText(userName)){
			Msg = "用户名不能为空";
			request.setAttribute("Msg", Msg);
			return "forward:/personal/myinfo";
		}
		
		if(!StringUtils.hasText(oldPwd)){
			Msg = "原始密码不能为空";
			request.setAttribute("Msg", Msg);
			return "forward:/personal/myinfo";
		}
		
		if(!StringUtils.hasText(userPwd) && !StringUtils.hasText(userRpwd)){
			//新密码为空时只更新手机号和用户名
			User user = personalService.getUserInfo(userId);
			String oldUserrPwd = user.getUserPwd();
			if(oldUserrPwd.equals(oldPwd)){
				User user2 = personalService.isPhoneNumExist(userPhone);
				if(user2==null){
					personalService.updateNamePhone(userId, userName, userPhone);
					return "forward:/personal/myinfo";
				}else{
					int id=user2.getId();
					if(id==userId){
						personalService.updateNamePhone(userId, userName, userPhone);
						return "forward:/personal/myinfo";
					}else{
						Msg = "该手机号已注册";
						request.setAttribute("Msg", Msg);
						return "forward:/personal/myinfo";
					}
				}
				
			}else{
				Msg = "原密码错误，请重试";
				request.setAttribute("Msg", Msg);
				return "forward:/personal/myinfo";
			}
		}else{
			//新密码不为空全部更新
			if(StringUtils.hasText(userPwd) ^ StringUtils.hasText(userRpwd)){
				Msg = "信息输入不完整，请重试";
				request.setAttribute("Msg", Msg);
				return "forward:/personal/myinfo";
			}else{
				if(userPwd.equals(userRpwd)){
					User user = personalService.getUserInfo(userId);
					String oldUserrPwd = user.getUserPwd();
					if(oldUserrPwd.equals(oldPwd)){
						User user2 = personalService.isPhoneNumExist(userPhone);
						if(user2==null){
							personalService.updateNamePhone(userId, userName, userPhone);
							return "forward:/personal/myinfo";
						}else{
							int id=user2.getId();
							if(id==userId){
								personalService.updateNamePhone(userId, userName, userPhone);
								return "forward:/personal/myinfo";
							}else{
								Msg = "该手机号已注册";
								request.setAttribute("Msg", Msg);
								return "forward:/personal/myinfo";
							}
						}
						
					}else{
						Msg = "原密码错误，请重试";
						request.setAttribute("Msg", Msg);
						return "forward:/personal/myinfo";
					}
				}else{
					Msg = "输入密码不一致";
					request.setAttribute("Msg", Msg);
					return "forward:/personal/myinfo";
				}
			}
		}
	}
	
	
}
