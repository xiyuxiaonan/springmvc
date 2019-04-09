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

//没有改变吗
@SessionAttributes("student") // 濡傛灉瑕佸湪request涓瓨鏀緎tudent瀵硅薄,鍒欏皢璇ュ璞″悓鏃舵斁鍦╯ession鍩熶腑鎴戝湪鏀瑰彉绗笁娆�
@Controller // 浠ｈ〃杩欎釜绫绘槸涓�涓帶鍒跺櫒鏀瑰彉浜�
public class springmvcController {
	@RequestMapping("welcome")
	public String welcome() {
		return "success"; // 杩欓噷浼氭嫾鎺ュ墠缂�鍜屽悗缂�,榛樿浣跨敤鐨勬槸璇锋眰杞彂
	}

	@RequestMapping("testModelAndView")
	public ModelAndView testModelAndView() { // 杩斿洖鏃㈡湁鏁版嵁鍙堟湁瑙嗗浘
		ModelAndView mv = new ModelAndView("testModelAndView");// 浠嶇劧浼氬姞鍓嶇紑鍜屽悗缂�(V)
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
		return "redirect:/views/success.jsp";// 浣跨敤閲嶅畾鍚�,闇�瑕佸啓瀹屾暣鐨勫墠缂�鍜屽悗缂�
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
	public String testUpload(@RequestParam("file") MultipartFile file) throws IOException {// 鍓嶇浼犵殑鏁版嵁娉ㄥ叆杩涘幓
		InputStream input = file.getInputStream();// 寰楀埌鏂囦欢鐨勮緭鍏ユ祦
		String filename = file.getOriginalFilename();// 寰楀埌鍘熷鏂囦欢鍚�
		OutputStream output = new FileOutputStream("d:\\" + filename);// 灏嗘枃浠朵笂浼犲埌鎸囧畾鐩綍

		byte[] bs = new byte[1024];
		int len = -1;
		while ((len = input.read(bs)) != -1) {// 浠庤緭鍏ユ祦閲岄潰璇诲彇1024涓瓧鑺傚埌缂撳啿鍖�,len=-1琛ㄧず娌℃湁涓滆タ鍙互璇诲彇
			output.write(bs, 0, len); // 灏嗙紦鍐插尯鐨勬暟鎹笉鍋滆鍒扮洰鐨勫湴
		}
		output.close();
		System.out.println("涓婁紶鎴愬姛");
		return "success";
	}

}
