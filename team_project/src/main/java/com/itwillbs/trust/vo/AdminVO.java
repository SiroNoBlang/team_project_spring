package com.itwillbs.trust.vo;

public class AdminVO {
	// 공지사항, 이벤트, QnA 변수
	private int num;
	private String nickname;
	private String date;
	private String title;
	private String content;
	private int readcount;
	private int re_ref;
	private int re_lev;
	private int re_seq;
	
	// Sales에 필요한 변수
	private String month;
	private int sell_total_money;
	private int sell_fee;
	private int buy_total_money;
	private int buy_fee;
	private int net_income;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getRe_ref() {
		return re_ref;
	}
	public void setRe_ref(int re_ref) {
		this.re_ref = re_ref;
	}
	public int getRe_lev() {
		return re_lev;
	}
	public void setRe_lev(int re_lev) {
		this.re_lev = re_lev;
	}
	public int getRe_seq() {
		return re_seq;
	}
	public void setRe_seq(int re_seq) {
		this.re_seq = re_seq;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getSell_total_money() {
		return sell_total_money;
	}
	public void setSell_total_money(int sell_total_money) {
		this.sell_total_money = sell_total_money;
	}
	public int getSell_fee() {
		return sell_fee;
	}
	public void setSell_fee(int sell_fee) {
		this.sell_fee = sell_fee;
	}
	public int getBuy_total_money() {
		return buy_total_money;
	}
	public void setBuy_total_money(int buy_total_money) {
		this.buy_total_money = buy_total_money;
	}
	public int getBuy_fee() {
		return buy_fee;
	}
	public void setBuy_fee(int buy_fee) {
		this.buy_fee = buy_fee;
	}
	public int getNet_income() {
		return net_income;
	}
	public void setNet_income(int net_income) {
		this.net_income = net_income;
	}
	
}
