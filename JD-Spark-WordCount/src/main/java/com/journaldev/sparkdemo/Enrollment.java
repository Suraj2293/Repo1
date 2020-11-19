package com.journaldev.sparkdemo;

import java.io.Serializable;

public class Enrollment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cid;
	private String cname;
	private String score;
	private String e_status;
	private String e_cid;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getE_status() {
		return e_status;
	}
	public void setE_status(String e_status) {
		this.e_status = e_status;
	}
	public String getE_cid() {
		return e_cid;
	}
	public void setE_cid(String e_cid) {
		this.e_cid = e_cid;
	}
	
	
}
