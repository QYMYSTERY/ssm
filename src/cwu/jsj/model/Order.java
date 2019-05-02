package cwu.jsj.model;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
	private int id;
	private int userId;
	private int orderStatus;
	private String fileName;
	private int urgentStatus;
	private Date createTime;
	private int printType;
	private int printCopies;
	private String printRemark;
	private int timeInterval;
	private int fileId;
	private double payAmount;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getUrgentStatus() {
		return urgentStatus;
	}

	public void setUrgentStatus(int urgentStatus) {
		this.urgentStatus = urgentStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getPrintType() {
		return printType;
	}

	public void setPrintType(int printType) {
		this.printType = printType;
	}

	public int getPrintCopies() {
		return printCopies;
	}

	public void setPrintCopies(int printCopies) {
		this.printCopies = printCopies;
	}

	public String getPrintRemark() {
		return printRemark;
	}

	public void setPrintRemark(String printRemark) {
		this.printRemark = printRemark;
	}

	public int getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(int timeInterval) {
		this.timeInterval = timeInterval;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}
	
}
