package cwu.jsj.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cwu.jsj.dao.UserMapper;
import cwu.jsj.model.Files;
import cwu.jsj.model.Order;
import cwu.jsj.model.Price;
import cwu.jsj.model.User;
@Service
public class PrintFileService {
	@Resource
	private UserMapper userMapper;
	
	public int uploadFile(int userId,String fileName,String rfileName,Date uploadTime){
		Files file = new Files();
		file.setUserId(userId);
		file.setFileName(fileName);
		file.setRfileName(rfileName);
		file.setUploadTime(uploadTime);
		int file1 = userMapper.uploadeFile(file);
		return file1;
	}
	
	public List<Files> getFiles(int userId){
		Files file = new Files();
		file.setUserId(userId);
		List<Files> list = userMapper.getFiles(file);
		return list;
	}
	
	public int deleteFile(int fileId){
		Files file = new Files();
		file.setId(fileId);
		int deleteResult=userMapper.deleteFile(file);
		return deleteResult;
	}
	
	public Files getRfilename(int id){
		Files file = new Files();
		file.setId(id);
		Files files = userMapper.getRfilename(file);
		return files;
	}
	
	public Price getPrintPrice(int urgentStatus,int printType){
		Price price=new Price();
		price.setPrintType(printType);
		price.setUrgentStatus(urgentStatus);
		Price price1 = userMapper.getPrintPrice(price);
		return price1;
	}
	
	public User getRemainSum(int userId){
		User user = new User();
		user.setId(userId);
		User user1 = userMapper.getRemainSum(user);
		return user1;
	}
	
	public int updateRemainSum(int userId,double remainSum){
		User user = new User();
		user.setId(userId);
		user.setRemainSum(remainSum);
		int user1 = userMapper.updateRemainSum(user);
		return user1;
	}
	
	public int createOrder(int userId,Date createTime,String fileName,int urgentStatus,int printType,int printCopies,String printRemark,int timeInterval,int fileId,double payAmount){
		Order order = new Order();
		order.setUserId(userId);
		order.setCreateTime(createTime);
		order.setFileName(fileName);
		order.setUrgentStatus(urgentStatus);
		order.setPrintType(printType);
		order.setPrintCopies(printCopies);
		order.setPrintRemark(printRemark);
		order.setTimeInterval(timeInterval);
		order.setFileId(fileId);
		order.setPayAmount(payAmount);
		int order1 = userMapper.createOrder(order);
		return order1;
	}
}
