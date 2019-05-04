package cwu.jsj.model;

import java.io.Serializable;
import java.util.Date;

public class Price implements Serializable{
	private int id;
	private int urgentStatus;
	private int printType;
	private Double payAmount;
	private String explain;
	
	public Price() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUrgentStatus() {
		return urgentStatus;
	}

	public void setUrgentStatus(int urgentStatus) {
		this.urgentStatus = urgentStatus;
	}

	public int getPrintType() {
		return printType;
	}

	public void setPrintType(int printType) {
		this.printType = printType;
	}

	public Double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}
	
	
}
