package cwu.jsj.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.UUID;
import org.springframework.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cwu.jsj.model.Price;
import cwu.jsj.service.AdminSettingService;

@Controller
@RequestMapping("/SettingCenter")
public class AdminSettingCenterController {
	@Resource
	private AdminSettingService adminSettingService;
	@RequestMapping("/setTypePrice")
	public String updateSetting(HttpServletRequest request,String J_BW_S,String J_BW_D,String J_CO_S,
			String J_CO_D,String P_BW_S,String P_BW_D,String P_CO_S,String P_CO_D) {
		String Msg = "";
		if(!StringUtils.hasText(P_CO_D)||!StringUtils.hasText(P_CO_S)||!StringUtils.hasText(P_BW_D)||!StringUtils.hasText(P_BW_S)||!StringUtils.hasText(J_CO_D)||!StringUtils.hasText(J_CO_S)||!StringUtils.hasText(J_BW_D)||!StringUtils.hasText(J_BW_S)){
			Msg="设置金额不能为空";
			request.setAttribute("Msg", Msg);
			return "forward:/SettingCenter/show";
		}
		
		double jbws = Double.parseDouble(J_BW_S);
		double jcos = Double.parseDouble(J_CO_S);
		double jcod = Double.parseDouble(J_CO_D);
		double pbws = Double.parseDouble(P_BW_S);
		double pbwd = Double.parseDouble(P_BW_D);
		double jbwd = Double.parseDouble(J_BW_D);
		double pcos = Double.parseDouble(P_CO_S);
		double pcod = Double.parseDouble(P_CO_D);
		
		boolean result = adminSettingService.updateTypePrice(pbws,pbwd,pcos,pcod,jbws,jbwd,jcos,jcod);
		
		if(result){
			Msg="设置成功";
			request.setAttribute("Msg", Msg);
		}
		return "forward:/SettingCenter/show";
	}
	
	@RequestMapping("/setCardPrice")
	public String setCardPrice(HttpServletRequest request,String u1,String u2,String u3,String u4,String u5,String u6,String u7,String u8,String u9,String u10,
			String p1,String p2,String p3,String p4,String p5,String p6,String p7,String p8,String p9,String p10) {
		String Msg = "";
		if(!StringUtils.hasText(p10)||!StringUtils.hasText(p9)||!StringUtils.hasText(p8)||!StringUtils.hasText(p7)||!StringUtils.hasText(p6)||!StringUtils.hasText(p5)||!StringUtils.hasText(p4)||!StringUtils.hasText(p3)||!StringUtils.hasText(p2)||!StringUtils.hasText(p1)
				||!StringUtils.hasText(u10)||!StringUtils.hasText(u9)||!StringUtils.hasText(u8)||!StringUtils.hasText(u7)||!StringUtils.hasText(u6)||!StringUtils.hasText(u5)||!StringUtils.hasText(u4)||!StringUtils.hasText(u3)||!StringUtils.hasText(u2)||!StringUtils.hasText(u1)){
			Msg="请填写完整后保存";
			request.setAttribute("Msg", Msg);
			request.setAttribute("u9", u10);
			request.setAttribute("u8", u9);
			request.setAttribute("u7", u8);
			request.setAttribute("u6", u7);
			request.setAttribute("u5", u6);
			request.setAttribute("u4", u5);
			request.setAttribute("u3", u4);
			request.setAttribute("u2", u3);
			request.setAttribute("u1", u2);
			request.setAttribute("u0", u1);
			request.setAttribute("p1", p1);
			request.setAttribute("p2", p2);
			request.setAttribute("p3", p3);
			request.setAttribute("p4", p4);
			request.setAttribute("p5", p5);
			request.setAttribute("p6", p6);
			request.setAttribute("p7", p7);
			request.setAttribute("p8", p8);
			request.setAttribute("p9", p9);
			request.setAttribute("p10", p10);
			
			return "forward:/SettingCenter/show";
		}
		
		double pr1 = Double.parseDouble(p1);
		double pr2 = Double.parseDouble(p2);
		double pr3 = Double.parseDouble(p3);
		double pr4 = Double.parseDouble(p4);
		double pr5 = Double.parseDouble(p5);
		double pr6 = Double.parseDouble(p6);
		double pr7 = Double.parseDouble(p7);
		double pr8 = Double.parseDouble(p8);
		double pr9 = Double.parseDouble(p9);
		double pr10 = Double.parseDouble(p10);
		
		boolean result = adminSettingService.updateCardPrice(pr1, pr2, pr3, pr4, pr5, pr6, pr7, pr8, pr9, pr10, u1, u2, u3, u4, u5, u6, u7, u8, u9, u10);
		
		if(result){
			Msg="保存成功";
			request.setAttribute("Msg", Msg);
		}
		
		return "forward:/SettingCenter/show";
	}
	
	@RequestMapping("/createCardCode")
	public String createCardCode(HttpServletRequest request) {
		for (int i = 0;i<10;i++){
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			String sNmae = "u"+String.valueOf(i);
			request.setAttribute(sNmae, uuid); 
		}
		return "forward:/SettingCenter/show";
	}
	
	@RequestMapping("/show")
	public String settingShow(HttpServletRequest request) {
		Price J_BW_D = adminSettingService.getJ_BW_DPrice();
		double J_BW_DPrice=J_BW_D.getPayAmount();
		request.setAttribute("J_BW_D", J_BW_DPrice);
		
		Price J_BW_S = adminSettingService.getJ_BW_SPrice();
		double J_BW_SPrice=J_BW_S.getPayAmount();
		request.setAttribute("J_BW_S", J_BW_SPrice);
		
		Price J_CO_D=adminSettingService.getJ_CO_DPrice();
		double J_CO_DPrice=J_CO_D.getPayAmount();
		request.setAttribute("J_CO_D", J_CO_DPrice);
		
		Price J_CO_S=adminSettingService.getJ_CO_SPrice();
		double J_CO_SPrice=J_CO_S.getPayAmount();
		request.setAttribute("J_CO_S", J_CO_SPrice);
		
		Price P_BW_D=adminSettingService.getP_BW_DPrice();
		double P_BW_DPrice=P_BW_D.getPayAmount();
		request.setAttribute("P_BW_D", P_BW_DPrice);
		
		Price P_CO_S=adminSettingService.getP_CO_SPrice();
		double P_CO_SPrice=P_CO_S.getPayAmount();
		request.setAttribute("P_CO_S", P_CO_SPrice);
		
		Price P_BW_S=adminSettingService.getP_BW_SPrice();
		double P_BW_SPrice=P_BW_S.getPayAmount();
		request.setAttribute("P_BW_S", P_BW_SPrice);
		
		Price P_CO_D=adminSettingService.getP_CO_DPrice();
		double P_CO_DPrice=P_CO_D.getPayAmount();
		request.setAttribute("P_CO_D", P_CO_DPrice);
		
		return "admin/admin_SettingCenter";
	}
}
