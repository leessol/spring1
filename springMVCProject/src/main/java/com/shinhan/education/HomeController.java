package com.shinhan.education;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		//Model: data를 저장하기 위한 객체, request.setAttribute()
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("myname", "이솔");
		model.addAttribute("myage",20);
		model.addAttribute("mycar",new Car("BMW",7000));
		//ViewResolver => 접두사 +  home + 접미사 --> servlet-context.xml에서 접두사와 접미사는 이미 다 설정해 주었다. 
		// view 가 결정된다. WEB-INF/views/home.jsp
		// view 에서 model을 이용해서 코드 
		return "home";
	}
	
}
