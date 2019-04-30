package cwu.jsj.controller;

import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/myOrder")
public class MyOrderController {
	
	@RequestMapping("/unfinished")
	public String echartShow(HttpServletRequest request) {
		return "user/user_MyOrder";
	}	
}
