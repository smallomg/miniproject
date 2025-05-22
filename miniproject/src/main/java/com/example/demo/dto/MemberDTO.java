package com.example.demo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private Date birth;
}
