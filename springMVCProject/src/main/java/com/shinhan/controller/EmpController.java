package com.shinhan.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.shinhan.model.EmpService;
import com.shinhan.vo.EmpVO;

@Controller
@RequestMapping("/emp")
public class EmpController {

	Logger logger = LoggerFactory.getLogger(EmpController.class);

	@Autowired 
	EmpService eService;
	
	@RequestMapping("/list")
	public  ModelAndView emplist() {
		
		List<EmpVO> emplist = eService.selectAll();
		logger.info(emplist.size() + "건");
		ModelAndView mv = new ModelAndView();
		mv.addObject("empAll", emplist);
		mv.setViewName("emp/empSelect");
		return mv;
	}
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String registerGet(HttpServletRequest request) {
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if (flashMap != null) {
			Object message = flashMap.get("resultMessage");
			logger.info("message=>" + message);
		}
		return "emp/empInsert";
	}

	// 함수의 return 타입
	// 1) String : page이름을 return + 재요청(redirect)
	// 2) ModelAndView : Model + view
	@RequestMapping("/one")
	public ModelAndView test1(@RequestParam(name = "my", required = false) String myname) {
		ModelAndView mv = new ModelAndView("sample/sampleView1");
		mv.addObject("subject", "modelandview return 연습..." + myname);
		// mv.setViewName("sample/sampleView1");
		return mv;
	}

	@RequestMapping("/two")
	public String test2(RedirectAttributes redirectAttr) {
		logger.info("재요청 (redirect)연습");
		// redirect할때도 값을 전달할 수 있따. 원래는 못했음 새로 고침 개념이라.
		redirectAttr.addFlashAttribute("resultMessage", "재요청합니다. insert 하세요");
		return "redirect:/emp/insert.do";
	}

//	@RequestMapping(value = "emp/insert.do", method = RequestMethod.POST)
//	public String registerPost(int employee_id, String first_name, String last_name, String email, String phone_number,
//			int salary, int department_id, int manager_id, String commission_pct, Date hire_date, String job_id) {
//
//		logger.info("employee_id: " + employee_id);
//		logger.info("first_name: " + first_name);
//		logger.info("last_name: " + last_name);
//		logger.info("email: " + email);
//		logger.info("phone_number: " + phone_number);
//		logger.info("salary: " + salary);
//		logger.info("department_id: " + department_id);
//		logger.info("manager_id: " + manager_id);
//		logger.info("commission_pct: " + commission_pct);
//		logger.info("hire_date: " + hire_date);
//		logger.info("job_id: " + job_id);
//
//		logger.info("");
//		return "emp/empInsert";
//	}

	// Map 이용
	// Request의 parameter를 읽어서 VO를 new해서 setter수행한다.
//	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
//	public String registerPost(@RequestParam Map<String, String> map) {
//
//		
//		
//		for(String key: map.keySet()) {
//			logger.info(key);
//			logger.info(map.get(key).toString());
//		}
//		
//		System.out.println(map);	
//		
//		return "emp/empInsert.do";
//	}

	// HTML 폼과 자바빈 객체
	// Request의 parameter를 읽어서 VO를 new해서 setter수행한다.
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String registerPost(@ModelAttribute("emp") EmpVO emp, String address, Model model,
			HttpServletRequest request, HttpSession session) {
		// @ModelAttribute : view에게 data 전달
		logger.info("emp : " + emp);
		logger.info("address : " + address);

		String address2 = request.getParameter("address");
		String contextPath = request.getContextPath();
		String method = request.getMethod();
		String remoteAddr = request.getRemoteAddr(); // 어떤 서버가 나한테 왔는지

		session.setAttribute("userInfo", "세션에 사용자 정보 저장");

		logger.info("contextPath: " + contextPath);
		logger.info("method: " + method);
		logger.info("remoteAddr: " + remoteAddr);
		logger.info("address2: " + address2);

		model.addAttribute("emp2", emp);
		model.addAttribute("address", address);
		return "emp/empInsertResult";
	}

}
