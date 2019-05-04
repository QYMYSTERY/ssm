package cwu.jsj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cwu.jsj.dao.AdminMapper;
import cwu.jsj.model.Order;
import cwu.jsj.model.Price;
import cwu.jsj.model.Uuid;
@Service
public class AdminSettingService {
	@Resource
	private AdminMapper adminMapper;
	
	public Price getJ_BW_DPrice(){
		Price price = adminMapper.getJ_BW_DPrice();
		return price;
	}
	
	public Price getJ_CO_SPrice(){
		Price price = adminMapper.getJ_CO_SPrice();
		return price;
	}
	
	public Price getJ_BW_SPrice(){
		Price price = adminMapper.getJ_BW_SPrice();
		return price;
	}
	
	public Price getJ_CO_DPrice(){
		Price price = adminMapper.getJ_CO_DPrice();
		return price;
	}
	
	public Price getP_BW_SPrice(){
		Price price = adminMapper.getP_BW_SPrice();
		return price;
	}
	
	public Price getP_BW_DPrice(){
		Price price = adminMapper.getP_BW_DPrice();
		return price;
	}
	
	public Price getP_CO_SPrice(){
		Price price = adminMapper.getP_CO_SPrice();
		return price;
	}
	
	public Price getP_CO_DPrice(){
		Price price = adminMapper.getP_CO_DPrice();
		return price;
	}
	
	public boolean updateTypePrice(double p1,double p2,double p3,double p4,double p5,double p6,double p7,double p8){
		Price price1  = new Price();
		price1.setPayAmount(p1);
		adminMapper.updateTypePrice1(price1);
		
		Price price2  = new Price();
		price2.setPayAmount(p2);
		adminMapper.updateTypePrice2(price2);
		
		Price price3  = new Price();
		price3.setPayAmount(p3);
		adminMapper.updateTypePrice3(price3);
		
		Price price4  = new Price();
		price4.setPayAmount(p4);
		adminMapper.updateTypePrice4(price4);
		
		Price price5  = new Price();
		price5.setPayAmount(p5);
		adminMapper.updateTypePrice5(price5);
		
		Price price6  = new Price();
		price6.setPayAmount(p6);
		adminMapper.updateTypePrice6(price6);
		
		Price price7  = new Price();
		price7.setPayAmount(p7);
		adminMapper.updateTypePrice7(price7);
		
		Price price8  = new Price();
		price8.setPayAmount(p8);
		adminMapper.updateTypePrice8(price8);
		
		return true;
	}
	
	public boolean updateCardPrice(double p1,double p2,double p3,double p4,double p5,double p6,double p7,double p8,double p9,double p10
			,String u1,String u2,String u3,String u4,String u5,String u6,String u7,String u8,String u9,String u10){
		Uuid uuid1=new Uuid();
		uuid1.setUuid(u1);
		uuid1.setMoney(p1);
		adminMapper.updateCardPrice(uuid1);
		
		Uuid uuid2=new Uuid();
		uuid2.setUuid(u2);
		uuid2.setMoney(p2);
		adminMapper.updateCardPrice(uuid2);
		
		Uuid uuid3=new Uuid();
		uuid3.setUuid(u3);
		uuid3.setMoney(p3);
		adminMapper.updateCardPrice(uuid3);
		
		Uuid uuid4=new Uuid();
		uuid4.setUuid(u4);
		uuid4.setMoney(p4);
		adminMapper.updateCardPrice(uuid4);
		
		Uuid uuid5=new Uuid();
		uuid5.setUuid(u5);
		uuid5.setMoney(p5);
		adminMapper.updateCardPrice(uuid5);
		
		Uuid uuid6=new Uuid();
		uuid6.setUuid(u6);
		uuid6.setMoney(p6);
		adminMapper.updateCardPrice(uuid6);
		
		Uuid uuid7=new Uuid();
		uuid7.setUuid(u7);
		uuid7.setMoney(p7);
		adminMapper.updateCardPrice(uuid7);
		
		Uuid uuid8=new Uuid();
		uuid8.setUuid(u8);
		uuid8.setMoney(p8);
		adminMapper.updateCardPrice(uuid8);
		
		Uuid uuid9=new Uuid();
		uuid9.setUuid(u9);
		uuid9.setMoney(p9);
		adminMapper.updateCardPrice(uuid9);
		
		Uuid uuid10=new Uuid();
		uuid10.setUuid(u10);
		uuid10.setMoney(p10);
		adminMapper.updateCardPrice(uuid10);
		
		return true;
	}
}
