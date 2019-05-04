package cwu.jsj.model;

import java.io.Serializable;
import java.util.Date;

public class Uuid implements Serializable{
	private int id;
	private Double money;
	private String uuid;
	
	public Uuid() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
}
