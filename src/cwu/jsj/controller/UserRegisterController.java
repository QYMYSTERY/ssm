package cwu.jsj.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cwu.jsj.model.User;
import cwu.jsj.service.UserRegisterService;


@Controller
public class UserRegisterController {
	@Resource
	UserRegisterService userRegisterService;
	@RequestMapping("/user/user_Register_setPwd")
	public String userRegister(HttpSession session,HttpServletRequest request,
			String phonenumber,String checknumber,String codeNum){
		
		Map<String, String> errorMap = new HashMap<String, String>();
		request.setAttribute("errorMap", errorMap);
		
		if (phonenumber == null || phonenumber.trim().length() == 0) {
			errorMap.put("PhoneNumNull", "手机号为空");
			return "/user/user_Register";
		}else{
			if (checknumber == null || checknumber.trim().length() == 0) {
				errorMap.put("CodeNull", "验证码为空");
				return "/user/user_Register";
			}else{
				if(!checknumber.equals(codeNum)){
					errorMap.put("codeError", "验证码错误");
					return "/user/user_Register";
				}else{
					session.setAttribute("phoneNum", phonenumber);
					return "/user/user_Register_setPwd";
				}
			}
		}
	}
	
	@RequestMapping("/user/user_RegisterEnd")
	public String userRegisterSetPwd(HttpSession session,
			HttpServletRequest request, String pwd, String rPwd,HttpServletResponse re){
		
		Map<String, String> errorMap = new HashMap<String, String>();
		request.setAttribute("errorMap", errorMap);
		
		if(pwd == null || pwd.trim().length() == 0){
			errorMap.put("PwdNull", "请输入密码");
			return "/user/user_Register_setPwd";
		}else{
			if(rPwd == null || rPwd.trim().length() == 0){
				errorMap.put("RpwdNull", "请输入确认密码");
				return "/user/user_Register_setPwd";
			}else {
				if(!pwd.equals(rPwd)){
					errorMap.put("Nosame", "密码不一致");
					return "/user/user_Register_setPwd";
				}else{
					String phoneNum=session.getAttribute("phoneNum").toString();
					User user1 = userRegisterService.isPhoneNumExist(phoneNum);
					if(user1!=null){
						errorMap.put("samePhone", "该手机号已注册！");
						return "/user/user_Register";
					}else{
						Date date = new Date();
						SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
						String createTimeStr=dateFormat.format(date);
						try {
							Date createTime = dateFormat.parse(createTimeStr);
							//String userId=Long.toString(createTime.getTime());
							Integer role = 2;
							int user = userRegisterService.createUser(phoneNum, pwd, createTime, role);
							if(user==0){
								errorMap.put("registerError", "注册失败！");
								return "/user/user_Register";
							}
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						return "../login/ssm_Login";
					}
				}
			}
		}
	}
}