package cwu.jsj.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cwu.jsj.dao.AdminMapper;
import cwu.jsj.model.Order;
import cwu.jsj.model.User;
@Service
public class AdminAuthService {
	@Resource
	private AdminMapper adminMapper;
	
	public List<User> getUser1(){
		List<User> userList = adminMapper.getUser1();
		return userList;
	}
	
	public int deleteAdmin(int userId){
		User user = new User();
		user.setId(userId);
		int result = adminMapper.deleteAdmin(user);
		return result;
	}
	
	public int addAdmin(String userName,String userPhone,String userPwd,int userRole,Date createTime){
		User user = new User();
		user.setUserPhone(userPhone);
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		user.setCreateTime(createTime);
		user.setUserRole(userRole);
		int result = adminMapper.addAdmin(user);
		return result;
	}
}
