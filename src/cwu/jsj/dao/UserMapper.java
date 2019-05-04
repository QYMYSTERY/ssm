package cwu.jsj.dao;

import java.util.List;

import cwu.jsj.model.Files;
import cwu.jsj.model.Order;
import cwu.jsj.model.Price;
import cwu.jsj.model.Recharge;
import cwu.jsj.model.User;

public interface UserMapper {
	//查询用户名是否存在
	public User isNameExist(User user);
	//通过手机号查询用户信息
	public User getUserByPhonenum(User user);
	//通过用户名查询用户信息
	public User getUserByUsername(User user);
	//查询手机号是否存在
	public User isPhoneNumExist(User user);
	//创建新用户
	public int createUser(User user);
	//插入上传文件信息
	public int uploadeFile(Files file);
	//获取文件列表
	public List<Files> getFiles(Files file);
	//删除文件信息
	public int deleteFile(Files file);
	//获取文件存储名称
	public Files getRfilename(Files file);
	//查询不同打印类型单价
	public Price getPrintPrice(Price price);
	//查询用户余额
	public User getRemainSum(User user);
	//更新用户余额
	public int updateRemainSum(User user);
	//创建新订单
	public int createOrder(Order order);
	//查询未完成的订单
	public List<Order> getUnfinishedOrder(Order order);
	//查询已完成的订单
	public List<Order> getFinishedOrder(Order order);
	//统计每个时段提交订单数量
	public List<Integer> getTimeInterval();
	//查询uuid
	public Recharge getUuid(Recharge recharge);
	//更新充值卡状态
	public int updateCardStatus(Recharge recharge);
	//查询用户信息
	public User getUserInfo(User user);
	//更新用户信息:用户名，手机号，密码
	public int updateUserInfo(User user);
	//更新用户信息：手机号，密码
	public int updateNamePhone(User user);
}
