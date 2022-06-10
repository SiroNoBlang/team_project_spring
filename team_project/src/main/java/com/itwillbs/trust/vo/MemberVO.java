package com.itwillbs.trust.vo;

public class MemberVO {
	private String grade_name;
	private int lowest_acc_money;
	private int highest_acc_money;
	private int discount_rate;
	private String reason_num;
	private String reason_content;
	private String num;
	private String code;
	private String nickname;
	private String id;
	private String passwd;
	private String email;
	private String name;
	private String gender;
	private String phone;
	private String age;
	private String post_code;
	private String address;
	private String address_detail;
	private String ship_post_code;
	private String ship_address;
	private String ship_address_detail;
	private String img_name;
	private String real_img_name;
	private String style;
	private String brand;
	private String category;
	private int point;
	private int acc_money;
	private String status;
	private String join_date;
	private String passwd_change_date;
	private String login_date;
	private int order_count;
	
	// 멤버 등급 및 상태에 따른 인원 수 저장
	private int top_level;
	private int nomal;
	private int suspension;
	private int withdrawal;
	
	public String getGrade_name() {
		return grade_name;
	}
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}
	public int getLowest_acc_money() {
		return lowest_acc_money;
	}
	public void setLowest_acc_money(int lowest_acc_money) {
		this.lowest_acc_money = lowest_acc_money;
	}
	public int getHighest_acc_money() {
		return highest_acc_money;
	}
	public void setHighest_acc_money(int highest_acc_money) {
		this.highest_acc_money = highest_acc_money;
	}
	public int getDiscount_rate() {
		return discount_rate;
	}
	public void setDiscount_rate(int discount_rate) {
		this.discount_rate = discount_rate;
	}
	public String getReason_num() {
		return reason_num;
	}
	public void setReason_num(String reason_num) {
		this.reason_num = reason_num;
	}
	public String getReason_content() {
		return reason_content;
	}
	public void setReason_content(String reason_content) {
		this.reason_content = reason_content;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPost_code() {
		return post_code;
	}
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress_detail() {
		return address_detail;
	}
	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}
	public String getShip_post_code() {
		return ship_post_code;
	}
	public void setShip_post_code(String ship_post_code) {
		this.ship_post_code = ship_post_code;
	}
	public String getShip_address() {
		return ship_address;
	}
	public void setShip_address(String ship_address) {
		this.ship_address = ship_address;
	}
	public String getShip_address_detail() {
		return ship_address_detail;
	}
	public void setShip_address_detail(String ship_address_detail) {
		this.ship_address_detail = ship_address_detail;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public String getReal_img_name() {
		return real_img_name;
	}
	public void setReal_img_name(String real_img_name) {
		this.real_img_name = real_img_name;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getAcc_money() {
		return acc_money;
	}
	public void setAcc_money(int acc_money) {
		this.acc_money = acc_money;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	public String getPasswd_change_date() {
		return passwd_change_date;
	}
	public void setPasswd_change_date(String passwd_change_date) {
		this.passwd_change_date = passwd_change_date;
	}
	public String getLogin_date() {
		return login_date;
	}
	public void setLogin_date(String login_date) {
		this.login_date = login_date;
	}
	public int getOrder_count() {
		return order_count;
	}
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}
	public int getTop_level() {
		return top_level;
	}
	public void setTop_level(int top_level) {
		this.top_level = top_level;
	}
	public int getNomal() {
		return nomal;
	}
	public void setNomal(int nomal) {
		this.nomal = nomal;
	}
	public int getSuspension() {
		return suspension;
	}
	public void setSuspension(int suspension) {
		this.suspension = suspension;
	}
	public int getWithdrawal() {
		return withdrawal;
	}
	public void setWithdrawal(int withdrawal) {
		this.withdrawal = withdrawal;
	}
	
}
