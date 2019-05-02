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
public class MyWalletService {
	@Resource
	private UserMapper userMapper;
	
	public User getUserBalance(int userId){
		User user=new User();
		user.setId(userId);
		User user1 = userMapper.getRemainSum(user);
		return user1;
	}
	
	public Recharge getUuid(String uuid){
		Recharge recharge = new Recharge();
		recharge.setUuid(uuid);
		Recharge recharge1 = userMapper.getUuid(recharge);
		return recharge1;
	}
	
	public int updateBalance(int userId,double balance){
		User user=new User();
		user.setId(userId);
		user.setRemainSum(balance);
		int user1 = userMapper.updateRemainSum(user);
		return user1;
	}
	
	public int updateCardStatus(String uuid){
		Recharge recharge = new Recharge();
		recharge.setUuid(uuid);
		int recharge1 = userMapper.updateCardStatus(recharge);
		return recharge1;
	}
	
}
