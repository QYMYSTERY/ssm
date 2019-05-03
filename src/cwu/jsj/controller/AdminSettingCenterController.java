package cwu.jsj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/SettingCenter")
public class AdminSettingCenterController {
	
	@RequestMapping("/setting")
	public String echartShow(HttpServletRequest request) {
		return "admin/admin_SettingCenter";
	}	
}
