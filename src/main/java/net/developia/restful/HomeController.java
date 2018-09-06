package net.developia.restful;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.developia.restful.user.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   /**
    * Simply selects the home view to render by returning its name.
    */
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String home(Locale locale, Model model, HttpSession session) {
      UserVO userInfo = new UserVO();
      userInfo.setUser_no(1);            // 값을 넣어줘서 로그인된 상태로 실행
      userInfo.setUser_name("신해철");
      userInfo.setUser_id("next");
      userInfo.setUser_level(1);
      userInfo.setUser_status(0);
      
      session.setAttribute("userInfo", userInfo);
      
      return "redirect:board/160/1/";
      
      //return "redirect:user/";   // 맨처음 시작할때 restful/user/로 이동
   }
   
}