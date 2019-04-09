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

//接口/类      注解      配置
@SessionAttributes("student") // 如果要在request中存放student对象,则将该对象同时放在session域中我在改变
@Controller // 代表这个类是一个控制器改变了
public class springmvcController {
	@RequestMapping("welcome")
	public String welcome() {
		return "success"; // 这里会拼接前缀和后缀,默认使用的是请求转发
	}

	@RequestMapping("testModelAndView")
	public ModelAndView testModelAndView() { // 返回既有数据又有视图
		ModelAndView mv = new ModelAndView("testModelAndView");// 仍然会加前缀和后缀(V)
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
		return "redirect:/views/success.jsp";// 使用重定向,需要写完整的前缀和后缀
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
	public String testUpload(@RequestParam("file") MultipartFile file) throws IOException {// 前端传的数据注入进去
		InputStream input = file.getInputStream();// 得到文件的输入流
		String filename = file.getOriginalFilename();// 得到原始文件名
		OutputStream output = new FileOutputStream("d:\\" + filename);// 将文件上传到指定目录

		byte[] bs = new byte[1024];
		int len = -1;
		while ((len = input.read(bs)) != -1) {// 从输入流里面读取1024个字节到缓冲区,len=-1表示没有东西可以读取
			output.write(bs, 0, len); // 将缓冲区的数据不停读到目的地
		}
		output.close();
		System.out.println("上传成功");
		return "success";
	}

}
