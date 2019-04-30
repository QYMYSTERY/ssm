package cwu.jsj.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exit")
public class ExitController {
	@RequestMapping("/toLogin")
	public String exitSystem(HttpSession session){
		session.invalidate();
		return "../login/ssm_Login";
	}
}
