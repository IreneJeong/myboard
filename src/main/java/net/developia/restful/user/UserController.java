package net.developia.restful.user;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("user")  //주소에 공통적으로 들어갈 부분 http://localhost/restful/user
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService; //컨트롤러에 서비스 주입되도록 
	
	@GetMapping("/")  // http://localhost/restful/user
	public String login() {
		return "user/login"; 
	}
	
	@PostMapping("/")
	public String login (
			//@RequestParam String user_id, @RequestParam String user_pw) {
			//param을 한 세트로 넘겨줄 때 modelAttribute붙여준다. 
			//개별로 parameter를 하나씩 선언해서 받는 게 아니라 한번에 UserVO클래스에 선언된 것들을 불러올 수 있다. 
			@ModelAttribute UserVO userVO, Model model, HttpSession session) {  
		
		//logger.info("id : " + user_id);
		logger.info(userVO.toString());
		try {
			UserVO userInfo = userService.getUser(userVO);
			logger.info(userInfo.toString());
			session.setAttribute("userInfo", userInfo);
			return "redirect:../board/";  //리스트로 이동하기 
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("msg",e.getMessage());
			model.addAttribute("url", "./");
			return "result";
		}
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		UserVO userInfo = (UserVO) session.getAttribute("userInfo");
		session.invalidate(); // 모든 세션 죽이는 것 
		
		ModelAndView mav= new ModelAndView("result");
		mav.addObject("msg", userInfo.getUser_name()+"("+userInfo.getUser_id()+") 님이 로그아웃 하였습니다.");
		mav.addObject("url", "./");
		return mav; 
	}
}
