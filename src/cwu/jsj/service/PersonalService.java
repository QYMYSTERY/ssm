package cwu.jsj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

import cwu.jsj.dao.UserMapper;
import cwu.jsj.model.Order;
import cwu.jsj.model.Recharge;
import cwu.jsj.model.User;
@Service
public class PersonalService {
	@Resource
	private UserMapper userMapper;
	
	public User getUserInfo(int userId){
		User user=new User();
		user.setId(userId);
		User user1 = userMapper.getUserInfo(user);
		return user1;
	}
	
	public int updateNamePhone(int userId,String userName,String userPhone){
		User user=new User();
		user.setId(userId);
		user.setUserName(userName);
		user.setUserPhone(userPhone);
		int result = userMapper.updateNamePhone(user);
		return result;
	}
	
	public int updateUserInfo(int userId,String userName,String userPhone,String userPwd){
		User user=new User();
		user.setId(userId);
		user.setUserName(userName);
		user.setUserPhone(userPhone);
		user.setUserPwd(userPwd);
		int result = userMapper.updateUserInfo(user);
		return result;
	}
	
	public User isPhoneNumExist(String userPhone){
		User user=new User();
		user.setUserPhone(userPhone);
		User user1 = userMapper.isPhoneNumExist(user);
		return user1;
		
	}
	
	public User isNameExist(String userName){
		User user=new User();
		user.setUserName(userName);
		User user1 = userMapper.isNameExist(user);
		return user1;
	}
}
