package com.kh.member.model.vo;

import java.sql.Date;

public class Member {
		
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String phone;
	private String email;
	private String address;
	private String interest;
	private Date enrollDate;
	private Date modifyDate;
	private String status;
	
	public Member(){}
	
	// 전체 필드를 매개변수로 가지는 생성자
	
	public Member(String userId){
		this.userId = userId;
	}
	
	
	public Member(int userNo, String userId, String userPwd, String userName, String phone, String email,
			String address, String interest, Date enrollDate, Date modifyDate, String status) {
	
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.interest = interest;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}
	
	public Member(String userId, String userName, String phone, String email, String address, String interest) {
		this.userId = userId;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.interest = interest;
	}

	// 회원 가입 시 사용되는 생성자(7개 필드를 매개변수로 가지는 생성자)
	public Member(String userId, String userPwd, String userName, String phone, String email, String address,
			String interest) {
	
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.interest = interest;
	}

	public Member(int userNo, String userName, String userId, String address) {
			this.userNo = userNo;
			this.userName = userName;
			this.userId = userId;
			this.address = address;
		
	}

	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member [user_No=" + userNo + ", user_Id=" + userId + ", user_Pwd=" + userPwd + ", user_Name="
				+ userName + ", phone=" + phone + ", email=" + email + ", address=" + address + ", interest="
				+ interest + ", enroll_Date=" + enrollDate + ", modify_Date=" + modifyDate + ", status=" + status
				+ "]";
	}
	
	
	
	
	
	
	
}
