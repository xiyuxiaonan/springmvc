package com.Controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Poj.Student;

@SessionAttributes("student") 
@Controller 
public class springmvcController {
	@RequestMapping("welcome")
	public String welcome() {
		return "success";
	}

	@RequestMapping("testModelAndView")
	public ModelAndView testModelAndView() {
		ModelAndView mv = new ModelAndView("testModelAndView");
		Student stu1 = new Student();
		stu1.setId(1);
		stu1.setName("zj");
		stu1.setAge("22");
		mv.addObject("student", stu1);
		return mv;
	}

	@RequestMapping("testModelMap")
	public String testModelMap(ModelMap mm) {
		Student stu1 = new Student();
		stu1.setId(1);
		stu1.setName("zj");
		stu1.setAge("22");
		mm.put("student", stu1);
		return "redirect:/views/success.jsp";
	}

	@RequestMapping("testMap")
	public String testMap(Map<String, Object> m, Student stu) {
		Student stu1 = new Student();
		stu1.setId(1);
		stu1.setName("zj");
		stu1.setAge("22");
		System.out.println();
		m.put("student", stu1);
		return "success";
	}

	@RequestMapping("testDateFormat")
	public String testDateFormat(Map<String, Object> m, Student stu) {
		Student stu1 = new Student();
		stu1.setId(1);
		stu1.setName("zj");
		stu1.setAge("22");
		System.out.println(stu.getBirthday());
		m.put("student", stu1);
		return "success";
	}

	@RequestMapping("testModel")
	public String testModel(Model m) {
		Student stu1 = new Student();
		stu1.setId(1);
		stu1.setName("zj");
		stu1.setAge("22");
		m.addAttribute("student", stu1);
		return "success";
	}

	@ResponseBody
	@RequestMapping("testJSON")
	public Student testJSON() {
		Student stu1 = new Student();
		stu1.setId(1);
		stu1.setName("zj");
		stu1.setAge("22");
		return stu1;
	}

	@RequestMapping("testUpload")
	public String testUpload(@RequestParam("file") MultipartFile file) throws IOException {
		InputStream input = file.getInputStream();
		String filename = file.getOriginalFilename();
		OutputStream output = new FileOutputStream("d:\\" + filename);// 

		byte[] bs = new byte[1024];
		int len = -1;
		while ((len = input.read(bs)) != -1) {
			output.write(bs, 0, len);
		}
		output.close();
		System.out.println("你不要");
		return "success";
	}

}
