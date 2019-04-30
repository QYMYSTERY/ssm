package cwu.jsj.dao;

import java.util.List;

import cwu.jsj.model.Files;
import cwu.jsj.model.Price;
import cwu.jsj.model.User;

public interface UserMapper {
	public User getUserByPhonenum(User user);
	public User getUserByUsername(User user);
	public User isPhoneNumExist(User user);
	public int createUser(User user);
	public int uploadeFile(Files file);
	public List<Files> getFiles(Files file);
	public int deleteFile(Files file);
	public Files getRfilename(Files file);
	public Price getPrintPrice(Price price);
}
