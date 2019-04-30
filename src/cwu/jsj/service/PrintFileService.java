package cwu.jsj.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cwu.jsj.dao.UserMapper;
import cwu.jsj.model.Files;
import cwu.jsj.model.Price;
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
}
