package net.developia.restful.user;

import java.io.Serializable;

import org.apache.commons.codec.digest.DigestUtils;

public class UserVO implements Serializable{

	private long user_no ;
	private String user_id ;
	private String user_pw ;
	private String user_name ;
	private String user_info ;
	private int user_level ;
	private int user_status ;
	private String user_regdate ;
	private String user_lastlogin ;
	private int user_logcnt ;
	private String user_ip ;
	private String user_zipcode ;
	private String user_address;
	private String user_address_detail;
	
	public long getUser_no() {
		return user_no;
	}
	public void setUser_no(long user_no) {
		this.user_no = user_no;
	}
	@Override
	public String toString() {
		return "UserVO [user_no=" + user_no + ", user_id=" + user_id + ", user_pw=" + user_pw + ", user_name="
				+ user_name + ", user_info=" + user_info + ", user_level=" + user_level + ", user_status=" + user_status
				+ ", user_regdate=" + user_regdate + ", user_lastlogin=" + user_lastlogin + ", user_logcnt="
				+ user_logcnt + ", user_ip=" + user_ip + ", user_zipcode=" + user_zipcode + ", user_address="
				+ user_address + ", user_address_detail=" + user_address_detail + ", getUser_no()=" + getUser_no()
				+ ", getUser_id()=" + getUser_id() + ", getUser_pw()=" + getUser_pw() + ", getUser_name()="
				+ getUser_name() + ", getUser_info()=" + getUser_info() + ", getUser_level()=" + getUser_level()
				+ ", getUser_status()=" + getUser_status() + ", getUser_regdate()=" + getUser_regdate()
				+ ", getUser_lastlogin()=" + getUser_lastlogin() + ", getUser_logcnt()=" + getUser_logcnt()
				+ ", getUser_ip()=" + getUser_ip() + ", getUser_zipcode()=" + getUser_zipcode() + ", getUser_address()="
				+ getUser_address() + ", getUser_address_detail()=" + getUser_address_detail() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = DigestUtils.sha512Hex(user_pw);  //암호화 
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_info() {
		return user_info;
	}
	public void setUser_info(String user_info) {
		this.user_info = user_info;
	}
	public int getUser_level() {
		return user_level;
	}
	public void setUser_level(int user_level) {
		this.user_level = user_level;
	}
	public int getUser_status() {
		return user_status;
	}
	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}
	public String getUser_regdate() {
		return user_regdate;
	}
	public void setUser_regdate(String user_regdate) {
		this.user_regdate = user_regdate;
	}
	public String getUser_lastlogin() {
		return user_lastlogin;
	}
	public void setUser_lastlogin(String user_lastlogin) {
		this.user_lastlogin = user_lastlogin;
	}
	public int getUser_logcnt() {
		return user_logcnt;
	}
	public void setUser_logcnt(int user_logcnt) {
		this.user_logcnt = user_logcnt;
	}
	public String getUser_ip() {
		return user_ip;
	}
	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}
	public String getUser_zipcode() {
		return user_zipcode;
	}
	public void setUser_zipcode(String user_zipcode) {
		this.user_zipcode = user_zipcode;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_address_detail() {
		return user_address_detail;
	}
	public void setUser_address_detail(String user_address_detail) {
		this.user_address_detail = user_address_detail;
	}
	
	
}
