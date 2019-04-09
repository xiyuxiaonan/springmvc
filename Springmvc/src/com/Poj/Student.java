package com.Poj;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Student {
	private int id;
	private String name;
	private String age;
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 将前台传上的字符串定为yyyy-MM-dd格式,传过来时需要此格式
	private Date birthday;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
