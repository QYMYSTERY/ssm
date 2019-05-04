package cwu.jsj.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import cwu.jsj.model.User;
import cwu.jsj.service.AdminAuthService;
import cwu.jsj.service.PersonalService;

@Controller
@RequestMapping("/AuthorityManage")
public class AdminAuthorityManageController {
	@Resource
	private AdminAuthService adminAuthService;
	@Resource
	private PersonalService personalService;
	@RequestMapping("/adminList")
	public String adminList(HttpServletRequest request) {
		//查询角色为1的用户
		List<User> userList = adminAuthService.getUser1();
		request.setAttribute("userList", userList);
		return "admin/admin_AuthorityManage";
	}
	
	@RequestMapping("/deleteAdmin")
	public String deleteAdmin(HttpServletRequest request,int userId) {
		//删除用户 
		adminAuthService.deleteAdmin(userId);
		String Msg = "删除成功";
		request.setAttribute("Msg", Msg);
		return "forward:/AuthorityManage/adminList";
	}
	
	@RequestMapping("/addAdmin")
	public String addAdmin(HttpServletRequest request,String userName,String userPhone,String userPwd) throws ParseException {
		//添加管理员
		String Msg = "";
		if(!StringUtils.hasText(userName)||!StringUtils.hasText(userPhone)||!StringUtils.hasText(userPwd)){
			Msg = "请完填写完整信息";
			request.setAttribute("Msg", Msg);
			return "forward:/AuthorityManage/adminList";
		}
		//查询手机号是否已注册
		User user1=personalService.isPhoneNumExist(userPhone);
		if(user1==null){
			//判断用户名是否重复
			User user2=personalService.isNameExist(userName);
			if(user2!=null){
				Msg = "该用户名已使用";
				request.setAttribute("Msg", Msg);
				return "forward:/AuthorityManage/adminList";
			}
			int userRole = 1;
			Date date = new Date();
			SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
			String createTimeStr=dateFormat.format(date);
			Date createTime = dateFormat.parse(createTimeStr);
			
			adminAuthService.addAdmin(userName, userPhone, userPwd, userRole, createTime);
			Msg = "添加成功";
			request.setAttribute("Msg", Msg);
			return "forward:/AuthorityManage/adminList";
		}else{
			Msg = "该手机号已使用";
			request.setAttribute("Msg", Msg);
			return "forward:/AuthorityManage/adminList";
		}
	}
}
