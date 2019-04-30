package cwu.jsj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cwu.jsj.dao.UserMapper;
import cwu.jsj.model.User;
@Service
public class LoginService {
	@Resource
	private UserMapper userMapper;
	
	public User retrieveuserByPhoneNum(String userPhone,String userPwd){
		User user=new User();
		user.setUserPhone(userPhone);
		user.setUserPwd(userPwd);
		User user1=userMapper.getUserByPhonenum(user);
		return user1;
	}
	
	public User retrieveuserByusername(String userName,String userPwd){
		User user=new User();
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		User user1=userMapper.getUserByUsername(user);
		return user1;
	}
}
