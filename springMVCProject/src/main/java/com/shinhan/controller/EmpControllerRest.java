package com.shinhan.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.shinhan.model.CompanyService;
import com.shinhan.model.EmpService;
import com.shinhan.vo.EmpVO;

@RestController // @Controller + @ResponseBody
@RequestMapping("/restemp")
public class EmpControllerRest {

	Logger logger = LoggerFactory.getLogger(EmpControllerRest.class);

	@Autowired
	EmpService eService;

	@Autowired
	CompanyService cService;

	// HTML 폼과 자바빈 객체
	// Request의 parameter를 읽어서 VO를 new해서 setter수행한다.
	@RequestMapping(value = "/empinsert.do", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = "text/plain;charset=utf-8", 
			method = RequestMethod.POST)
	public String registerPost(/* @ModelAttribute("emp") */ @RequestBody EmpVO emp, String address, Model model,
			HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttr) {
		String result = eService.empInsert(emp);
		return "insert(rest) 결과는: " + result;
		// return "emp/empInsertResult";
	}

	@RequestMapping(value = "/emplist.do", produces = "application/json;charset=utf-8")
	public Map<String, Object> empList(HttpServletRequest request) {
		Map<String, Object> returnMap = new HashMap<>();

		List<EmpVO> emplist = eService.selectByCondition(new Integer[] {}, null, null, null);
		logger.info(emplist.size() + "건");

		returnMap.put("empAll", emplist);
		returnMap.put("deptList", cService.deptSelectAll());
		returnMap.put("jobList", cService.jobSelectAll());
		returnMap.put("managerList", cService.managerSelectAll());

		return returnMap;
	}

//	@RequestMapping(value= "/emplist.do", produces = "application/json;charset=utf-8")
//	public ModelAndView emplist(HttpServletRequest request) {
//
//		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
//		if (flashMap != null) {
//			Object message = flashMap.get("resultMessage");
//			logger.info("입력/삭제/수정에 대한 결과 message=>" + message);
//		}
//
//		List<EmpVO> emplist = eService.selectByCondition(new Integer [] {},null, null, null);
//		logger.info(emplist.size() + "건");
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("empAll", emplist);
//		mv.addObject("deptList", cService.deptSelectAll());
//		mv.addObject("jobList", cService.jobSelectAll());
//		mv.setViewName("emp/empSelect");
//		return mv;
//	}

	// 필터링
	// @RequestMapping(value = "/empCondition.do", method=RequestMethod.GET)
	// Ajax 요청 시 배열이 오면 @RequestParam("deptid[]")
	// 일반요청이면 @RequestParam("deptid") Integer [] deptid
	// 일반요청이면 Integer [] deptid
	//
	@PostMapping("/empCondition.do")
	public String selectByCondition(@RequestParam("deptid[]") Integer[] deptid, String jobid, Double salary,
			Date hireDate, Model model) {
		List<EmpVO> emplist = eService.selectByCondition(deptid, jobid, salary, hireDate);
		model.addAttribute("empAll", emplist);
		return "emp/empRetrieve";
	}

	@RequestMapping(value = "/empinsert.do", method = RequestMethod.GET)
	public String registerGet(HttpServletRequest request, Model model) {

		model.addAttribute("deptList", cService.deptSelectAll());
		model.addAttribute("jobList", cService.jobSelectAll());
		model.addAttribute("managerList", cService.managerSelectAll());

		// page만 보여줌.
		return "emp/empInsert";
	}

	// Jackson이 JSON으로 변경하여 return 해준다. -->MediaType.APPLICATION_JSON_VALUE
	// Rest방식: "/empDetail.do/{empid}"
	@RequestMapping(value = "/empDetail.do/{empid}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public EmpVO empDetailGeT(@PathVariable int empid /* , Model model */) {
		EmpVO emp = eService.selectById(empid);
//		model.addAttribute("deptList", cService.deptSelectAll());
//		model.addAttribute("jobList", cService.jobSelectAll());
//		model.addAttribute("managerList", cService.managerSelectAll());
//		model.addAttribute("emp", emp);

		return emp;
	}

	// PUT: 수정(update)
	// @RequestBody: 요청문서의 body에 data가 들어온다.
	@RequestMapping(value = "/empDetail.do", consumes = "application/json", produces = "text/plain;charset=utf-8", method = RequestMethod.PUT)
	public String empDetailPut(@RequestBody EmpVO emp, RedirectAttributes redirectAttr) {

		String result = eService.empUpdate(emp);

		// redirect할 때, result의 값도 같이 넘겨준다. 원래는 session에다가 했었음. redirect는 페이지 리로딩이었으니깐.
		redirectAttr.addFlashAttribute("resultMessage", result);
		return "결과는 " + result;
	}

	@DeleteMapping(value = "/empDelete.do/{empid}", produces = "text/plain;charset=utf-8")
	public String empDelete(@PathVariable int empid) {
		logger.info(empid + "");
		String result = eService.empDelete(empid);

		// redirect할 때, result의 값도 같이 넘겨준다. 원래는 session에다가 했었음. redirect는 페이지 리로딩이었으니깐.
		// redirectAttr.addFlashAttribute("resultMessage", result);
		return "delete 결과는:  " + result;
	}

	// ======================================================================================================================

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
		return "redirect:/emp/empinsert.do";
	}

//	@RequestMapping(value = "emp/empinsert.do", method = RequestMethod.POST)
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
//	@RequestMapping(value = "/empinsert.do", method = RequestMethod.POST)
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

}
