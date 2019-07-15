package cn.nmb.draw;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

	@RequestMapping("/Draw.do")
	public String Draw(Model model) {
		//model.addAttribute("user","ssr");
		return "index.jsp";
	}
}
