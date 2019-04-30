package cwu.jsj.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cwu.jsj.dao.UserMapper;
import cwu.jsj.model.User;
@Service
public class UserRegisterService {
	@Resource
	private UserMapper userMapper;
	
	public User isPhoneNumExist(String userPhone){
		User user=new User();
		user.setUserPhone(userPhone);
		User user1 = userMapper.isPhoneNumExist(user);
		return user1;
	}
	
	public int createUser(String userPhone,String userPwd,Date createTime,int role){
		User user=new User();
		user.setUserPhone(userPhone);
		user.setUserPwd(userPwd);
		user.setCreateTime(createTime);
		user.setUserRole(role);
		int user1=userMapper.createUser(user);
		return user1;
	}
}
